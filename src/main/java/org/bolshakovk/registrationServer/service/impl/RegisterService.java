package org.bolshakovk.registrationServer.service.impl;

import org.bolshakovk.registrationServer.requests.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<?> register(SignupRequest signupRequest);
}
