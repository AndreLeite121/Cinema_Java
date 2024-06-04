/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

import java.util.Comparator;

/**
 *
 * @author andreleite
 */
public class compararQuantidadeFilme implements Comparator<Filme>{
    
    @Override
    public int compare(Filme o1, Filme o2) {
        double diferencaValor = o1.getAssentos() - o2.getAssentos();
          // Se a diferença for diferente de zero, retorna a diferença;      
        if (diferencaValor > 0) {
            return 1;
        } else if (diferencaValor < 0) {
            return -1;
        }
         // Retorna 0 se tiverem o mesmo valor       
        return 0;    }
}
