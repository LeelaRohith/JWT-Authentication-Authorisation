package com.rohith.jwtAuthentication.demo;

import com.rohith.jwtAuthentication.config.JwtService;
import com.rohith.jwtAuthentication.user.User;
import com.rohith.jwtAuthentication.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {
    private final JwtService jwtService;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(Authentication authentication){
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        return ResponseEntity.ok(user.get().getFirstname());
    }
}
