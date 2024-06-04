/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

import ufvjm.POO.cinema.Pessoas.Cinema;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author andreleite
 */
public class Estoque {
    private Produto produto;
    private int quantidade;
    private Cinema cadastro;
    private List<Produto> estoque;

    public Estoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Estoque(Cinema cadastro) {
        this.estoque = new ArrayList<>();
        this.cadastro = cadastro;
    }
    
    public List<Produto> Estoquelist(){
        return estoque;
    }
    
    public void comprarAlimento(Alimento alimento){
        cadastro.adicionarAlimento(alimento);
    }
    
    public void comprarFilme(Filme filme){
        cadastro.adicionarFilme(filme);
    }
    
    public void editarAlimento(String nome, int quantidade) {
        cadastro.editarAlimento(nome, quantidade);
    }
    public void editarFilme(String nome, int assentos,int sala, String hora) {
        cadastro.editarFilme(nome, assentos, sala, hora);
    }
    public void excluirAlimento(String nome) {
        cadastro.excluirAlimento(nome);
    }
    public void excluirFilme(String nome) {
        cadastro.excluirFilme(nome);
    }
    public void imprimirListaAlimentos() {
        cadastro.imprimirListaAlimentos();
    }
    public void imprimirListaFilmes() {
        cadastro.imprimirListaFilmes();
    }
    public void imprimirListaDeSalas(){
        cadastro.imprimirListaDeSalas();
    }
    
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
    public void setCadastro(Cinema cadastro) {
        this.cadastro = cadastro;
    }
}