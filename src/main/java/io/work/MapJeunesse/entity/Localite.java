package io.work.MapJeunesse.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class Localite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adresse;
    private String commune;
    private String departement;
    private String region;

    @ManyToOne
    private Candidat candidat;

    @ManyToMany
    private List<EcoleFormation> ecoles = new ArrayList<>();

    @ManyToMany
    private List<EntreprisePartenaire> entreprises = new ArrayList<>();




}
