package com.toy.springbootdevelop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return testService.getAllMembers();
    }
}
