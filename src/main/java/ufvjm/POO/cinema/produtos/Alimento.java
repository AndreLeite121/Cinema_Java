/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

/**
 *
 * @author andreleite
 */
public class Alimento extends Produto{
    
    private int quantidade;
    private final int ID;
    
    private static int numproduto = 0;

    public Alimento(int quantidade, String nome, double valor, String validade) {
        super(nome, validade, valor);
        this.quantidade = quantidade;
        this.ID = numproduto;
        numproduto++;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static int getNumproduto() {
        return numproduto;
    }

    @Override
    public String toString() {
        return "Alimento{ Nome: "+ nome + ", quantidade=" + quantidade + ", ID=" + ID + '}';
    }

    @Override
    public String exibirDadosProdutos() {
        return "Alimento{ Nome: "+ nome + "Quantidade: " + quantidade + "Validade: "+ validade +'}';
    }
}
