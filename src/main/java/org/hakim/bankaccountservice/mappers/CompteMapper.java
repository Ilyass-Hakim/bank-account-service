package org.hakim.bankaccountservice.mappers;

import org.hakim.bankaccountservice.dto.CompteRequestDTO;
import org.hakim.bankaccountservice.dto.CompteResponseDTO;
import org.hakim.bankaccountservice.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    // Entité -> DTO de réponse
    public CompteResponseDTO fromCompte(Compte compte) {
        CompteResponseDTO dto = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, dto);
        return dto;
    }

    // DTO de requête -> Entité (l'id et la date sont gérés par la couche service)
    public Compte fromCompteRequestDTO(CompteRequestDTO requestDTO) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(requestDTO, compte);
        return compte;
    }
}
