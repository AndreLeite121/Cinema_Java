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
public class ComparatorNomeCliente implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return compareStrings(c1.getNome(), c2.getNome());
    }

    private static int compareStrings(String s1, String s2) {
        int len1 = s1.length();// Recebe o comprimento da primeira string
        int len2 = s2.length();// Recebe o comprimento da segunda string
        int lim = Math.min(len1, len2);// Determina o menor comprimento entre as duas strings

        for (int i = 0; i < lim; i++) {// Percorre pelos caracteres das duas strings até o menor comprimento
            char c1 = s1.charAt(i);// Recebe o caractere na posição i da primeira string
            char c2 = s2.charAt(i);// Recebe o caractere na posição i da segunda string
            if (c1 != c2) {// Compara os caracteres; se forem diferentes, retorna a diferença
                return c1 - c2;
            }
        }
        // Se todos os caracteres até o menor comprimento são iguais,
        // retorna a diferença dos comprimentos das strings
        return len1 - len2;
    }    
}
