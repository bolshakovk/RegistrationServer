package org.bolshakovk.registrationServer.service;

import org.bolshakovk.registrationServer.controllers.PublicController;
import org.bolshakovk.registrationServer.models.Role;
import org.bolshakovk.registrationServer.models.User;
import org.bolshakovk.registrationServer.repositories.RoleRepository;
import org.bolshakovk.registrationServer.repositories.UserRepository;
import org.bolshakovk.registrationServer.requests.SignupRequest;
import org.bolshakovk.registrationServer.responses.MessageResponse;
import org.bolshakovk.registrationServer.service.impl.RegisterService;
import org.bolshakovk.registrationServer.utils.ERole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    @Override
    public ResponseEntity<?> register(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        logger.info("user created " + user);
        if (strRoles == null) {
            logger.info("strRoles is null");
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            logger.info("strRoles is not null: " + strRoles);
            strRoles.forEach(role -> {
                switch (role)  {
                    case "admin":
                        logger.info("in case admin");
                        logger.info("all: " + roleRepository.findAll().toString());
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        logger.info("in case user");
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                        break;
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
