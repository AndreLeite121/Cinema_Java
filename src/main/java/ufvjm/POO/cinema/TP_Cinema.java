/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import ufvjm.POO.cinema.Json.JsonCliente;
import ufvjm.POO.cinema.Json.JsonEstoque;
import ufvjm.POO.cinema.Json.JsonAlimentos;
import ufvjm.POO.cinema.Json.JsonColaboradores;
import ufvjm.POO.cinema.Json.JsonFilmes;
import ufvjm.POO.cinema.Json.JsonVendas;
import ufvjm.POO.cinema.Pessoas.Administrador;
import ufvjm.POO.cinema.Pessoas.Cinema;
import ufvjm.POO.cinema.Pessoas.Cliente;
import ufvjm.POO.cinema.Pessoas.Colaboradores;
import ufvjm.POO.cinema.Pessoas.ComparatorComprasCliente;
import ufvjm.POO.cinema.Pessoas.ComparatorNomeCliente;
import ufvjm.POO.cinema.Pessoas.sistemaControleClientes;
import ufvjm.POO.cinema.produtos.Alimento;
import ufvjm.POO.cinema.produtos.Estoque;
import ufvjm.POO.cinema.produtos.Filme;
import ufvjm.POO.cinema.produtos.GerenciamentoVendas;

/**
 *
 * @author andreleite
 */
public class TP_Cinema {
    public static void main(String[] args){
        try (/**
         * Questão 1
         * Todas as classes do diagrama de classes foram implementadas.
         *
         *//**
         * Questão 2
         * Pode ser usado por funcionários e administradores.
         *
         */ /**
         * Questão 3
         * Todas as classes contém o método toString().
         *
         */ /**
         * Questão 4
         * Usar a palavra-chave super
         * Presente nas linhas 21, 22 e 23 da classe Administrador
         * Trecho do código:
         *     public Administrador(String nome, String senha, String CPF, Cinema cadastro){
        super(nome, CPF, senha, "Administrador", cadastro);
         *     }.
         *
         */ /**
         * Questão 5
         * O sistema deverá armazenar de forma estática 5 caixas do Cinema
         * Presente nas linhas 21, ..., 25 da classe GerenciamentoVendas
         * Trecho do código:
         *
         *  
            static List<Double> balcao1 = new ArrayList<>();
            static List<Double> balcao2 = new ArrayList<>();
            static List<Double> balcao3 = new ArrayList<>();
            static List<Double> balcao4 = new ArrayList<>();
            static List<Double> balcaoAutomatico = new ArrayList<>();
        .
         */ Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite uma opção desejada.\n1 - Funcionalidades (Senha: admin)\n2 - Singleton e variações\n0 - Sair");
            String opcao = scanner.nextLine();
            
            switch (opcao) {
                case "1":
                    System.out.println("FUNCIONALIDADES DO CINEMA");
                    
                    /**
                     * Questão 6
                     * Cadastrar, alterar e excluir funcionário.
                     */
                    
                    System.out.print("Digite a senha (admin): ");
                    String senha = scanner.nextLine();
                    
                    if (senha.equals("admin")) {
                        Cinema cadastro = Cinema.getInstance();
                        Cinema cadastro2 = Cinema.getInstance();
                        
                        cadastro.cadastrarFuncionario(new Colaboradores("NovoFunc", "senha789", "func456", "Cargo", cadastro));//Cadastrado
                        cadastro.cadastrarFuncionario(new Colaboradores("NovoFunc", "senha789", "func456", "Cargo", cadastro));//Já Cadastrado
                        cadastro.excluirFuncionario("func456");// Excluiu
                        System.out.println("Colaboradores Novo cadastrado? " + cadastro.verificarCadastro("func456"));//False
                        cadastro.cadastrarFuncionario(new Colaboradores("NovoFunc", "senha789", "func456", "Cargo", cadastro));//Cadastrado
                        cadastro.cadastrarFuncionario(new Colaboradores("NovoFunc1", "senha123", "func001", "Cargo", cadastro));
                        cadastro2.cadastrarFuncionario(new Colaboradores("NovoFunc2", "senha456", "func002", "Cargo", cadastro));
                        cadastro2.cadastrarFuncionario(new Colaboradores("NovoFunc3", "senha789", "func003", "Cargo", cadastro));
                        
                        System.out.println("Colaboradores Novo cadastrado? " + cadastro.verificarCadastro("func456"));//True
                        
                        // Provando o uso do Singleton ao criar novos funcionarios;
                         System.out.println("******************************");
                        cadastro.imprimirListaFuncionarios();
                        cadastro2.imprimirListaFuncionarios();
                         System.out.println("******************************");
                        
                        //Editar senha do funcionario
                        
                        cadastro.editarFuncionario("func456", "senha000");
                        cadastro.editarFuncionario("func001", "senha000");
                        cadastro.editarFuncionario("func002", "senha000");
                        cadastro.editarFuncionario("func003", "senha000");
                        
                        cadastro.imprimirListaFuncionarios();
                        
                    } else {
                        System.out.println("Senha incorreta. Acesso negado.");
                    }
                    
                    /**
                     * Questão 6
                     * Cadastrar, alterar e excluir Administrador.
                     */
                    if (senha.equals("admin")) {
                        Cinema cadastro = Cinema.getInstance();
                        cadastro.cadastrarAdm(new Administrador("André", "admin", "111.111.111-11",cadastro));
                        cadastro.cadastrarAdm(new Administrador("Lucas", "admin", "222.222.222-22",cadastro));
                        
                        cadastro.imprimirListaAdm();
                        
                        System.out.println("Administrador novo cadastrado? " + cadastro.verificarCadastro("111.111.111-11"));
                        
                        cadastro.editarAdm("111.111.111-11", "ADMIN");
                        
                        cadastro.imprimirListaAdm();
                        
                        cadastro.excluirAdm("111.111.111-11");
                        System.out.println("Administrador novo cadastrado? " + cadastro.verificarCadastro("111.111.111-11"));
                        cadastro.imprimirListaAdm();
                    }
                    
                    
                    /**
                     * Questão 7
                     * Cadastar, alterar ou excluir clientes.
                     *
                     */
                    sistemaControleClientes ControleClientes = sistemaControleClientes.getInstance();
                    Cliente Leo = new Cliente("Claudio", "Pedro", "123.456.789-00", "Rua Principal, 123", "(11) 98765-4321", "Ação", "Pipoca", 0.00);//Cadastrado
                    Cliente Maria = new Cliente("Maria", "Souza", "111.222.333-44", "Avenida Principal, 456", "(11) 12345-6789", "Comédia", "Chocolate", 0.00);//Cadastrado
                    Cliente Mario = new Cliente("Mario", "Oliveira", "222.333.444-55", "Rua Principal, 123", "(11) 98765-4321", "Ficção Científica", "Bala", 0.00);//Cadastrado
                    Cliente Laura = new Cliente("Ana", "Silveira", "333.444.555-66", "Travessa dos Fundos, 101", "(11) 54321-9876", "Suspense", "Pepsi", 0.00);//Cadastrado
                    
                    ControleClientes.adicionarCliente(Leo);
                    ControleClientes.adicionarCliente(Maria);
                    ControleClientes.adicionarCliente(Mario);
                    ControleClientes.adicionarCliente(Laura);
                    
                    
                    System.out.println("Lista inicial de clientes.");
                    for (Cliente cliente : ControleClientes.clientes) {
                        System.out.println(cliente);
                    }
                    
                    ControleClientes.deletarCliente("123.456.789-00");
                    
                    System.out.println("Lista de clientes após a exclusão.");
                    for (Cliente cliente : ControleClientes.clientes) {
                        System.out.println(cliente);
                    }
                    
                    Cliente clienteEncontrado = ControleClientes.pesquisarClientePorCPF("123.456.789-00");
                    
                    // Imprime as informações do cliente
                    if (clienteEncontrado != null) {
                        System.out.println("Atenção!\nCliente foi encontrado no sistema\nVeja as informações:");
                        System.out.println(clienteEncontrado.toString());
                        System.out.println();
                    } else {
                        System.out.println("Cliente não encontrado");
                    }
                    
                    Cliente clienteParaEdicao = ControleClientes.pesquisarClientePorCPF("333.444.555-66");
                    
                    
                    if (clienteParaEdicao != null) {
                        clienteParaEdicao.setNome("Laura");
                        clienteParaEdicao.setEndereco("Rua Principal, 144");
                        clienteParaEdicao.setTelefone("(21) 9864-5502");
                    }
                    
                    for (Cliente cliente : ControleClientes.clientes) {
                        System.out.println(cliente);
                    }
                    
                    // Obtendo informações após a edição
                    Cliente clienteEditado = ControleClientes.pesquisarClientePorCPF("333.444.555-66");
                    
                    System.out.println("Alterações:");
                    System.out.println("Novo Endereço: " + clienteEditado.getEndereco());
                    System.out.println("Novo telefone: " + clienteEditado.getTelefone());
                    System.out.println();
                    
                    // Imprime a lista de clientes após alterar
                    System.out.println("Lista de clientes após edição.");
                    for (Cliente cliente : ControleClientes.clientes) {
                        System.out.println(cliente);
                    }
                    System.out.println();
                    
                    ControleClientes.editarClientePorCPF("123.456.789-00", new Cliente("Leo", "Pedro", "123.456.789-00", "Rua Principal, 123", "(11) 98765-4321", "Ação", "Pipoca", 0.00));
                    ControleClientes.deletarCliente("123.456.789-00");
                    
                    
                    
                    
// ======================> PARTE DE TESTE DOS PRODUTOS <======================
                    Cinema cadastro = Cinema.getInstance();
                    Estoque estoque = new Estoque(cadastro);
                    
                    Filme VingadoresUltimato = new Filme(100,1,120,30.5,"Vingadores: Ultimato","Ação","16:00" ,"22/04/2024");
                    Filme VingadoresUltimatoLegendado = new Filme(100,1,120,20.5,"Vingadores: Ultimato Legendado","Ação","22:00" ,"22/04/2024");
                    Filme ReiLeao = new Filme(80,2,150,10.5,"O Rei Leão","Animação","16:00","22/04/2024");
                    Filme Interestelar = new Filme(120,1, 110,15.5, "Interestelar","Ficção Cientifica","14:00" ,"22/04/2024");
                    
                    Alimento Pipoca = new Alimento(10,"Pipoca",5.75,"10/05/2024");
                    Alimento Chocolate = new Alimento(5,"Chocolate",4.75,"15/06/2024");
                    Alimento Refrigerante = new Alimento(20,"Refrigerante",6.00,"20/07/2025");
                    
                    estoque.comprarAlimento(Pipoca);
                    estoque.comprarAlimento(Chocolate);
                    estoque.comprarAlimento(Refrigerante);
                    estoque.comprarFilme(VingadoresUltimato);
                    estoque.comprarFilme(VingadoresUltimatoLegendado);
                    estoque.comprarFilme(ReiLeao);
                    estoque.comprarFilme(Interestelar);
                    
                    System.out.println(cadastro.produtosCinema());
                    JsonEstoque.salvarEstoque(cadastro.produtosCinema());
                    
                    
                    /**
                     * Questão 8 e 10.
                     *
                     */
                    GerenciamentoVendas gerenciamentoVendas = GerenciamentoVendas.getInstance();
                    
                    gerenciamentoVendas.realizarCompra(Maria, VingadoresUltimatoLegendado, Pipoca, 5 , 1, 20.5, 5.75, "Balcao 2");
                    gerenciamentoVendas.realizarCompra(Mario, ReiLeao,Pipoca, 1, 2,10.5, 5.75, "Balcao 2");
                    gerenciamentoVendas.realizarCompra(Laura, Interestelar,Pipoca, 1, 2,15.5, 5.75, "Balcao 1");
                    
                    System.out.println();
                    System.out.println("Lista de clientes após compra.");
                    for (Cliente cliente : ControleClientes.clientes) {
                        System.out.println(cliente.exibirDados());
                    }
                    JsonCliente.salvarClientes(ControleClientes.clientes);
                    System.out.println();
                    
                    JsonEstoque.salvarEstoque(cadastro.produtosCinema());
                    
                    
                    gerenciamentoVendas.emitirTotalVendasBalcao("Balcao 2");
                    gerenciamentoVendas.emitirTotalVendasBalcao("Balcao 1");
                    
                    
                    System.out.println("*********************************");
                    gerenciamentoVendas.emitirRelatorioVenda();
                    System.out.println("*********************************");
                    gerenciamentoVendas.compararVendas("Balcao 1", "Balcao 2");
                    
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("*********************************");
                    gerenciamentoVendas.BalancoMensal();
                    System.out.println("*********************************");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    
                    
                    /**
                     * Questão 9
                     * Os produtos, filmes e os clientes devem ser salvos de forma dinâmica no sistema
                     *
                     * Demonstração de clientes sendo armazenados de forma dinâmica: presente nas linhas 18, ..., 26 da classe sistemaControleClientes
                     * Trecho do código:
                     *     public ArrayList<Cliente> clientes;
                     *     public sistemaControleClientes() {
                     *         this.clientes = new ArrayList<>();
                     *     }
                     *     public void adicionarCliente(Cliente cliente) {
                     *         clientes.add(cliente);
                     *     }
                     *
                     *
                     * Demonstração de alimentos, filmes sendo armazenados de forma dinâmica: presente nas linhas 180, ..., 199 da classe Cinema
                     * Trecho do código
                     *      private List<Estoque> estoque;
                     *      public Cinema(){
                     *         *
                     *         *
                     *         *
                     *         estoque = new ArrayList<>();
                     *         *
                     *         *
                     *         *
                     *     }
                     *
                     *
                     *     public void adicionarAlimento(Alimento alimento){
                     *         boolean existente = estoque.stream().anyMatch(e -> e.getProduto() instanceof Alimento && ((Alimento) e.getProduto()).getNome().equals(alimento.getNome()));
                     *         if (existente) {
                     *             System.out.println("Alimento já existente no estoque. Apenas a quantidade será atualizada.");
                     *             editarEstoque(alimento, alimento.getQuantidade());
                     *         } else {
                     *             estoque.add(new Estoque(alimento, alimento.getQuantidade()));
                     *             System.out.println("Alimento cadastrado com sucesso no estoque!");
                     *         }
                     *     }
                     *
                     *     public void adicionarFilme(Filme filme){
                     *         boolean existente = estoque.stream().anyMatch(e -> e.getProduto() instanceof Filme && ((Filme) e.getProduto()).getNome().equals(filme.getNome()));
                     *         if (existente) {
                     *             System.out.println("Filme já esta disponível no estoque");
                     *        } else {
                     *             estoque.add(new Estoque(filme, 1));
                     *             System.out.println("Filme cadastrado com sucesso no estoque!");
                     *         }
                     *     }
                     */
                    
                    /**
                     * Questão 11.
                     * Criar duas váriaveis de classes (static) que irão armazenar quantas instâncias foram criadas dos tipos Clientes
                     * Métodos utilizados estão presentes na classe Cliente nas linhas 34, ..., 50.
                     *
                     * VANTAGENS da abordagem com encapsulamento:
                     * - Regula o acesso à variável estática, proporcionando uma manipulação mais segura dos dados
                     * - Impede o acesso direto à variável estática por outras classes, permitindo o controle
                     *
                     *   sobre as operações que podem ser realizadas.
                     *
                     * DESVANTAGENS da abordagem com encapsulamento:
                     * - Pode ser menos flexível em termos de acessibilidade para subclasses ou outras classes no mesmo pacote.
                     * - Exige a criação de métodos acessores (getters e setters), o que pode aumentar a complexidade do código.
                     * 
                     * 
                     * VANTAGENS da abordagem com controle de acesso protegido:
                     * - Permite que as subclasses acessem a variável estática para contagem.
                     * - Fornece um nível intermediário de restrição, permitindo acesso a classes do mesmo pacote e subclasses.
                     *
                     * DESVANTAGENS da abordagem com controle de acesso protegido:
                     * - Ainda permite o acesso direto por classes do mesmo pacote ou subclasses, o que pode não ser desejável em algumas situações.
                     * - Pode ser considerado menos seguro em comparação com o encapsulamento rigoroso (private).
                     */
                    
                    /**
                     * Questão 12
                     * Criar um método de classe para classe Sistema que deverá retornar quantas instâncias foram criadas dos tipos Cliente e Produtos.
                     */
                    int instanciasClientes = Cliente.getContadorCliente();
                    int instanciasAlimentos = Alimento.getNumproduto();
                    int instanciasFilmes = Filme.getNumFilme();
                    
                    System.out.println("Quantidade de instancias da classe Cliente: "+ instanciasClientes);
                    System.out.println("Quantidade de instancias da classe Filme: "+ instanciasAlimentos);
                    System.out.println("Quantidade de instancias da classe Alimento: "+ instanciasFilmes);
                    
                    /**
                     * Questão 13
                     * Implementar a interface Comparator para as classes Filme e Venda e fazer comparações por diferentes atributos.
                     * Utilizou -  se as classes:
                     * ProdutoComparatorPorQuantidade, ProdutoComparatorPorValor e ComparadorCaixas
                     * Ambas as classes contém os métodos criados para que essa questão fosse executada abaixo
                     */
                    //Ordena por valor de compras do caixa
                    //Compara dois caixas
                    gerenciamentoVendas.compararVendas("Balcao 1", "Balcao 2");
                    System.out.println();
                    gerenciamentoVendas.compararVendas("Balcao 2", "Balcao 1");
                    System.out.println();
                    
                    //Ordenar por valor
                    cadastro.ordenarListaDeFilmesPorValor();
                    cadastro.exibirFilmesOrdenadosPorValor();
                    System.out.println();
                    
                    //Ordenar por quantidade
                    cadastro.ordenarListaDeFilmesPorAssentos();
                    cadastro.exibirFilmesOrdenadosPorQuantidade();
                    System.out.println();
                    
                    /**
                     * Questão 14
                     * Json
                     */
                    JsonCliente.salvarClientes(ControleClientes.clientes);
                    JsonEstoque.salvarEstoque(cadastro.produtosCinema());
                    JsonAlimentos.salvarAlimentos(cadastro.imprimirListaAlimentos());
                    JsonFilmes.salvarFilmes(cadastro.imprimirListaFilmes());
                    JsonVendas.salvarVendas(gerenciamentoVendas.listaVenda());
                    JsonColaboradores.salvarColaboradores(cadastro.imprimirListaColaboradores());
                    
                    
                    /**
                     * Questão 15
                     * Gerar Javadoc
                     * O presente código está devidamente comentado de acordo com o Javadoc
                     */
                    System.out.println();
                    /**
                     * Questão 15 da entrega final do projeto
                     * Intanciar um iterator para a arraylist de clientes
                     */
                    // Obtém a lista de clientes do sistema
                    ArrayList<Cliente> listaClientes = ControleClientes.getClientes();
                    
                    // Cria um Iterator para percorrer a lista de clientes
                    Iterator<Cliente> iterator = listaClientes.iterator();
                    
                    // Itera sobre a lista usando o Iterator e imprime as informações de cada cliente
                    System.out.println("Detalhes dos clientes:");
                    while (iterator.hasNext()) {
                        Cliente cliente = iterator.next();
                        System.out.println(cliente); // Utiliza o método toString() para imprimir os detalhes do cliente
                    }
                    
                    
                    /**
                     * Relação com o foreach em Java:
                     *O foreach em Java é uma construção de loop conveniente e simplificada para percorrer coleções de elementos, como listas, arrays, conjuntos, entre outros.
                     *Internamente, ele utiliza um Iterator para percorrer a coleção, facilitando a iteração.
                     *No código anterior, a utilização do Iterator segue uma abordagem mais tradicional para percorrer e acessar os elementos de uma lista.
                     *O Iterator permite a iteração segura e a manipulação de elementos durante a iteração.
                     * A mesma operação de percorrer a lista de clientes utilizando o foreach:
                     */
                    System.out.println();
                    // Utiliza o foreach para percorrer e imprimir as informações de cada cliente
                    System.out.println("Detalhes dos clientes utilizando foreach:");
                    for (Cliente cliente : listaClientes) {
                        System.out.println(cliente); // Utiliza o método toString() para imprimir os detalhes do cliente
                    }
                    /**
                     * Questão 16
                     * Utilizar e apresentar o método sort da classe collections passando o comparator criado para ordenar a lista de clientes
                     * Rodar duas vezes foi solicitado e por isso foi feito comparação por nome e por valor de compra.
                     */
                    System.out.println();
                    // Criando um Comparator para ordenar por nome
                    ComparatorNomeCliente comparatorPorNome = new ComparatorNomeCliente();
                    // Ordena a lista de clientes por nome usando o ComparatorPorNome
                    Collections.sort(listaClientes, comparatorPorNome);
                    // Imprime os clientes ordenados por nome
                    System.out.println("Clientes ordenados por nome:");
                    for (Cliente cliente : listaClientes) {
                        System.out.println(cliente);
                    }
                    // Criando um Comparator para ordenar por valor total de compras
                    ComparatorComprasCliente comparatorCompras = new ComparatorComprasCliente();
                    // Ordena a lista de clientes por valor total de compras usando o ComparatorPorCompras
                    Collections.sort(listaClientes, comparatorCompras);
                    // Imprime os clientes ordenados por valor total de compras
                    System.out.println("\nClientes ordenados por valor total de compras:");
                    for (Cliente cliente : listaClientes) {
                        System.out.println(cliente);
                    }
                    System.out.println();
                    
                    
                    /**
                     * Questão 17
                     * Método find
                     * Testando o método find para encontrar o primeiro cliente por nome
                     */
                    Cliente primeiroClientePorNome = ControleClientes.find(comparatorPorNome);
                    if (primeiroClientePorNome != null) {
                        System.out.println("Primeiro cliente por nome encontrado: " + primeiroClientePorNome);
                    } else {
                        System.out.println("Nenhum cliente encontrado por nome.");
                    }
                    
                    // Testando o método find para encontrar o primeiro cliente por valor total de compras
                    Cliente primeiroClientePorCompras = ControleClientes.find(comparatorCompras);
                    if (primeiroClientePorCompras != null) {
                        System.out.println("Primeiro cliente por valor total de compras encontrado: " + primeiroClientePorCompras);
                    } else {
                        System.out.println("Nenhum cliente encontrado por valor total de compras.");
                    }
                    
                    
                case "2":
                    
                    System.out.println();
                    System.out.println();
                    System.out.println("==============PADRAO DE PROJETO================");
                    System.out.println();
                    System.out.println();
                    
                    // Singleton Clássico (Lazy Initialization) = GerenciamentoVendas; Linhas 28..29/ 38..50
                    // Singleton inicialização estática (EagerSingleton)= sistemaControleClientes; Linhas 19..20 / 26...29
                    // Bill Pugh Singleton = Cinema; Linhas 41...47
                    
                    // Obtendo a instância Singleton do GerenciamentoVendas
                    GerenciamentoVendas vendas1 = GerenciamentoVendas.getInstance();
                    
                    // Como getInstance() retorna a mesma instância, vendas2 terá a mesma referência que vendas1
                    GerenciamentoVendas vendas2 = GerenciamentoVendas.getInstance();
                    
                    // Exibindo as instâncias e verificando se são iguais pela comparação de referência
                    System.out.println("Instância de GerenciamentoVendas 1: " + vendas1);
                    System.out.println("Instância de GerenciamentoVendas 2: " + vendas2);
                    System.out.println("As duas instâncias são iguais? " + (vendas1 == vendas2));
                    System.out.println();
                    
                    // Demonstração do Singleton Inicialização Estática - sistemaControleClientes
                    // Obtendo a instância Singleton de sistemaControleClientes
                    sistemaControleClientes controleClientes = sistemaControleClientes.getInstance();
                    
                    // Como getInstance() retorna a mesma instância, controleClientes2 terá a mesma referência que controleClientes
                    sistemaControleClientes controleClientes2 = sistemaControleClientes.getInstance();
                    
                    // Exibindo as instâncias e verificando se são iguais pela comparação de referência
                    System.out.println("Instância de sistemaControleClientes 1: " + controleClientes);
                    System.out.println("Instância de sistemaControleClientes 2: " + controleClientes2);
                    System.out.println("As duas instâncias são iguais? " + (controleClientes == controleClientes2));
                    System.out.println();
                    
                    // Demonstração do Singleton Enum - CinemaSingletonEnum
                    // Obtendo a instância Singleton de Cinema através do enum CinemaSingletonEnum
                    Cinema cinema = Cinema.getInstance();
                    
                    // Como CinemaSingletonEnum.INSTANCE.getCinema() retorna a mesma instância, cinema2 terá a mesma referência que cinema
                    Cinema cinema2 = Cinema.getInstance();
                    
                    // Exibindo as instâncias e verificando se são iguais pela comparação de referência
                    System.out.println("Instância de Cinema 1: " + cinema);
                    System.out.println("Instância de Cinema 2: " + cinema2);
                    System.out.println("As duas instâncias são iguais? " + (cinema == cinema2));
                    
                    
                    break;
                    
                case "0":
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }   }
}
}
