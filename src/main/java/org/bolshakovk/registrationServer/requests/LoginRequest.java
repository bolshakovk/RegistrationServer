package org.bolshakovk.registrationServer.requests;

import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
}
