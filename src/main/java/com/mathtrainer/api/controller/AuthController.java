package com.mathtrainer.api.controller;

import com.mathtrainer.api.dto.AuthRegisterDTO;
import com.mathtrainer.api.dto.AuthLoginDTO;
import com.mathtrainer.api.dto.AuthResponseDTO;
import com.mathtrainer.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService){this.userService = userService;}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRegisterDTO dto) {
        try { AuthResponseDTO res = userService.register(dto); return ResponseEntity.ok(res); }
        catch (Exception e){ return ResponseEntity.badRequest().body(e.getMessage()); }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginDTO dto) {
        try { AuthResponseDTO res = userService.login(dto); return ResponseEntity.ok(res); }
        catch (Exception e){ return ResponseEntity.status(401).body(e.getMessage()); }
    }
}
