package org.somrainc.com.controller.auth;

import org.somrainc.com.dto.AuthDTO;
import org.somrainc.com.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public void login(@RequestBody AuthDTO authDTO) {
        authService.login(authDTO);
    }

    @GetMapping("logout")
    public void logout() {
        SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
