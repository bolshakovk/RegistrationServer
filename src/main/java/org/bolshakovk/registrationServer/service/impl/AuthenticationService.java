package org.bolshakovk.registrationServer.service.impl;

import org.bolshakovk.registrationServer.requests.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> authenticate(LoginRequest loginRequest);
}
