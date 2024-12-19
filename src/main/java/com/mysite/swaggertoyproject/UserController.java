package com.mysite.swaggertoyproject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Management", description = "사용자 관리 API")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
    @PostMapping
    public User createUser(@RequestBody User user) {
        // 요청 데이터를 그대로 응답으로 반환
        return user;
    }

    @Operation(summary = "사용자 조회", description = "ID로 사용자 정보를 조회")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(value = "{\"id\":1, \"name\":\"홍길동\", \"email\":\"hong@example.com\"}")
    ))
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "홍길동", "hong@example.com");
    }
}