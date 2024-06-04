/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Pessoas;
/**
 *
 * @author andreleite
 */
public class Colaboradores extends Pessoa {
    private String senha;
    private String cargo;
    
    public Colaboradores(String nome, String senha, String CPF, String cargo, Cinema cadastro){
        super(nome, CPF);
        this.senha = senha;
        this.cargo = cargo;
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
    
    @Override
    public String exibirDados(){
       return "Funcionario: " + nome + ", CPF: " + CPF + '}';
    }
    
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", senha=" + senha + ", CPF=" + CPF + ", cargo=" + cargo + '}';
    }
}
