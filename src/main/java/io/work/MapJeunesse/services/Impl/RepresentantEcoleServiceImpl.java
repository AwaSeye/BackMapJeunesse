package io.work.MapJeunesse.services.Impl;

import io.work.MapJeunesse.entity.RepresentantEcole;
import io.work.MapJeunesse.exceptions.ResourceNotFoundException;
import io.work.MapJeunesse.repositories.RepresentantEcoleRepository;
import io.work.MapJeunesse.services.RepresentantEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentantEcoleServiceImpl implements RepresentantEcoleService {
    @Autowired
    private RepresentantEcoleRepository representantEcoleRepository;

    @Override
    public List<RepresentantEcole> getAllRepresentantEcole() {
        return representantEcoleRepository.findAll();
    }

    @Override
    public RepresentantEcole saveRepresentantEcole(RepresentantEcole representantEcole) {
        return representantEcoleRepository.save(representantEcole);
    }

    @Override
    public RepresentantEcole updateRepresentantEcole(RepresentantEcole representantEcole) {
        return representantEcoleRepository.findById(representantEcole.getId())
                .map(article1 -> {
                    return representantEcoleRepository.saveAndFlush(representantEcole);
                })
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
    }

    @Override
    public void deleteRepresentantEcole(Long id) {

        representantEcoleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ce representant n'existe pas"));
        representantEcoleRepository.deleteById(id);
    }
}
