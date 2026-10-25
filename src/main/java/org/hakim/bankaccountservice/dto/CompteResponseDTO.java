package org.hakim.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hakim.bankaccountservice.enums.TypeCompte;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteResponseDTO {
    private String id;
    private Date dateCreation;
    private Double solde;
    private String devise;
    private TypeCompte type;
}
