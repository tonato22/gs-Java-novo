package com.example.api.controller;

import com.example.api.model.Usuario;
import com.example.api.repository.UsuarioRepository;
import com.example.api.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static class LoginRequest {
        public String email;
        public String senha;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
    }

    public static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(login.getEmail());

        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(login.getSenha())) {
            String token = jwtUtil.generateToken(login.getEmail());
            return ResponseEntity.ok(new TokenResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    // ✅ CADASTRO
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody @Valid Usuario usuario) {
        // Verifica se já existe um usuário com o mesmo email
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
        }

        Usuario salvo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}