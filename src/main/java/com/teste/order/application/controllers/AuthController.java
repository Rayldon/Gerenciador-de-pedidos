package com.teste.order.application.controllers;

import com.teste.order.application.dto.LoginDTO;
import com.teste.order.infrastructure.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public String createToken(@RequestBody LoginDTO login) {
        String username = login.getUsername();
        String password = login.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenUtil.generateToken(username);
    }
}

