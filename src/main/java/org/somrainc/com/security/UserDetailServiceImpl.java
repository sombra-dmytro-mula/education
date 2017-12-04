package org.somrainc.com.security;

import org.somrainc.com.common.UserRole;
import org.somrainc.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("Init parameters method [load user by username] === >>> " + username);
        org.somrainc.com.model.User userFromDB = userRepository.findByUsername(username);
        if (userFromDB == null) {
            throw new BadCredentialsException(username);
        }

        UserRole role = userFromDB.getRole();
        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return new User(userFromDB.getUsername(), userFromDB.getPassword(), true,
                true, true, true, authorities);
    }
}

