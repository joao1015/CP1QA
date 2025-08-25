package org.example;// João Paulo Moreira dos Santos / 557808

public class Apdex {

    /**
     * Calcula o índice Apdex com base no número de amostras.
     * A fórmula segue o padrão: (satisfeitos + tolerantes / 2) / total.
     * @param satisfeitos Número de requisições concluídas no tempo ideal.
     * @param tolerantes Número de requisições concluídas em um tempo tolerável.
     * @param totalAmostras O número total de amostras, correspondente ao RM.
     * @return O score Apdex como um valor float.
     */
    public float calcularApdex(int satisfeitos, int tolerantes, int totalAmostras) {
        if (totalAmostras == 0) {
            return 0;
        }
        return (satisfeitos + (tolerantes / 2.0f)) / totalAmostras;
    }
}