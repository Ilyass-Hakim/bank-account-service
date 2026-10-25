package org.hakim.bankaccountservice;

import org.hakim.bankaccountservice.entities.Compte;
import org.hakim.bankaccountservice.enums.TypeCompte;
import org.hakim.bankaccountservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            // Insertion de 10 comptes de test
            for (int i = 0; i < 10; i++) {
                Compte compte = Compte.builder()
                        .id(UUID.randomUUID().toString())
                        .dateCreation(new Date())
                        .solde(Math.round(Math.random() * 90000 + 10000) * 1.0)
                        .devise("MAD")
                        .type(Math.random() > 0.5 ? TypeCompte.COURANT : TypeCompte.EPARGNE)
                        .build();
                compteRepository.save(compte);
            }

            // Test de la couche DAO
            System.out.println("===== Tous les comptes (" + compteRepository.count() + ") =====");
            compteRepository.findAll().forEach(c ->
                    System.out.println(c.getId() + " | " + c.getType() + " | " + c.getSolde() + " " + c.getDevise()));

            System.out.println("===== Comptes EPARGNE =====");
            compteRepository.findByType(TypeCompte.EPARGNE).forEach(c ->
                    System.out.println(c.getId() + " | " + c.getSolde()));
        };
    }
}
