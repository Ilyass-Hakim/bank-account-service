package org.hakim.bankaccountservice.service;

import org.hakim.bankaccountservice.dto.CompteRequestDTO;
import org.hakim.bankaccountservice.dto.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    List<CompteResponseDTO> getComptes();
    CompteResponseDTO getCompte(String id);
    CompteResponseDTO addCompte(CompteRequestDTO compteDTO);
    CompteResponseDTO updateCompte(String id, CompteRequestDTO compteDTO);
    void deleteCompte(String id);
}
