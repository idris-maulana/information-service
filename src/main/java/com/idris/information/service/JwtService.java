package com.idris.information.service;

import com.idris.information.model.User;
import com.idris.information.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    @Autowired
    UserRepository userRepository;

    public User verifyToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes());
            String email = Jwts.parser().verifyWith(key).build().parseSignedClaims( token.replaceFirst("Bearer", "").trim() ).getPayload().get("email", String.class);
            return userRepository.getUserByEmail(email).get();
        } catch (Exception ex) {
            return null;
        }
    }
}
