package org.bolshakovk.registrationServer.controllers;

import jakarta.validation.Valid;
import org.bolshakovk.registrationServer.repositories.RoleRepository;
import org.bolshakovk.registrationServer.repositories.UserRepository;
import org.bolshakovk.registrationServer.requests.LoginRequest;
import org.bolshakovk.registrationServer.requests.SignupRequest;
import org.bolshakovk.registrationServer.responses.JwtResponse;
import org.bolshakovk.registrationServer.service.impl.AuthenticationService;
import org.bolshakovk.registrationServer.service.impl.RegisterService;
import org.bolshakovk.registrationServer.service.UserDetailsImpl;
import org.bolshakovk.registrationServer.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class PublicController {
    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
    @Autowired
    RegisterService registerService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationService.authenticate(loginRequest);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return registerService.register(signUpRequest);
    }
    @PostMapping("reset-password")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody SignupRequest signUpRequest) {
        return registerService.register(signUpRequest);
    }
}
