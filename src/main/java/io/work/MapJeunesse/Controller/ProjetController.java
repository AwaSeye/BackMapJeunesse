package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.Projet;
import io.work.MapJeunesse.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/projet")
public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @GetMapping
    public List<Projet> getAllProjet(){

        return projetService.getAllProjet();
    }

    @PostMapping(consumes = {"application/json"})
    public Projet saveProjet(@RequestBody Projet projet){
        return projetService.saveProjet(projet);
    }

    @PutMapping
    public Projet updateProjet(@RequestBody Projet projet){
        return projetService.updateProjet(projet);
    }

    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable Long id){
        projetService.deleteProjet(id);
    }
}
