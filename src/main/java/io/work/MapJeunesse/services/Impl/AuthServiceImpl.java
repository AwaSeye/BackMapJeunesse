/*package io.work.MapJeunesse.services.Impl;

import io.work.MapJeunesse.entity.Role;
import io.work.MapJeunesse.entity.Utilisateur;
import io.work.MapJeunesse.repositories.RoleRepository;
import io.work.MapJeunesse.repositories.UtilisateurRepository;

import io.work.MapJeunesse.security.request.LoginRequest;
import io.work.MapJeunesse.security.request.SignupRequest;
import io.work.MapJeunesse.security.response.JwtResponse;
import io.work.MapJeunesse.security.response.MessageResponse;
import io.work.MapJeunesse.security.service.UserDetailsImpl;
import io.work.MapJeunesse.services.AuthService;
import io.work.MapJeunesse.utils.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {



    final private UtilisateurRepository utilisateurRepository;

    final private RoleRepository roleRepository;

    public AuthServiceImpl(UtilisateurRepository utilisateurRepository,
                           RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        if (utilisateurRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (utilisateurRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create new user's account
        Utilisateur utilisateur = Utilisateur.builder()
                .nom(signupRequest.getNom())
                .prenom(signupRequest.getPrenom())
                .age(signupRequest.getAge())
                .sexe(signupRequest.getSexe())
                .adresse(signupRequest.getAdresse())
                .telephone(signupRequest.getTelephone())
                .region(signupRequest.getRegion())
                .dateInscription(signupRequest.getDateInscription())
                .adresseActuelle(signupRequest.getAdresseActuelle())
                .email(signupRequest.getEmail())
                .username(signupRequest.getUsername())
                .build();

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        utilisateur.setRoles(roles);
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}*/
