package io.work.MapJeunesse.services.Impl;

import io.work.MapJeunesse.entity.RepresentantEcole;
import io.work.MapJeunesse.entity.RepresentantEquipeProjet;
import io.work.MapJeunesse.exceptions.ResourceNotFoundException;
import io.work.MapJeunesse.repositories.RepresentantEcoleRepository;
import io.work.MapJeunesse.repositories.RepresentantEquipeProjetRepository;
import io.work.MapJeunesse.services.RepresentantEcoleService;
import io.work.MapJeunesse.services.RepresentantEquipeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentantEquipeProjetServiceImpl implements RepresentantEquipeProjetService {
    @Autowired
    private RepresentantEquipeProjetRepository representantEquipeProjetRepository;

    @Override
    public List<RepresentantEquipeProjet> getAllRepresentantEquipeProjet() {
        return representantEquipeProjetRepository.findAll();
    }

    @Override
    public RepresentantEquipeProjet saveRepresentantEquipeProjet(RepresentantEquipeProjet representantEquipeProjet) {
        return representantEquipeProjetRepository.save(representantEquipeProjet);
    }

    @Override
    public RepresentantEquipeProjet updateRepresentantEquipeProjet(RepresentantEquipeProjet representantEquipeProjet) {
        return representantEquipeProjetRepository.findById(representantEquipeProjet.getId())
                .map(article1 -> {
                    return representantEquipeProjetRepository.saveAndFlush(representantEquipeProjet);
                })
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
    }

    @Override
    public void deleteRepresentantEquipeProjet(Long id) {

        representantEquipeProjetRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
        representantEquipeProjetRepository.deleteById(id);
    }
}
