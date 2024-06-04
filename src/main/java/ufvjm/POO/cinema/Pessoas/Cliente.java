/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Pessoas;

/**
 *  A classe "Cliente" é utilizada para representar o objeto "Cliente", sendo uma extensão da classe "Pessoa".
 *  @author andreleite
 */
public class Cliente extends Pessoa{
    private String sobrenome;
    private String endereco;
    private String telefone;
    private String PrefFilmes;
    private String PrefProduto;
    private double compras;
    private static int contadorClientesEncapsulado = 0;//Variável privada para contagem utilizando encapsulamento.
    protected static int contadorClientesProtected = 0;// Variável protegida para contagem
    private static int contadorCliente = 0;//Variável estática simples para contagem.
    
    /**
     * 
     * @param nome O nome do cliente.
     * @param sobrenome O sobrenome do cliente.
     * @param CPF O CPF do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O telefone do cliente.
     * @param PrefFilmes A preferência de filme.
     * @param PrefProduto A preferênia do produto.
     * @param compras O valor total consumido no cinema.
     */
    public Cliente(String nome, String sobrenome, String CPF, String endereco, String telefone, String PrefFilmes, String PrefProduto, double compras) {
        super(nome, CPF);
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.compras = compras;
        this.PrefFilmes = PrefFilmes;
        this.PrefProduto = PrefProduto;
        
        
        //Incrementa os contadores sempre que uma nova instância de Cliente é criada
        contadorClientesEncapsulado++;
        contadorClientesProtected++;
        contadorCliente++;
        
    }
    /**
     * 
     * @return 
     */
    public static int getContadorClientesEncapsulado() {
        return contadorClientesEncapsulado;
    }
    /**
     * 
     * @return 
     */
    public static int getContadorClientesProtected() {
        return contadorClientesProtected;
    }
    /**
     * 
     * @return 
     */
    public static int getContadorCliente() {
        return contadorCliente;
    }
    /**
     * 
     * @return 
     */
    public String getSobrenome() {
        return sobrenome;
    }
    /**
     * 
     * @param sobrenome 
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    /**
     * 
     * @return 
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * 
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * 
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * 
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * 
     * @return 
     */
    public String getPrefFilmes() {
        return PrefFilmes;
    }
    /**
     * 
     * @param PrefFilmes 
     */
    public void setPrefFilmes(String PrefFilmes) {
        this.PrefFilmes = PrefFilmes;
    }
    /**
     * Recebe a informação do produto preferido do cliente.
     * @return O produto preferido.
     */
    public String getPrefProduto() {
        return PrefProduto;
    }
    /**
     * 
     * @param PrefProduto 
     */
    public void setPrefProduto(String PrefProduto) {
        this.PrefProduto = PrefProduto;
    }
    /**
     * Recebe o valor total das compras do cliente.
     * @return O valor total das compras.
     */
    public double getCompras() {
        return compras;
    }
    /**
     * Define o valor total das compras feitas pelo cliente.
     * @param compras O novo valor das compras.
     */
    public void setCompras(double compras) {
        this.compras = compras;
    }
    /**
     * O método soma o valor das compras de cada produto.
     * @param valor O valor total das compras.
     */
    public void adicionarCompras(Double valor) {
        this.compras += valor;
    }
    /**
     * O método cancela as compras cancela as compras do cliente retornando 75% do valor do pedido.
     * @param valor O valor que será retornado.
     */
    public void cancelarCompras(Double valor) {
        this.compras -= (0.75 * valor);
    }
    /**
     * Retorna uma representação em string do cliente.
     * @return uma string representando o cliente.
     */
    @Override
    public String toString() {
        return "Cliente{ Nome=" + nome + ", sobrenome=" + sobrenome + ", Valor Gasto: " + compras + ", endereco=" + endereco + ", telefone=" + telefone + ", PrefFilmes=" + PrefFilmes + ", PrefProduto=" + PrefProduto + ", ID=" + contadorCliente + '}';
    }
    /**
     * Exibe os dados do cliente.
     * @return uma string com os dados do cliente.
     */
    @Override
    public String exibirDados(){
       return "Cliente: " + nome + ", CPF: " + CPF + '}';
   }
    
}