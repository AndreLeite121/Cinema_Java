/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufvjm.POO.cinema.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ufvjm.POO.cinema.produtos.Venda;

/**
 *
 * @author andreleite
 */
public class JsonVendas {
    public static final String Vendas = "/Users/andreleite/Downloads/POO_Cinema_POO 3/src/main/java/ufvjm/POO/cinema/Json/Vendas.json";

    public JsonVendas() {}

    public static void salvarVendas(List<Venda> vendas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(vendas);

        try (FileWriter writer = new FileWriter(Vendas)) {
            writer.write(json);
            System.out.println("Vendas salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar vendas!");
        }
    }
}
