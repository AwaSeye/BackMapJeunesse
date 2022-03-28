package io.work.MapJeunesse.security.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private String nom;

    private String prenom;
    private String age;
    private String adresse;
    private String adresseActuelle;
    private String region;
    private String sexe;
    private Date dateInscription;
    private String telephone;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;



}
