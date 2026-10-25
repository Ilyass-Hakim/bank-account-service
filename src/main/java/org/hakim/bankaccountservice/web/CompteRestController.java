package org.hakim.bankaccountservice.web;

import org.hakim.bankaccountservice.dto.CompteRequestDTO;
import org.hakim.bankaccountservice.dto.CompteResponseDTO;
import org.hakim.bankaccountservice.service.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {

    private final CompteService compteService;

    public CompteRestController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/comptes")
    public List<CompteResponseDTO> comptes() {
        return compteService.getComptes();
    }

    @GetMapping("/comptes/{id}")
    public CompteResponseDTO compte(@PathVariable String id) {
        return compteService.getCompte(id);
    }

    @PostMapping("/comptes")
    @ResponseStatus(HttpStatus.CREATED)
    public CompteResponseDTO save(@RequestBody CompteRequestDTO compteDTO) {
        return compteService.addCompte(compteDTO);
    }

    @PutMapping("/comptes/{id}")
    public CompteResponseDTO update(@PathVariable String id, @RequestBody CompteRequestDTO compteDTO) {
        return compteService.updateCompte(id, compteDTO);
    }

    @DeleteMapping("/comptes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        compteService.deleteCompte(id);
    }
}
