package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.RepresentantEquipeProjet;
import io.work.MapJeunesse.services.RepresentantEquipeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/representantEquipeProjet")
public class RepresentantEquipeProjetController {
    @Autowired
    private RepresentantEquipeProjetService representantEquipeProjetService;

    @GetMapping
    public List<RepresentantEquipeProjet> getAllRepresentantEquipeProjet(){

        return representantEquipeProjetService.getAllRepresentantEquipeProjet();
    }

    @PostMapping(consumes = {"application/json"})
    public RepresentantEquipeProjet saveRepresentantEquipeProjet(@RequestBody RepresentantEquipeProjet representantEquipeProjet){
        return representantEquipeProjetService.saveRepresentantEquipeProjet(representantEquipeProjet);
    }

    @PutMapping
    public RepresentantEquipeProjet updateRepresentantEquipeProjet(@RequestBody RepresentantEquipeProjet representantEquipeProjet){
        return representantEquipeProjetService.updateRepresentantEquipeProjet(representantEquipeProjet);
    }

    @DeleteMapping("/{id}")
    public void deleteRepresentantEquipeProjet(@PathVariable Long id){
        representantEquipeProjetService.deleteRepresentantEquipeProjet(id);
    }
}
