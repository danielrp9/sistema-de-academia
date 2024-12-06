package Vendas;

import java.util.Date;
import Produtos.Produto;
import java.util.List;
import gerenciamento.usuario.Cliente;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Representa uma venda realizada no sistema. Contém informações sobre os produtos vendidos,
 * quantidade, data, cliente e valor total da venda.
 */
public class Venda {
    private List<Produto> produtos;
    private Date data;
    private Cliente cliente;
    private float valorTotal;

    // Lista de vendas
    private static List<Venda> vendas = new ArrayList<>();

    // Caminho do arquivo para salvar vendas
    private static final String VENDA_FILE_PATH = "src/main/resources/vendas.json";

    /**
     * Construtor para a classe Venda. Inicializa uma venda com data e cliente fornecidos.
     * Os produtos podem ser adicionados posteriormente.
     *
     * @param data    a data da venda
     * @param cliente o cliente que realizou a compra
     * @throws IllegalArgumentException se os parâmetros forem inválidos
     */
    public Venda(Date data, int par1, Date date, Cliente cliente, Object par4, Object par5, Object par6) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }

        this.produtos = new ArrayList<>();
        this.data = data;
        this.cliente = cliente;
        this.valorTotal = 0; // Inicializado como 0, será atualizado ao adicionar produtos
    }

    public Venda(Object object, int i, Date date, Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Venda(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Adiciona produtos à venda e atualiza o valor total.
     *
     * @param produtosVendidos uma lista de produtos vendidos
     */
    public void setProdutos(List<Produto> produtosVendidos) {
        if (produtosVendidos == null || produtosVendidos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula ou vazia.");
        }

        this.produtos.addAll(produtosVendidos);

        // Atualizar o valor total da venda
        for (Produto produto : produtosVendidos) {
            this.valorTotal += produto.getPreco() * produto.getQuantidadeVendida();
        }
    }

    /**
     * Salva a lista de vendas em um arquivo JSON.
     *
     * @param vendas a lista de vendas a ser salva
     */
    public static void salvarVendas(List<Venda> vendas) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(VENDA_FILE_PATH)) {
            gson.toJson(vendas, writer);
            System.out.println("Vendas salvas com sucesso em " + VENDA_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao salvar vendas: " + e.getMessage());
        }
    }

    // Métodos para acessar os dados da venda

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public String getCpfCliente() {
        return cliente.getCpf();
    }

    /**
     * Gera e exibe um extrato detalhado da venda no console.
     * Inclui informações como nome do cliente, produtos, valor total e data.
     */
    public void gerarExtrato() {
        System.out.println("Venda realizada:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Produtos:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + " x " + produto.getQuantidadeVendida() + " - R$ " + produto.getPreco());
        }
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("Data: " + data);
    }

    /**
     * Retorna a lista de vendas realizadas.
     *
     * @return uma lista de vendas realizadas
     */
    public static List<Venda> getVendas() {
        return vendas;
    }

    /**
     * Adiciona uma venda à lista de vendas.
     */
    public static void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }
}
