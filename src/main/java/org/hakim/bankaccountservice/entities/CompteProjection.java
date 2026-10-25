package org.hakim.bankaccountservice.entities;

import org.hakim.bankaccountservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class, name = "p1")
public interface CompteProjection {
    String getId();
    Double getSolde();
    TypeCompte getType();
}
