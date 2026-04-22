package fr.eni.bookhubback.controller;

import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.mapper.DTOLoginRequest;
import fr.eni.bookhubback.mapper.DTOLoginResponse;
import fr.eni.bookhubback.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils; // ref vers notre class utilitaire de création de JWT

    @Autowired
    AuthenticationConfiguration authenticationConfiguration; // ref vers la classe d'authentification de Spring
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DTOLoginRequest request) {

        Authentication authenticationToken =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());

        try {
            Authentication authentication =
                    authenticationConfiguration.getAuthenticationManager().authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateJwtToken(authentication);

            return ResponseEntity.ok(
                    new DTOLoginResponse(jwt, "Connexion réussie")
            );

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new DTOLoginResponse(null, "Email ou mot de passe incorrect")
            );
        }
    }

}
