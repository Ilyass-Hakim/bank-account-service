package org.hakim.bankaccountservice.repositories;

import org.hakim.bankaccountservice.entities.Compte;
import org.hakim.bankaccountservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, String> {
    List<Compte> findByType(TypeCompte type);
}
