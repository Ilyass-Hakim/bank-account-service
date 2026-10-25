package org.hakim.bankaccountservice.repositories;

import org.hakim.bankaccountservice.entities.Compte;
import org.hakim.bankaccountservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "comptes")
public interface CompteRepository extends JpaRepository<Compte, String> {

    @RestResource(path = "byType")
    List<Compte> findByType(@Param("type") TypeCompte type);
}
