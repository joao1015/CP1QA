import org.example.Apdex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApdexTest {

    private Apdex apdex;
    private final int totalAmostras = 557808;

    @BeforeEach
    public void setup() {
        this.apdex = new Apdex();
    }

    @Test
    public void validarApdexExcelente() {
        // Arrange, Act, Assert
        float score = apdex.calcularApdex(totalAmostras, 0, totalAmostras);
        assertEquals(1.0f, score, 0.001f);
    }

    @Test
    public void validarApdexBom() {
        int satisfeitos = (int) (totalAmostras * 0.87);
        int tolerantes = (int) (totalAmostras * 0.04);
        float score = apdex.calcularApdex(satisfeitos, tolerantes, totalAmostras);
        assertEquals(0.89f, score, 0.001f);
    }

    @Test
    public void validarApdexRazoavel() {
        int satisfeitos = (int) (totalAmostras * 0.77);
        int tolerantes = (int) (totalAmostras * 0.06);
        float score = apdex.calcularApdex(satisfeitos, tolerantes, totalAmostras);
        assertEquals(0.80f, score, 0.001f);
    }

    @Test
    public void validarApdexRuim() {
        int satisfeitos = (int) (totalAmostras * 0.59);
        float score = apdex.calcularApdex(satisfeitos, 0, totalAmostras);
        assertEquals(0.59f, score, 0.001f);
    }

    @Test
    public void validarApdexInaceitavel() {
        int satisfeitos = (int) (totalAmostras * 0.23);
        int tolerantes = (int) (totalAmostras * 0.46);
        float score = apdex.calcularApdex(satisfeitos, tolerantes, totalAmostras);
        assertEquals(0.46f, score, 0.001f);
    }
}
