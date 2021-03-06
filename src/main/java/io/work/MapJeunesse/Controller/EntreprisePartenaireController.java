package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.EntreprisePartenaire;
import io.work.MapJeunesse.services.EntreprisePartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/entreprise")
public class EntreprisePartenaireController {
    @Autowired
    private EntreprisePartenaireService entreprisePartenaireService;

    @GetMapping
    public List<EntreprisePartenaire> getAllEntreprisePartenaire(){

        return entreprisePartenaireService.getAllEntreprisePartenaire();
    }

    @PostMapping(consumes = {"application/json"})
    public EntreprisePartenaire saveEntreprisePartenaire(@RequestBody EntreprisePartenaire entreprisePartenaire){
        return entreprisePartenaireService.saveEntreprisePartenaire(entreprisePartenaire);
    }

    @PutMapping
    public EntreprisePartenaire updateEntreprisePartenaire(@RequestBody EntreprisePartenaire entreprisePartenaire){
        return entreprisePartenaireService.updateEntreprisePartenaire(entreprisePartenaire);
    }

    @DeleteMapping("/{id}")
    public void deleteEntreprisePartenaire(@PathVariable Long id){
        entreprisePartenaireService.deleteEntreprisePartenaire(id);
    }
}
