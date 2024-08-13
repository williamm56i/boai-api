package org.boai.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    BoaiUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!HttpMethod.OPTIONS.matches(request.getMethod())) {
            String bearerToken = request.getHeader("Authorization");
            if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                String jwt = bearerToken.substring(7); // 去除"Bearer "前缀，得到Token
                UserDetails userDetails = userDetailsService.loadUserByUsername(jwt);
                SecurityContextHolder.getContext().setAuthentication(new BoaiAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
            } else {
                SecurityContextHolder.getContext().setAuthentication(null);
                request.getSession().invalidate();
            }
        }
        filterChain.doFilter(request, response);
    }
}
