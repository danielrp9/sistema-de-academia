package Vendas;

import Produtos.Produto;
import gerenciamento.usuario.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável por gerenciar as operações de vendas.
 * Inclui o registro, carregamento e salvamento de vendas em um arquivo JSON.
 */

public class GerenciadorVendas {
    private List<Venda> vendas;
    private static final String VENDA_FILE_PATH = "src\\main\\java\\Vendas\\Venda.java"; // Ajuste o caminho conforme necessário

    
     /**
     * Construtor da classe GerenciadorVendas.
     * Inicializa a lista de vendas e carrega as vendas previamente salvas do arquivo JSON.
     */
    public GerenciadorVendas() {
        vendas = new ArrayList<>();
        carregarVendas();
    }

    
        /**
     * Registra uma venda de um produto para um cliente.
     * Atualiza o estoque do produto e salva as vendas no arquivo JSON.
     * Gera um extrato da venda ao final.
     *
     * @param produto   Produto a ser vendido.
     * @param quantidade Quantidade do produto a ser vendida.
     * @param cliente   Cliente que está comprando o produto.
     */
    public void registrarVenda(Produto produto, int quantidade, Cliente cliente) {
        // Usando o método getQuantidadeEmEstoque() para verificar o estoque
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            System.out.println("Quantidade insuficiente em estoque.");
            return;
        }

        Date data = new Date();
        Venda venda = new Venda(produto, quantidade, data, cliente);
        vendas.add(venda);
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade); // Atualiza o estoque
        salvarVendas();
        venda.gerarExtrato(); // Exibe o extrato da venda
    }

    /**
     * Carrega as vendas salvas no arquivo JSON para a lista de vendas.
     * Em caso de erro, exibe uma mensagem no console.
     */
    private void carregarVendas() {
        try (FileReader reader = new FileReader(VENDA_FILE_PATH)) {
            Gson gson = new Gson();
           Type vendaListType = new TypeToken<List<Venda>>(){}.getType();
            String jsonContent = null;
           List<Venda> vendas = gson.fromJson(jsonContent, vendaListType);
            if (vendas == null) {
                vendas = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de vendas não encontrado: " + VENDA_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao carregar vendas: " + e.getMessage());
        }
    }

    /**
     * Salva a lista de vendas no arquivo JSON.
     * Em caso de erro, exibe uma mensagem no console.
     */
    private void salvarVendas() {
        try (FileWriter writer = new FileWriter(VENDA_FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(vendas, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar vendas: " + e.getMessage());
        }
    }

     /**
     * Retorna a lista de vendas registradas.
     *
     * @return Lista de vendas.
     */
    public List<Venda> getVendas() {
        return vendas;
    }
    
    
}