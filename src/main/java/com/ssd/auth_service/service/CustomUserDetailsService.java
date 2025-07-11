package com.ssd.auth_service.service;

import com.ssd.auth_service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ResponseEntity<UserDTO> response = restTemplate.getForEntity(
                "http://localhost:8080/api/users/" + username,
                UserDTO.class
        );

        UserDTO user = response.getBody();
        if (user == null) throw new UsernameNotFoundException("User not found");

        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );

    }

}
