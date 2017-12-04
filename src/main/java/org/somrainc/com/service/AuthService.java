package org.somrainc.com.service;

import org.somrainc.com.dto.AuthDTO;

public interface AuthService {

    void login(AuthDTO authDTO);
    void logout();

}
