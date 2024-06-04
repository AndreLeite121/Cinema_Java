/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.produtos;

/**
 *
 * @author andreleite
 */
public class Venda {
    private String nomeCliente;
        private String nomeFilme;
        private String nomeProduto;
        private final String tipoBalcao;
        private final double valorCompra;

        public Venda(String nomeCliente, String nomeFilme, String nomeProduto, String tipoBalcao, double valorCompra) {
            this.nomeCliente = nomeCliente;
            this.nomeFilme = nomeFilme;
            this.nomeProduto = nomeProduto;
            this.tipoBalcao = tipoBalcao;
            this.valorCompra = valorCompra;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getNomeFilme() {
            return nomeFilme;
        }

        public void setNomeFilme(String nomeFilme) {
            this.nomeFilme = nomeFilme;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public String getTipoBalcao() {
            return tipoBalcao;
        }

    @Override
    public String toString() {
        return "Venda{" + "nomeCliente=" + nomeCliente + ", nomeFilme=" + nomeFilme + ", nomeProduto=" + nomeProduto + ", tipoBalcao=" + tipoBalcao + ", valorCompra=" + valorCompra + '}';
    }
        
        
}
