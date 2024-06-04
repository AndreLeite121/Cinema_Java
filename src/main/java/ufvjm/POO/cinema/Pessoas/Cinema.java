package ufvjm.POO.cinema.Pessoas;

import ufvjm.POO.cinema.produtos.Alimento;
import ufvjm.POO.cinema.produtos.Filme;
import ufvjm.POO.cinema.produtos.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ufvjm.POO.cinema.produtos.Estoque;
import ufvjm.POO.cinema.produtos.compararQuantidadeFilme;
import ufvjm.POO.cinema.produtos.compararValorFilme;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andreleite
 */
public class Cinema {
    
    private final List<Cliente> clientes;
    private final List<Colaboradores> funcionarios;
    private final List<Administrador> administradores;
    private final List<Alimento> alimentos;
    private final List<Filme> filmes;
    private final List<Estoque> estoque;
    
    private Cinema(){ //Construtor privado
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        administradores = new ArrayList<>();
        alimentos = new ArrayList<>();
        filmes = new ArrayList<>();
        estoque = new ArrayList<>();
    }
    
    public static class SingletonBillAuxiliar{
        private static final Cinema INSTANCE = new Cinema();
    }
    
    public static Cinema getInstance() {
		return SingletonBillAuxiliar.INSTANCE;
    }
    
    //========================== Métodos de Atores ========================== 
    
    public boolean verificarCadastro(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(cpf)) {
                return true;
            }
        }
        for (Colaboradores funcionario : funcionarios) {
            if (funcionario.getCPF().equals(cpf)) {
                return true;
            }
        }
        for (Administrador administrador: administradores){
            if(administrador.getCPF().equals(cpf))
            return true;
        }
        
        return false;
    }
    
    public void cadastrarFuncionario(Colaboradores funcionario) {
        if (!verificarCadastro(funcionario.getCPF())) {
            funcionarios.add(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Funcionário já está cadastrado!");
        }  
    }
    
    public void excluirFuncionario(String cpf) {
        for (Colaboradores funcionario : funcionarios) {
            if (funcionario.getCPF().equals(cpf)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }
    
    public void editarFuncionario(String cpf, String novaSenha) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Colaboradores funcionario = funcionarios.get(i);
            if (funcionario.getCPF().equals(cpf)) {
                funcionario.setSenha(novaSenha);
                System.out.println("Senha do funcionário atualizada com sucesso!");
            return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }
    
    public void cadastrarAdm(Administrador administrador){
        if (!verificarCadastro(administrador.getCPF())){
            administradores.add(administrador);
            System.out.println("Administrador cadastrado com sucesso!");
        } else {
            System.out.println("Administrador já está cadastrado!");
        }
    }
    
    public void excluirAdm(String cpf) {
        for (Administrador administrador : administradores) {
            if (administrador.getCPF().equals(cpf)) {
                administradores.remove(administrador);
                System.out.println("Administrador removido com sucesso!");
                return;
            }
        }
        System.out.println("Administrador não encontrado!");
    }
    
    public void editarAdm(String cpf, String senha) {
        for (int i = 0; i < administradores.size(); i++) {
            Administrador administrador = administradores.get(i);
            if (administrador.getCPF().equals(cpf)) {
                administrador.setSenha(senha);
                System.out.println("O nome do Administrador atualizado com sucesso!");
            return;
            }
        }
        System.out.println("Administrador não encontrado!");
    }
    
    public void imprimirListaAdm() {
    System.out.println("Lista de Administrador:");
    for (Administrador administrador : administradores){
        System.out.println("Nome: " + administrador.getNome() + ", CPF: " + administrador.getCPF());
    }
    }
    
    public void imprimirListaFuncionarios() {
    System.out.println("Lista de Funcionários:");
        for (Colaboradores funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Senha: " + funcionario.getSenha());
        }
    }

    //========================== Métodos de Produtos ==========================
    
    public void adicionarAlimento(Alimento alimento){
        boolean existente = estoque.stream().anyMatch(e -> e.getProduto() instanceof Alimento && ((Alimento) e.getProduto()).getNome().equals(alimento.getNome()));
        if (existente) {
            System.out.println("Alimento já existente no estoque. Apenas a quantidade será atualizada.");
            editarEstoque(alimento, alimento.getQuantidade());
        } else {
            estoque.add(new Estoque(alimento, alimento.getQuantidade()));
            alimentos.add(alimento);
            System.out.println("Alimento cadastrado com sucesso no estoque!");
        }
    }
    
    public void adicionarFilme(Filme filme){
        boolean existente = estoque.stream().anyMatch(e -> e.getProduto() instanceof Filme && ((Filme) e.getProduto()).getNome().equals(filme.getNome()));
            if (existente) {
                System.out.println("Filme já esta disponível no estoque");
            } else {
                estoque.add(new Estoque(filme, 1));
                filmes.add(filme);
                System.out.println("Filme cadastrado com sucesso no estoque!");
            }    
    }
    
    public void ordenarListaDeFilmesPorValor() {
        // Cria uma instância do comparador por valor
        compararValorFilme comparatorPorValor = new compararValorFilme();
        // Utiliza o comparador para ordenar a lista de produtos por valor
        Collections.sort(filmes, comparatorPorValor);
    }
    
    public void ordenarListaDeFilmesPorAssentos() {
        // Cria uma instância do comparador por quantidade
        compararQuantidadeFilme comparatorPorQuantidade = new compararQuantidadeFilme();
        // Utiliza o comparador para ordenar a lista de produtos por quantidade
        Collections.sort(filmes, comparatorPorQuantidade);
    }
    
    public List<Filme> getListaOrdenadaPorValor() {
    // Chama o método de ordenação por valor e retorna a lista ordenada
        ordenarListaDeFilmesPorValor();
        return filmes;
    }
    
    public List<Filme> getListaOrdenadaPorQuantidade() {
    // Chama o método de ordenação por quantidade e retorna a lista ordenada
        ordenarListaDeFilmesPorAssentos();
        return filmes;
    }
    
    public void exibirFilmesOrdenadosPorQuantidade() {
    // Obtém a lista de filmes ordenada por quantidade
        List<Filme> listaOrdenadaPorQuantidade = getListaOrdenadaPorQuantidade();
    // Exibe os filmes ordenados por quantidade
        System.out.println("Lista de Filmes Ordenados por Quantidade de assentos: ");
        for (Produto produto : listaOrdenadaPorQuantidade) {
            System.out.println(produto);
        }
    }
    
    public void exibirFilmesOrdenadosPorValor() {
    // Obtém a lista de filmes ordenada por valor
        List<Filme> listaOrdenadaPorValor = getListaOrdenadaPorValor();
    // Exibe os filmes ordenados por valor
        System.out.println("Lista de Filmes Ordenados por Valor:");
        for (Produto produto : listaOrdenadaPorValor) {
            System.out.println(produto);
        }
    }
    
    public void editarAlimento(String nome, int quantidade) {
        for (Estoque item : estoque) {
            if (item.getProduto() instanceof Alimento && ((Alimento) item.getProduto()).getNome().equals(nome)) {
                ((Alimento) item.getProduto()).setQuantidade(quantidade);
                System.out.println("Quantidade do alimento atualizada com sucesso no estoque!");
                return;
            }
        }
        System.out.println("Alimento não encontrado no estoque!");
    }
    
    public void editarFilme(String nome, int assentos, int novaSala, String novaHora) {
    for (Estoque item : estoque) {
        if (item.getProduto() instanceof Filme && ((Filme) item.getProduto()).getNome().equals(nome)) {
            Filme filme = (Filme) item.getProduto();
            if (filme.getSala() != novaSala || !filme.getHora().equals(novaHora)) {
                boolean salaOcupada = estoque.stream().filter(e -> e.getProduto() instanceof Filme).map(e -> (Filme) e.getProduto()).anyMatch(f -> f.getSala() == novaSala && f.getHora().equals(novaHora) && !f.getNome().equals(nome));
                if (salaOcupada) {
                    System.out.println("A sala já está ocupada neste horário por outro filme. Exiba a lista de filmes para conferir as salas em uso!");
                    return;
                }
            }
            filme.setAssentos(assentos);
            filme.setSala(novaSala);
            filme.setHora(novaHora);
            System.out.println("Filme editado com sucesso no estoque!");
            return;
        }
    }
    System.out.println("Filme não encontrado no estoque.");
}
    
    public void editarEstoque(Produto produto, int quantidade) {
        for (Estoque item : estoque) {
            if (item.getProduto().getNome().equals(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                System.out.println("Quantidade atualizada no estoque!");
                return;
            }
        }
    }

    public void excluirAlimento(String nome) {
        estoque.removeIf(e -> e.getProduto() instanceof Alimento && ((Alimento) e.getProduto()).getNome().equals(nome));
        System.out.println("Alimento removido com sucesso do estoque!");
    }

    public void excluirFilme(String nome) {
        estoque.removeIf(e -> e.getProduto() instanceof Filme && ((Filme) e.getProduto()).getNome().equals(nome));
        System.out.println("Filme removido com sucesso do estoque!");
    }

    public List<Alimento> imprimirListaAlimentos() {
    System.out.println("Lista de Alimentos:");
    return alimentos;
    }

    public List<Filme> imprimirListaFilmes() {
    System.out.println("Lista de Filmes:");
    return filmes;
    }
    
    public List<Colaboradores> imprimirListaColaboradores(){
        return funcionarios;
    }
    
    public List<Estoque> produtosCinema(){
        return estoque;
    }
    
    public void imprimirListaDeSalas() {
    System.out.println("Filmes por Salas:");
    for (Estoque item : estoque) {
        Produto produto = item.getProduto();
        if (produto instanceof Filme filme) {
            System.out.println("Sala: " + filme.getSala() + ", assentos: " + filme.getAssentos()+ ", Nome: " + filme.getNome() + ", Hora: " + filme.getHora());
        }
    }
}

    @Override
    public String toString() {
        return "Cinema{ Funcionarios=" + funcionarios + ", Administradores=" + administradores + '}';
    }
    
}