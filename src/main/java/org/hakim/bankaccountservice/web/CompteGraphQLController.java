package org.hakim.bankaccountservice.web;

import org.hakim.bankaccountservice.dto.CompteRequestDTO;
import org.hakim.bankaccountservice.dto.CompteResponseDTO;
import org.hakim.bankaccountservice.service.CompteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {

    private final CompteService compteService;

    public CompteGraphQLController(CompteService compteService) {
        this.compteService = compteService;
    }

    @QueryMapping
    public List<CompteResponseDTO> comptes() {
        return compteService.getComptes();
    }

    @QueryMapping
    public CompteResponseDTO compteById(@Argument String id) {
        return compteService.getCompte(id);
    }

    @MutationMapping
    public CompteResponseDTO addCompte(@Argument CompteRequestDTO compte) {
        return compteService.addCompte(compte);
    }

    @MutationMapping
    public CompteResponseDTO updateCompte(@Argument String id, @Argument CompteRequestDTO compte) {
        return compteService.updateCompte(id, compte);
    }

    @MutationMapping
    public Boolean deleteCompte(@Argument String id) {
        compteService.deleteCompte(id);
        return true;
    }
}
