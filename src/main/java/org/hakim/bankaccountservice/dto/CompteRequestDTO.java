package org.hakim.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hakim.bankaccountservice.enums.TypeCompte;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteRequestDTO {
    private Double solde;
    private String devise;
    private TypeCompte type;
}
