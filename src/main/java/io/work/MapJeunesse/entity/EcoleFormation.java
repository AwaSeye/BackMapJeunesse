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

public class EcoleFormation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomEcole;
    private String filiere;
    private String dureeFormation;
    private String description;

    @ManyToMany
    private List<Candidat> candidats = new ArrayList<>();

}
