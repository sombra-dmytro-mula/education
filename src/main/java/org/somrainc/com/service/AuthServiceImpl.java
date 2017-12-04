package org.somrainc.com.service;

import org.somrainc.com.dto.AuthDTO;
import org.somrainc.com.model.User;
import org.somrainc.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;

    @Override
    public void login(AuthDTO authDTO) {
        User user = userRepository.findByUsername(authDTO.getUsername());
        if (user == null) {
            System.err.println("Bad username");
            return;
        }
        if (!passwordEncoder.matches(authDTO.getPassword(), user.getPassword())) {
            System.err.println("Failed to authenticate : " + authDTO.getUsername());
            return;
        }
        createSpringSession(authDTO, user);
    }

    @Override
    public void logout() {

    }

    private void createSpringSession(AuthDTO loginDTO, User userFromDB) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginDTO.getUsername().trim(), loginDTO.getPassword());
        Authentication authentication;
        try {
            authentication = this.authManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {
            System.err.println("Failed to authenticate : " + loginDTO.getUsername());
        }
    }

}
