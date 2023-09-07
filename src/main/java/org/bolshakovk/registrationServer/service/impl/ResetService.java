package org.bolshakovk.registrationServer.service.impl;

import org.bolshakovk.registrationServer.requests.ResetRequest;
import org.springframework.http.ResponseEntity;

public interface ResetService {
    ResponseEntity<?> resetPassword(ResetRequest resetRequest);
}
