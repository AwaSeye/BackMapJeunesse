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

public class EmploiStage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String domaine;
    private String lieu;
    private String duree;
    private String type;
    private String poste;
    private String description;

    @ManyToMany
    private List<Candidat> candidatList = new ArrayList<>();

    @ManyToOne
    private Entretien entretien;


}
