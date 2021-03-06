package io.work.MapJeunesse.repositories;

import io.work.MapJeunesse.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long>
{
    public List<Projet> findByDomaineActivite(String domaineActivite);
    public List<Projet> findByIntitule(String intitule);
    public List<Projet> findByContenu(String contenu);
    public List<Projet> findByRegion(Date region);
}
