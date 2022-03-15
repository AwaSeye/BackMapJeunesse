package io.work.MapJeunesse.Controller;

import io.work.MapJeunesse.entity.Localite;
import io.work.MapJeunesse.services.LocaliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/localite")
public class LocaliteController {
    @Autowired
    private LocaliteService localiteService;

    @GetMapping
    public List<Localite> getAllLocalite(){

        return localiteService.getAllLocalite();
    }

    @PostMapping
    public Localite saveLocalite(@RequestBody Localite localite){
        return localiteService.saveLocalite(localite);
    }

    @PutMapping
    public Localite updateLocalite(@RequestBody Localite localite){
        return localiteService.updateLocalite(localite);
    }

    @DeleteMapping("/{id}")
    public void deleteLocalite(@PathVariable Long id){
        localiteService.deleteLocalite(id);
    }
}
