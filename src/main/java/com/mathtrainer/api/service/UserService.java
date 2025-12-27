package com.mathtrainer.api.service;

import com.mathtrainer.api.dto.AuthRegisterDTO;
import com.mathtrainer.api.dto.AuthLoginDTO;
import com.mathtrainer.api.dto.AuthResponseDTO;
import com.mathtrainer.api.model.User;
import com.mathtrainer.api.repository.UserRepository;
import com.mathtrainer.api.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepo, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    // ----------------------------
    // REGISTRO
    // ----------------------------
    public AuthResponseDTO register(AuthRegisterDTO dto) {

        if (userRepo.existsByEmail(dto.email))
            throw new RuntimeException("Email já cadastrado");

        String hashed = encoder.encode(dto.senha);

        User u = new User(dto.nome, dto.email, hashed);
        userRepo.save(u);

        // 🔥 GERA TOKEN CORRETAMENTE
        String token = jwtUtil.generateToken(
                u.getEmail(), // subject
                Map.of(
                        "id", u.getId().toString(),
                        "nome", u.getNome()
                )
        );

        return new AuthResponseDTO(token, u.getId(), u.getNome(), u.getEmail());
    }

    // ----------------------------
    // LOGIN
    // ----------------------------
    public AuthResponseDTO login(AuthLoginDTO dto) {

        User u = userRepo.findByEmail(dto.email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(dto.senha, u.getSenhaHash()))
            throw new RuntimeException("Senha incorreta");

        // 🔥 GERA TOKEN CORRETAMENTE
        String token = jwtUtil.generateToken(
                u.getEmail(), // subject
                Map.of(
                        "id", u.getId().toString(),
                        "nome", u.getNome()
                )
        );

        return new AuthResponseDTO(token, u.getId(), u.getNome(), u.getEmail());
    }
}
