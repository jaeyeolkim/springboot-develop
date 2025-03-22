package com.toy.springbootdevelop.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @SpringBootTest: SpringBootApplication이 있는 클래스를 찾고 그 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트를 만든다
 * @AutoConfigureMockMvc: MockMvc를 생성하고 자동으로 구성, 서버를 띄우지 않고도 테스트용 MVC 환경을 만들어 컨트롤러를 테스트할 때 사용되는 클래스
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("setUp ===================");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("tearDown ================");
        this.memberRepository.deleteAll();
    }

    @Test
    public void getAllMembers() throws Exception {
        final String url = "/members";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()))
        ;

    }
}
