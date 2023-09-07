package org.bolshakovk.registrationServer.service;

import org.bolshakovk.registrationServer.requests.ResetRequest;
import org.bolshakovk.registrationServer.service.impl.ResetService;
import org.springframework.http.ResponseEntity;

public class ResetServiceImpl implements ResetService {
    @Override
    public ResponseEntity<?> resetPassword(ResetRequest resetRequest) {
        return null;
    }
}
