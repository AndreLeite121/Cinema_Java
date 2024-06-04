/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Pessoas;

/**
 *
 * @author andreleite
 */
public class Administrador extends Pessoa {
    private String senha;
    private String cargo;
    private Cinema cinema;
    
    public Administrador(String nome, String senha, String CPF, Cinema cinema) {
        super(nome, CPF);
        this.cargo = "Administrador";
        this.senha = senha;
        this.cinema = cinema;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
    

    @Override
    public String toString() {
        return "Administrador{" + "nome=" + nome + ", CPF=" + CPF + '}';
    }

    @Override
    public String exibirDados(){
        return "Administrador{: " + nome + ", CPF: " + CPF + '}';
    }
}