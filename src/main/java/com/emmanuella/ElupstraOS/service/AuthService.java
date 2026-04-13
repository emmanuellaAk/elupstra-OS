package com.emmanuella.ElupstraOS.service;

import com.emmanuella.ElupstraOS.config.JwtService;
import com.emmanuella.ElupstraOS.dto.AuthResponse;
import com.emmanuella.ElupstraOS.dto.LoginRequest;
import com.emmanuella.ElupstraOS.model.User;
import com.emmanuella.ElupstraOS.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager,UserRepository userRepository,JwtService jwtService){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
       User user =  userRepository.findByEmail(request.getEmail() )
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return AuthResponse.builder()
                .email(user.getEmail())
                .token(jwtService.generateToken(user))
                .build();
    }
}
