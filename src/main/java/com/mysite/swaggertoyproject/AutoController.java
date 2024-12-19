package com.mysite.swaggertoyproject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth Controller", description = "인증 컨트롤러")
@RestController
@RequestMapping
public class AutoController {

    @SecurityRequirement(name = "JWT")
    @Operation(summary = "로그인", description = "사용자 이름으로 JWT 토큰 생성")
    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return JwtUtil.generateToken(username);
    }

    @SecurityRequirement(name = "TEST")
    @Operation(summary = "보호된 엔드포인트", description = "JWT 인증 필요")
    @GetMapping("/protected")
    public String protectedEndpoint(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.validateToken(token.replace("Bearer ", ""));
        return "Hello, " + username + "! This is a protected endpoint.";
    }
}
