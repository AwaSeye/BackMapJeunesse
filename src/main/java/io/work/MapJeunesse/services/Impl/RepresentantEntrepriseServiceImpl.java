package io.work.MapJeunesse.services.Impl;

import io.work.MapJeunesse.entity.RepresentantEcole;
import io.work.MapJeunesse.entity.RepresentantEntreprise;
import io.work.MapJeunesse.exceptions.ResourceNotFoundException;
import io.work.MapJeunesse.repositories.RepresentantEcoleRepository;
import io.work.MapJeunesse.repositories.RepresentantEntrepriseRepository;
import io.work.MapJeunesse.services.RepresentantEcoleService;
import io.work.MapJeunesse.services.RepresentantEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentantEntrepriseServiceImpl implements RepresentantEntrepriseService {
    @Autowired
    private RepresentantEntrepriseRepository representantEntrepriseRepository;

    @Override
    public List<RepresentantEntreprise> getAllRepresentantEntreprise() {
        return representantEntrepriseRepository.findAll();
    }

    @Override
    public RepresentantEntreprise saveRepresentantEntreprise(RepresentantEntreprise representantEntreprise) {
        return representantEntrepriseRepository.save(representantEntreprise);
    }

    @Override
    public RepresentantEntreprise updateRepresentantEntreprise(RepresentantEntreprise representantEntreprise) {
        return representantEntrepriseRepository.findById(representantEntreprise.getId())
                .map(article1 -> {
                    return representantEntrepriseRepository.saveAndFlush(representantEntreprise);
                })
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
    }

    @Override
    public void deleteRepresentantEntreprise(Long id) {

        representantEntrepriseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
        representantEntrepriseRepository.deleteById(id);
    }
}
