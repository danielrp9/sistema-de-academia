package com.mycompany.sistema.de.academia;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A classe Despesa representa uma despesa registrada no sistema de uma academia.
 * Ela contém informações sobre a descrição, o valor e a data da despesa, além de 
 * métodos para registrar, ajustar e exibir os detalhes da despesa.
 * 
 * @author daniel
 */
public class Despesa {
    private String descricao;
    private float valor;
    private Date data;

    /**
     * Construtor para inicializar uma despesa com descrição, valor e data.
     * 
     * @param descricao A descrição da despesa.
     * @param valor O valor da despesa.
     * @param data A data em que a despesa foi registrada.
     */
    public Despesa(String descricao, float valor, Date data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    /**
     * Registra a despesa, imprimindo detalhes sobre ela.
     */
    public void registrarDespesa() {
        // Lógica para registrar a despesa
        System.out.println("Despesa registrada: " + descricao + " no valor de R$" + valor);
    }

    /**
     * Ajusta o valor da despesa, garantindo que o novo valor seja positivo.
     * 
     * @param novoValor O novo valor a ser ajustado.
     */
    public void ajustarValor(float novoValor) {
        if (novoValor >= 0) {
            this.valor = novoValor;
        } else {
            System.out.println("Valor inválido. O valor deve ser positivo.");
        }
    }

    /**
     * Exibe os detalhes da despesa, incluindo descrição, valor e data formatada.
     */
    public void exibirDetalhes() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$" + valor);
        System.out.println("Data: " + formatter.format(data));
    }

    // Getters e Setters

    /**
     * Retorna a descrição da despesa.
     * 
     * @return A descrição da despesa.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da despesa.
     * 
     * @param descricao A nova descrição da despesa.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o valor da despesa.
     * 
     * @return O valor da despesa.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Define o valor da despesa.
     * 
     * @param valor O novo valor da despesa.
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * Retorna a data em que a despesa foi registrada.
     * 
     * @return A data da despesa.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data da despesa.
     * 
     * @param data A nova data da despesa.
     */
    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Despesa{" + "descricao=" + descricao + ","
                + " valor=" + valor + ", "
                + "data=" + data + '}';
    }
    
}
