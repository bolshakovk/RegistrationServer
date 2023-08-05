package org.bolshakovk.registrationServer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class JwtResponse {
    String token;
    String type;
    Long id;
    String username;
    List<String> roles;
    String email;


    public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.email = email;
    }
}
