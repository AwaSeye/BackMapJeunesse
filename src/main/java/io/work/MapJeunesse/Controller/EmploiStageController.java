package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.EmploiStage;
import io.work.MapJeunesse.services.EmploiStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/emploiStage")
public class EmploiStageController {
    @Autowired
    private EmploiStageService emploiStageService;

    @GetMapping
    public List<EmploiStage> getAllEmploiStage(){

        return emploiStageService.getAllEmploiStage();
    }

    @PostMapping(consumes = {"application/json"})
    public EmploiStage saveEmploiStage(@RequestBody EmploiStage emploiStage){
        return emploiStageService.saveEmploiStage(emploiStage);
    }

    @PutMapping
    public EmploiStage updateEmploiStage(@RequestBody EmploiStage emploiStage){
        return emploiStageService.updateEmploiStage(emploiStage);
    }

    @DeleteMapping("/{id}")
    public void deleteEmploiStage(@PathVariable Long id){
        emploiStageService.deleteEmploiStage(id);
    }
}
