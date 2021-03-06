package io.work.MapJeunesse.Controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.Candidat;
import io.work.MapJeunesse.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/candidat")

public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public List<Candidat> getAllCandidat(){

        return candidatService.getAllCandidat();
    }

    @PostMapping(consumes = {"application/json"})
    public Candidat saveCandidat(@RequestBody Candidat candidat){
        return candidatService.saveCandidat(candidat);
    }

    @PutMapping
    public Candidat updateCandidat(@RequestBody Candidat candidat){
        return candidatService.updateCandidat(candidat);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidat(@PathVariable Long id){
        candidatService.deleteCandidat(id);
    }
}





