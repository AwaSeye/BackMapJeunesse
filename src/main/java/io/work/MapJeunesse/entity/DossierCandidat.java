package io.work.MapJeunesse.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class DossierCandidat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cv;
    private String lettreMotivation;
    private String domaine;
    private String niveau;
    private String profession;
    private String region;

}
