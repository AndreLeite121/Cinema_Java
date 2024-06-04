/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

/**
 *
 * @author andreleite
 */
public class Filme extends Produto {
    private int assentos;
    private int duracao;
    private int sala;
    private String genero;
    private String hora;
    private final int ID;
    
    private static int numFilme = 0;
  

    public Filme(int assentos, int sala, int duracao, double valor , String nome, String genero, String hora ,String validade) {
        super(nome, validade, valor);
        this.assentos = assentos;
        this.duracao = duracao;
        this.sala = sala;
        this.genero = genero;
        this.hora = hora;
        this.ID = numFilme;
        numFilme++;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public static int getNumFilme() {
        return numFilme;
    }
    
    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String exibirDadosProdutos(){
        return "Filme{ Nome: "+ nome + "assentos: " + assentos + "Validade: "+ validade + "Duração: "+ duracao + "Sala: "+ sala + "Valor: "+ valor + '}';
    }

    @Override
    public String toString() {
        return "Filme{" + "Assentos=" + assentos + ", Valor= "+ valor + ", duracao=" + duracao + ", sala=" + sala + ", genero=" + genero + ", hora=" + hora + ", ID=" + ID + '}';
    }

    
    
    
}
