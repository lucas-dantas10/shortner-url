package br.com.shortener_url.integration.controller.infra.adapter.rest.in;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.usecase.CreateShortUrlUseCase;
import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CreateShortUrlActionTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private CreateShortUrlUseCase createShortUrlUseCase;

    @Test
    void shouldCreateShortUrl() throws Exception {

        Url url = new Url("https://google.com", 1L, "salt");

        when(createShortUrlUseCase.execute(anyString())).thenReturn(url);

        CreateShortenRequest request = new CreateShortenRequest("https://google.com");

        mockMvc.perform(post("/api/v1/shorten")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.short_url").exists());
    }
}
