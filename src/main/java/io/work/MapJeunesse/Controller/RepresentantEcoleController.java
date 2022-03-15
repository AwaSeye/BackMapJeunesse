package io.work.MapJeunesse.Controller;

import io.work.MapJeunesse.entity.RepresentantEcole;
import io.work.MapJeunesse.services.RepresentantEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/representantEcole")
public class RepresentantEcoleController {
    @Autowired
    private RepresentantEcoleService representantEcoleService;

    @GetMapping
    public List<RepresentantEcole> getAllRepresentantEcole(){

        return representantEcoleService.getAllRepresentantEcole();
    }

    @PostMapping
    public RepresentantEcole saveRepresentantEcole(@RequestBody RepresentantEcole representantEcole){
        return representantEcoleService.saveRepresentantEcole(representantEcole);
    }

    @PutMapping
    public RepresentantEcole updateRepresentantEcole(@RequestBody RepresentantEcole representantEcole){
        return representantEcoleService.updateRepresentantEcole(representantEcole);
    }

    @DeleteMapping("/{id}")
    public void deleteRepresentantEcole(@PathVariable Long id){
        representantEcoleService.deleteRepresentantEcole(id);
    }
}
