// João Paulo Moreira dos Santos / 557808
package org.example;

public class Apdex {

    /**
     * Calcula o índice APDEX: (Satisfeitos + Tolerantes/2) / Total
     *
     * @param satisfeitos número de transações satisfeitas
     * @param tolerantes  número de transações tolerantes
     * @param total       total de amostras
     * @return índice APDEX entre 0 e 1
     */
    public float calcularApdex(int satisfeitos, int tolerantes, int total) {
        if (total <= 0) return 0f;
        double valor = (satisfeitos + (tolerantes / 2.0)) / (double) total;
        // Garante limites numéricos de 0..1 por segurança
        if (valor < 0) valor = 0;
        if (valor > 1) valor = 1;
        return (float) valor;
    }
}
