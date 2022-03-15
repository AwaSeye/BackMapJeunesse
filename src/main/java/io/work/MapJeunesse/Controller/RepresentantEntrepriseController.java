package io.work.MapJeunesse.Controller;

import io.work.MapJeunesse.entity.RepresentantEntreprise;
import io.work.MapJeunesse.services.RepresentantEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/representantEntreprise")
public class RepresentantEntrepriseController {
    @Autowired
    private RepresentantEntrepriseService representantEntrepriseService;

    @GetMapping
    public List<RepresentantEntreprise> getAllRepresentantEntreprise(){

        return representantEntrepriseService.getAllRepresentantEntreprise();
    }

    @PostMapping
    public RepresentantEntreprise saveRepresentantEntreprise(@RequestBody RepresentantEntreprise representantEntreprise){
        return representantEntrepriseService.saveRepresentantEntreprise(representantEntreprise);
    }

    @PutMapping
    public RepresentantEntreprise updateRepresentantEntreprise(@RequestBody RepresentantEntreprise representantEntreprise){
        return representantEntrepriseService.updateRepresentantEntreprise(representantEntreprise);
    }

    @DeleteMapping("/{id}")
    public void deleteRepresentantEntreprise(@PathVariable Long id){
        representantEntrepriseService.deleteRepresentantEntreprise(id);
    }
}
