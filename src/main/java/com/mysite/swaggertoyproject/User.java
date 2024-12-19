package com.mysite.swaggertoyproject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "사용자 정보를 나타내는 객체")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Schema(description = "사용자의 ID", example = "1")
    private Long id;

    @Schema(description = "사용자의 이름", example = "홍길동")
    private String name;

    @Schema(description = "사용자의 이메일", example = "hong@domain.com")
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}