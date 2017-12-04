package org.somrainc.com.utils;

import org.somrainc.com.common.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;

public class UtilHelper {

    public static void putUserFromPropertiesToSession(String username, String password, UserRole userRole) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(username, password,
                Collections.singletonList(new SimpleGrantedAuthority(userRole.name())));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

}
