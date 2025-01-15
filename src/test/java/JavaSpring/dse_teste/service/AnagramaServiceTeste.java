package JavaSpring.dse_teste.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramaServiceTest {

    private final AnagramaService anagramaService = new AnagramaService();

    @Test
    void testEntradaVazia() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                anagramaService.gerarAnagramas("");
            }
        });
        assertEquals("A entrada não pode estar vazia.", exception.getMessage());
    }

    @Test
    void testEntradaUmaLetra() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                anagramaService.gerarAnagramas("a");
            }
        });
        assertEquals("Insira mais de uma letra, por favor.", exception.getMessage());
    }

    @Test
    void testEntradaVariasLetras() {
        List<String> anagramas = anagramaService.gerarAnagramas("abc");
        assertNotNull(anagramas);
        assertEquals(6, anagramas.size());
        assertTrue(anagramas.contains("abc"));
        assertTrue(anagramas.contains("acb"));
        assertTrue(anagramas.contains("bac"));
        assertTrue(anagramas.contains("bca"));
        assertTrue(anagramas.contains("cab"));
        assertTrue(anagramas.contains("cba"));
    }
}
