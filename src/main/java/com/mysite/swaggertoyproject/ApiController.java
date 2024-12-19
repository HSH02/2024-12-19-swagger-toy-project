package com.mysite.swaggertoyproject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API Management", description = "Example API")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Operation(summary = "GET 예제", description = "환영 메시지를 반환합니다.")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Swagger with Gradle!";
    }

    @Operation(summary = "POST 예제", description = "샘플 요청을 받아 확인 메시지를 반환합니다.")
    @PostMapping("/submit")
    public String submitData(@RequestBody String data) {
        return "Data submitted: " + data;
    }

    @Operation(summary = "PUT 예제", description = "제공된 데이터로 리소스를 업데이트합니다.")
    @PutMapping("/update")
    public String updateData(@RequestBody String data) {
        return "Data updated to: " + data;
    }

    @Operation(summary = "DELETE 예제", description = "리소스를 삭제합니다.")
    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Long id) {
        return "Data with ID " + id + " deleted.";
    }

    @Operation(summary = "PATCH 예제", description = "리소스를 부분적으로 수정합니다.")
    @PatchMapping("/modify/{id}")
    public String modifyData(@PathVariable("id") Long id, @RequestBody String partialData) {
        return "Data with ID " + id + " modified with: " + partialData;
    }

    @Operation(summary = "요청 매핑 예제", description = "사용자 지정 요청 매핑을 처리합니다.")
    @RequestMapping(value = "/custom", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleCustomRequest() {
        return "Custom request mapping executed.";
    }
}
