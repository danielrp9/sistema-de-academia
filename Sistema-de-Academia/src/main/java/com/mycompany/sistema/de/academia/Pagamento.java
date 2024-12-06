package com.mycompany.sistema.de.academia;

import java.util.Date;

/**
 * A classe Pagamento representa um pagamento realizado na academia.
 * Ela contém informações sobre o valor, data e tipo do pagamento.
 * 
 * @author daniel
 */
public class Pagamento {
    private float valor;
    private Date data;
    private String tipo;

    /**
     * Construtor para criar um objeto Pagamento com um valor, data e tipo específicos.
     * 
     * @param valor O valor do pagamento. Deve ser positivo.
     * @param data A data em que o pagamento foi realizado.
     * @param tipo O tipo do pagamento (ex: "mensalidade", "avulso", etc.).
     * @throws IllegalArgumentException Se o valor do pagamento for menor ou igual a zero.
     */
    public Pagamento(float valor, Date data, String tipo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser positivo.");
        }
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    /**
     * Realiza o pagamento e registra no sistema.
     * 
     * Aqui pode ser adicionada lógica para registrar o pagamento no sistema financeiro.
     */
    public void realizarPagamento() {
        // Lógica para realizar o pagamento
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso.");
    }

    /**
     * Ajusta o valor do pagamento.
     * 
     * @param novoValor O novo valor do pagamento. Deve ser positivo.
     *
     */
    public void ajustarValor(float novoValor) {
        if (novoValor <= 0) {
            throw new IllegalArgumentException("O novo valor do pagamento deve ser positivo.");
        }
        this.valor = novoValor;
    }

    // Getters e Setters

    /**
     * Obtém o valor do pagamento.
     * 
     * @return O valor do pagamento.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Define o valor do pagamento.
     * 
     * @param valor O novo valor do pagamento. Deve ser positivo.
     * 
     */
    public void setValor(float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser positivo.");
        }
        this.valor = valor;
    }

    /**
     * Obtém a data do pagamento.
     * 
     * @return A data do pagamento.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data do pagamento.
     * 
     * @param data A nova data do pagamento.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém o tipo do pagamento.
     * 
     * @return O tipo do pagamento.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do pagamento.
     * 
     * @param tipo O novo tipo do pagamento.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna uma representação em string do objeto Pagamento.
     * 
     * @return Uma string representando os detalhes do pagamento.
     */
    @Override
    public String toString() {
        return "Pagamento{" +
                "valor=" + valor +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
