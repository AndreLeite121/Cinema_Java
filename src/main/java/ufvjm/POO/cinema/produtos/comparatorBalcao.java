/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author andreleite
 */
public class comparatorBalcao implements Comparator<List<Double>> {
    @Override
        public int compare(List<Double> balcao1, List<Double> balcao2) {
            double totalbalcao1 = calcularTotalVendas(balcao1);
            double totalbalcao2 = calcularTotalVendas(balcao2);

            // Compara os totais das vendas das caixas diretamente
            if (totalbalcao1 > totalbalcao2) {
                return -1; // retorna -1 se a caixa1 tiver um total maior que caixa2
            } else if (totalbalcao1 < totalbalcao2) {
                return 1; // retorna 1 se a caixa2 tiver um total maior que caixa1
            } else {
                return 0; // retorna 0 se forem iguais
            }
        }
        
        private double calcularTotalVendas(List<Double> caixa) {
                    return caixa.stream().mapToDouble(Double::doubleValue).sum();
        }
}
