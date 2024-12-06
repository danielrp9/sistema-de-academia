package Produtos;

import java.util.ArrayList;

/**
 * A classe Loja gerencia o estoque de produtos e as vendas realizadas.
 * 
 * Ela usa a classe {@link Estoque} para controlar os produtos disponíveis para venda e fornece métodos
 * para adicionar, remover produtos e registrar vendas.
 * 
 * @author daniel rodrigues
 */
public class Loja {
    
    /**
     * Estoque de produtos da loja.
     * A classe {@link Estoque} é utilizada para armazenar e gerenciar os produtos disponíveis.
     */
    private Estoque estoqueDeProdutos;

    /**
     * Construtor da classe Loja. Inicializa o estoque de produtos vazio.
     */
    public Loja() {
        this.estoqueDeProdutos = new Estoque();
    }

    /**
     * Adiciona um produto ao estoque da loja.
     * 
     * @param produto O produto a ser adicionado ao estoque.
     */
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        estoqueDeProdutos.adicionarProduto(produto);
    }

    /**
     * Remove um produto do estoque da loja.
     * 
     * @param produto O produto a ser removido do estoque.
     */
    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (!estoqueDeProdutos.getProdutos().contains(produto)) {
            throw new IllegalStateException("O produto não está no estoque.");
        }
        estoqueDeProdutos.removerProduto(produto);
    }

    /**
     * Retorna a lista de produtos disponíveis no estoque da loja.
     * 
     * @return Um {@code ArrayList} contendo os produtos no estoque.
     */
    public ArrayList<Produto> listarProdutosNoEstoque() {
        return estoqueDeProdutos.getProdutos(); 
    }

    /**
     * Registra a venda de um produto, verificando se a quantidade solicitada está disponível no estoque.
     * Se houver estoque suficiente, a venda é realizada e o estoque é decrementado.
     * 
     * @param produto O produto a ser vendido.
     * @param quantidade A quantidade do produto a ser vendida.
     */
    public void registrarVenda(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        // Verifica se o produto está disponível no estoque
        if (estoqueDeProdutos.verificarEstoque(produto, quantidade)) {
            // Realiza a venda, decrementando o estoque
            estoqueDeProdutos.removerProduto(produto, quantidade);
            System.out.println("Venda registrada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente para realizar a venda.");
        }
    }

    /**
     * Retorna uma representação em string da loja, incluindo o estoque de produtos.
     * 
     * @return Uma string representando a loja e seu estoque.
     */
    @Override
    public String toString() {
        return "Loja{" + "estoqueDeProdutos=" + estoqueDeProdutos + '}';
    }

    /**
     * Retorna o estoque de produtos da loja.
     * 
     * @return O objeto {@link Estoque} que representa o estoque da loja.
     */
    public Estoque getEstoque() {
        return estoqueDeProdutos; // Retorna o estoque
    }
}
