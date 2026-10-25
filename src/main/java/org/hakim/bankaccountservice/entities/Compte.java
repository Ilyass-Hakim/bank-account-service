package org.hakim.bankaccountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hakim.bankaccountservice.enums.TypeCompte;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    @Id
    private String id;

    private Date dateCreation;

    private Double solde;

    private String devise;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
