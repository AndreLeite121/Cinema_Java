/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Pessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author andreleite
 */
public class sistemaControleClientes {
    public ArrayList<Cliente> clientes;
    
    // Instancia Singleton 
    private static final sistemaControleClientes INSTANCE = new sistemaControleClientes();

    private sistemaControleClientes() {  // Contrutor private para evitar que ele seja instanciado fora da classe
        this.clientes = new ArrayList<>();
    }

    // Método publico que libera o acesso a instancia da classe
    public static sistemaControleClientes getInstance() {
        return INSTANCE;
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    
    public Cliente getCliente(int index) {
        return clientes.get(index);
    }
    
    public void removerCliente(int index) {
        clientes.remove(index);
    }
    
    public Cliente find(Comparator<Cliente> comparator) {
        Collections.sort(clientes, comparator);
        Iterator<Cliente> iterator = clientes.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
        }
    
    public Cliente pesquisarClientePorCPF(String cpf) {
        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            if (cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void editarClientePorCPF(String cpf, Cliente novoCliente) {
        Iterator<Cliente> iterador = clientes.iterator();

        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            if (cliente.getCPF().equals(cpf)) {
                cliente.setNome(novoCliente.getNome());
                cliente.setEndereco(novoCliente.getEndereco());
                cliente.setTelefone(novoCliente.getTelefone());
                System.out.println("Cliente editado com sucesso.\n" + cliente);
            break;
            }
        }
    }

    public ArrayList<Cliente> getClientes() {
    return clientes;
    }
    
    public void deletarCliente(String cpf) {
        Iterator<Cliente> iterator = this.clientes.iterator();
        
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCPF().equals(cpf)) {
                iterator.remove();
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("SistemaControleCliente {\n");

        for (Cliente cliente : clientes) {
            result.append("  Nome: ").append(cliente.getNome())
                    .append(", CPF: ").append(cliente.getCPF())
                    .append(", Endereço: ").append(cliente.getEndereco())
                    .append(", Telefone: ").append(cliente.getTelefone())
                    .append("\n");
        }

        result.append("}");

        return result.toString();
    }
}