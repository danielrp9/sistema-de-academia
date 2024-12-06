package Produtos;

import java.util.ArrayList;

/**
 * Classe que representa um estoque de produtos.
 * O estoque mantém uma lista de produtos e oferece métodos para adicionar, remover e verificar a disponibilidade de produtos.
 */
public class Estoque {
    
    /**
     * Lista de produtos armazenados no estoque.
     */
    private ArrayList<Produto> produtos;

    /**
     * Construtor da classe Estoque.
     * Inicializa a lista de produtos como uma lista vazia.
     */
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao estoque.
     * 
     * @param produto O produto a ser adicionado ao estoque.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /**
     * Remove um produto do estoque.
     * 
     * @param produto O produto a ser removido do estoque.
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    /**
     * Remove uma quantidade específica de um produto do estoque.
     * 
     * @param produto O produto a ser removido.
     * @param quantidade A quantidade a ser removida.
     */
    public void removerProduto(Produto produto, int quantidade) {
        if (produtos.contains(produto)) {
            int index = produtos.indexOf(produto);
            Produto p = produtos.get(index);
            if (p.getQuantidade() >= quantidade) {
                p.setQuantidade(p.getQuantidade() - quantidade);
                if (p.getQuantidade() == 0) {
                    produtos.remove(index); // Remove o produto se a quantidade for zero
                }
            }
        }
    }

    /**
     * Verifica se um produto está disponível no estoque na quantidade solicitada.
     * 
     * @param produto O produto a ser verificado.
     * @param quantidade A quantidade a ser verificada.
     * @return true se o estoque for suficiente para a quantidade solicitada, false caso contrário.
     */
    public boolean verificarEstoque(Produto produto, int quantidade) {
        return produtos.contains(produto) && produto.getQuantidade() >= quantidade;
    }

    /**
     * Retorna a lista de produtos disponíveis no estoque.
     * 
     * @return Uma lista de produtos armazenados no estoque.
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Retorna uma representação em string do estoque.
     * 
     * @return Uma string representando os produtos do estoque.
     */
    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }
}
