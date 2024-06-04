/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Pessoas;

import java.util.Comparator;

/**
 *
 * @author andreleite
 */
public class ComparatorComprasCliente implements Comparator<Cliente>{
    
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return compareCompras(c1.getCompras(), c2.getCompras());    
    }

    private static int compareCompras(double v1, double v2) {
        // Compara os valores gastos dos clientes
        if (v1 < v2) {
            return -1;
        } else if (v1 > v2) {
            return 1;
        } else {
            return 0;
        }
    }
}