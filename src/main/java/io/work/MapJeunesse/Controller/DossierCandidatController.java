package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.DossierCandidat;
import io.work.MapJeunesse.services.DossierCandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/demandeEmploiStage")
public class DossierCandidatController {
    @Autowired
    private DossierCandidatService dossierCandidatService;

    @GetMapping
    public List<DossierCandidat> getAllDossierCandidat(){

        return dossierCandidatService.getAllDossierCandidat();
    }

    @PostMapping(consumes = {"application/json"})
    public DossierCandidat saveDossierCandidat(@RequestBody DossierCandidat dossierCandidat){
        return dossierCandidatService.saveDossierCandidat(dossierCandidat);
    }

    @PutMapping
    public DossierCandidat updateDossierCandidat(@RequestBody DossierCandidat dossierCandidat){
        return dossierCandidatService.updateDossierCandidat(dossierCandidat);
    }

    @DeleteMapping("/{id}")
    public void deleteDossierCandidat(@PathVariable Long id){
        dossierCandidatService.deleteDossierCandidat(id);
    }
}
