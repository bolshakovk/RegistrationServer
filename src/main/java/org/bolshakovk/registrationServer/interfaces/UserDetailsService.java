package org.bolshakovk.registrationServer.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadByUserEmail(String email) throws UsernameNotFoundException;
}
