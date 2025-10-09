package com.sl2genform.controllers;

import com.sl2genform.dto.LoginRequest;
import com.sl2genform.dto.LoginResponse;
import com.sl2genform.security.JwtUtil;
import com.sl2genform.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Endpoints for user authentication")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Authenticate user and return JWT token")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    );


            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String jwt = jwtUtil.generateToken(userDetails);

            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetails;
            String fullName = userDetailsImpl.getUser().getName() + " " +
                    userDetailsImpl.getUser().getSurname();


            LoginResponse response = LoginResponse.builder()
                    .token(jwt)
                    .type("Bearer")  // Token type - tells client to use "Bearer" in Authorization header
                    .email(userDetails.getUsername())
                    .name(userDetailsImpl.getUser().getName())
                    .surname(userDetailsImpl.getUser().getSurname())
                    .user_id(userDetailsImpl.getUser().getUser_id())
                    .role(userDetailsImpl.getRole())
                    .avatar(userDetailsImpl.getUser().getAvatar())
                    .theme(userDetailsImpl.getUser().getTheme())
                    .build();

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {

            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body("An error occurred during authentication: " + e.getMessage());
        }
    }
}