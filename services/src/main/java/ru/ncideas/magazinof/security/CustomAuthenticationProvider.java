package ru.ncideas.magazinof.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.ncideas.magazinof.services.AuthenticationService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AuthenticationService authenticationService;

    public CustomAuthenticationProvider() {
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication == null)
            return null;

        return authenticationService.authenticate(
                (String) authentication.getPrincipal(),
                (String) authentication.getCredentials());
    }

    public boolean supports(Class authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
