/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

/**
 *
 * @author andreleite
 */
public abstract class Produto {
    protected String nome;
    protected String validade;
    protected double valor;

    public Produto(String nome, String validade, double valor) {
        this.nome = nome;
        this.validade = validade;
        this.valor = valor;
    }
    
    public abstract String exibirDadosProdutos();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
