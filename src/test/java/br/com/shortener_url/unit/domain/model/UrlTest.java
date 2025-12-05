package br.com.shortener_url.unit.domain.model;

import br.com.shortener_url.domain.model.Url;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UrlTest {

    // TODO: Deve ser o mesmo usado na aplicação real!
    private static final String TEST_SALT = "meu_salt_secreto_para_testes";
    private static final String TEST_LONG_URL = "https://www.google.com/search?q=spring+boot+unit+test";

    @Test
    @DisplayName("Deve construir a URL com o shortcode e URL longa corretos")
    void shouldConstructUrlWithCorrectShortcodeAndLongUrl() {
        long counter = 1L;

        Url url = new Url(TEST_LONG_URL, counter, TEST_SALT);

        assertEquals(TEST_LONG_URL, url.getLongUrl(), "A URL longa deve ser a mesma passada no construtor.");

        assertNotNull(url.getShortcode(), "O shortcode não deve ser nulo.");
        assertTrue(url.getShortcode().length() >= 3, "O shortcode deve ter um comprimento mínimo de 3.");

        assertNotNull(url.getCreatedAt(), "A data de criação não deve ser nula.");
        assertTrue(url.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(1)), "A data de criação deve ser aproximadamente agora.");

        assertEquals("gQl", url.getShortcode(), "O shortcode deve ser 'gQl' para o counter 1 e salt de teste.");
    }

    @Test
    @DisplayName("Deve gerar shortcodes únicos para diferentes valores de counter")
    void shouldGenerateUniqueShortcodesForDifferentCounters() {
        int numberOfCodesToTest = 1000;
        Set<String> generatedShortcodes = new HashSet<>();

        for (long i = 1; i <= numberOfCodesToTest; i++) {
            Url url = new Url(TEST_LONG_URL + i, i, TEST_SALT);
            String shortcode = url.getShortcode();

            assertNotNull(shortcode);
            assertTrue(generatedShortcodes.add(shortcode),
                    "O shortcode '" + shortcode + "' foi repetido. O Hashids deve gerar IDs únicos para diferentes 'counters'.");
        }

        assertEquals(numberOfCodesToTest, generatedShortcodes.size(), "O Set deve conter o mesmo número de elementos gerados.");
    }

    @Test
    @DisplayName("O shortcode gerado deve ser imutável após a construção")
    void shortcodeShouldBeImmutableAfterConstruction() {
        Url url = new Url(TEST_LONG_URL, 50L, TEST_SALT);
        String initialShortcode = url.getShortcode();

        assertEquals(initialShortcode, url.getShortcode(), "O shortcode deve permanecer o mesmo após a construção.");
    }
}