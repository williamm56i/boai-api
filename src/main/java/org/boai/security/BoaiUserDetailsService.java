package org.boai.security;

import io.jsonwebtoken.Claims;
import org.boai.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class BoaiUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String jwt) throws UsernameNotFoundException {
        Claims claims = JwtUtils.parseJwt(jwt);
        if (claims == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return new BoaiUserDetails(claims.getSubject(), null, null);
    }

    public UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) ? (BoaiUserDetails) authentication.getPrincipal() : null;
    }

    public String getUsername() {
        return getUserDetails().getUsername();
    }
}
