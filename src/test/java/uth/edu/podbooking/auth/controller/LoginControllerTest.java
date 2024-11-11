package uth.edu.podbooking.auth.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uth.edu.podbooking.domain.auth.dto.request.LoginRequest;
import uth.edu.podbooking.domain.auth.dto.respone.LoginResponse;
import uth.edu.podbooking.domain.auth.service.LoginService;



// khó quá thầy ơi
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    private LoginRequest loginRequest;
    private LoginResponse expectedResponse;

    @Autowired
    private MockMvc mockMvc; // tạo request tới LoginController

    @MockBean
    private LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class); // Khai báo Logger

    @BeforeEach
    public void setup() {
        loginRequest = new LoginRequest("a3144gmail.com", "123456");

        expectedResponse = new LoginResponse(true, "token_successfully");
    }


    @Test
    public void testLoginSuccess() throws Exception {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  // Đăng ký module xử lý ngày giờ
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String content = objectMapper.writeValueAsString(loginRequest);

        Mockito.when(loginService.auth(ArgumentMatchers.any())).thenReturn(expectedResponse);


        // when: ta request => Mock
        // Thực hiện POST request và kiểm tra phản hồi
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.result.authenticated").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.token").isNotEmpty());

    }


    @AfterEach
    public void tearDown() {
        logger.info("I'm testing login");
    }
}