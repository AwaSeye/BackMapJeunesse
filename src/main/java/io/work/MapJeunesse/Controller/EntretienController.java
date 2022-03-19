package io.work.MapJeunesse.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.work.MapJeunesse.entity.Entretien;
import io.work.MapJeunesse.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name="mapJeunesse")
@RequestMapping("/api/entretien")
public class EntretienController {
    @Autowired
    private EntretienService entretienService;

    @GetMapping
    public List<Entretien> getAllEntretien(){

        return entretienService.getAllEntretien();
    }

    @PostMapping(consumes = {"application/json"})
    public Entretien saveEntretien(@RequestBody Entretien entretien){
        return entretienService.saveEntretien(entretien);
    }

    @PutMapping
    public Entretien updateEntretien(@RequestBody Entretien entretien){
        return entretienService.updateEntretien(entretien);
    }

    @DeleteMapping("/{id}")
    public void deleteEntretien(@PathVariable Long id){
        entretienService.deleteEntretien(id);
    }
}
