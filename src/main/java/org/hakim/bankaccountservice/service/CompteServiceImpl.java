package org.hakim.bankaccountservice.service;

import org.hakim.bankaccountservice.dto.CompteRequestDTO;
import org.hakim.bankaccountservice.dto.CompteResponseDTO;
import org.hakim.bankaccountservice.entities.Compte;
import org.hakim.bankaccountservice.exceptions.CompteNotFoundException;
import org.hakim.bankaccountservice.mappers.CompteMapper;
import org.hakim.bankaccountservice.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    @Override
    public List<CompteResponseDTO> getComptes() {
        return compteRepository.findAll().stream()
                .map(compteMapper::fromCompte)
                .toList();
    }

    @Override
    public CompteResponseDTO getCompte(String id) {
        return compteMapper.fromCompte(findCompte(id));
    }

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO) {
        Compte compte = compteMapper.fromCompteRequestDTO(compteDTO);
        compte.setId(UUID.randomUUID().toString());
        compte.setDateCreation(new Date());
        return compteMapper.fromCompte(compteRepository.save(compte));
    }

    @Override
    public CompteResponseDTO updateCompte(String id, CompteRequestDTO compteDTO) {
        Compte compte = findCompte(id);
        if (compteDTO.getSolde() != null) compte.setSolde(compteDTO.getSolde());
        if (compteDTO.getDevise() != null) compte.setDevise(compteDTO.getDevise());
        if (compteDTO.getType() != null) compte.setType(compteDTO.getType());
        return compteMapper.fromCompte(compteRepository.save(compte));
    }

    @Override
    public void deleteCompte(String id) {
        compteRepository.delete(findCompte(id));
    }

    private Compte findCompte(String id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new CompteNotFoundException(id));
    }
}
