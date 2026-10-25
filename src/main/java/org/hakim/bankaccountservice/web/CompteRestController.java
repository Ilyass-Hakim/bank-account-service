package org.hakim.bankaccountservice.web;

import org.hakim.bankaccountservice.entities.Compte;
import org.hakim.bankaccountservice.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CompteRestController {

    private final CompteRepository compteRepository;

    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    public List<Compte> comptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte) {
        if (compte.getId() == null) compte.setId(UUID.randomUUID().toString());
        if (compte.getDateCreation() == null) compte.setDateCreation(new Date());
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable String id, @RequestBody Compte compte) {
        Compte existant = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
        if (compte.getSolde() != null) existant.setSolde(compte.getSolde());
        if (compte.getDevise() != null) existant.setDevise(compte.getDevise());
        if (compte.getType() != null) existant.setType(compte.getType());
        if (compte.getDateCreation() != null) existant.setDateCreation(compte.getDateCreation());
        return compteRepository.save(existant);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable String id) {
        compteRepository.deleteById(id);
    }
}
