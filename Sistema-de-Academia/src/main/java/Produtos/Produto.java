package Produtos;

import java.util.Date;

/**
 * A classe Produto representa um item que pode ser comercializado na loja.
 * 
 * Cada produto tem um nome, preço, validade, quantidade em estoque, categoria e um ID único gerado automaticamente.
 * 
 * @author daniel rodrigues
 */
public class Produto {
    
    /**
     * Nome do produto.
     */
    private String nome;
    
    /**
     * Preço do produto.
     */
    private float preco;
    
    /**
     * Data de validade do produto.
     */
    private Date validade;
    
    /**
     * Quantidade do produto em estoque.
     */
    private int quantidade;
    
    /**
     * Categoria do produto.
     */
    private String categoria;
    
    /**
     * ID único do produto, gerado automaticamente.
     */
    private int id;
    
    /**
     * Contador estático para gerar IDs únicos.
     */
    private static int contador = 0;

    /**
     * Construtor da classe Produto, com 4 parâmetros: nome, preço, quantidade e categoria.
     * O ID do produto é gerado automaticamente.
     * 
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @param quantidade A quantidade disponível do produto.
     * @param categoria A categoria do produto.
     */
    public Produto(String nome, double preco, int quantidade, String categoria) {
        this.nome = nome;
        this.preco = (float) preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.id = ++contador;
    }
    
    /**
     * Construtor da classe Produto, com 3 parâmetros: nome, preço e quantidade.
     * A categoria será definida como "Geral" por padrão.
     * 
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @param quantidade A quantidade disponível do produto.
     */
    public Produto(String nome, float preco, int quantidade) {
        this(nome, preco, quantidade, "Geral");  // Categoria padrão
    }

    /**
     * Construtor vazio. Atribui um ID único automaticamente.
     */
    public Produto() {
        this.id = ++contador; // Atribui um ID único
    }

    /**
     * Retorna o nome do produto.
     * 
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * 
     * @param nome O nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço do produto.
     * 
     * @return O preço do produto.
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * 
     * @param preco O preço do produto.
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Retorna a data de validade do produto.
     * 
     * @return A data de validade do produto.
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * Define a data de validade do produto.
     * 
     * @param validade A data de validade do produto.
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * Retorna a quantidade disponível do produto em estoque.
     * 
     * @return A quantidade do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível do produto em estoque.
     * 
     * @param quantidade A quantidade do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna a categoria do produto.
     * 
     * @return A categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     * 
     * @param categoria A categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o ID único do produto.
     * 
     * @return O ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     * 
     * @param id O ID do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a quantidade do produto em estoque.
     * 
     * @return A quantidade em estoque do produto.
     */
    public int getQuantidadeEmEstoque() {
        return quantidade; // Retorna a quantidade de estoque
    }

    /**
     * Retorna o número total de instâncias de produtos criadas.
     * 
     * @return O número total de produtos criados.
     */
    public static int getQuantidadeInstancias() {
        return contador; // Retorna o número total de instâncias criadas
    }

    /**
     * Retorna uma representação em string do produto.
     * 
     * @return Uma string representando o produto.
     */
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeEmEstoque=" + quantidade +
                ", validade=" + validade +  // Aqui, você pode tratar o formato de data, caso necessário
                ", categoria='" + categoria + '\'' +
                '}';
    }

    /**
     * Atualiza a quantidade do produto em estoque.
     * 
     * @param quantidade A nova quantidade em estoque do produto.
     */
    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidade = quantidade; // Atualiza a quantidade de estoque
    }

    public int getQuantidadeEstoque() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getQuantidadeVendida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
