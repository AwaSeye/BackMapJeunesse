package io.work.MapJeunesse.Controller;


import io.work.MapJeunesse.entity.PartenaireProjet;
import io.work.MapJeunesse.services.PartenaireProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/equipeProjet")
public class PartenaireProjetController {
    @Autowired
    private PartenaireProjetService partenaireProjetService;

    @GetMapping
    public List<PartenaireProjet> getAllPartenaireProjet(){

        return partenaireProjetService.getAllPartenaireProjet();
    }

    @PostMapping
    public PartenaireProjet savePartenaireProjet(@RequestBody PartenaireProjet partenaireProjet){
        return partenaireProjetService.savePartenaireProjet(partenaireProjet);
    }

    @PutMapping
    public PartenaireProjet updatePartenaireProjet(@RequestBody PartenaireProjet partenaireProjet){
        return partenaireProjetService.updatePartenaireProjet(partenaireProjet);
    }

    @DeleteMapping("/{id}")
    public void deletePartenaireProjet(@PathVariable Long id){
        partenaireProjetService.deletePartenaireProjet(id);
    }
}
