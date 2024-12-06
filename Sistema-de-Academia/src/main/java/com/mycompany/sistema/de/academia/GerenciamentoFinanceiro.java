package com.mycompany.sistema.de.academia;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe GerenciamentoFinanceiro é responsável por controlar as receitas,
 * despesas e o saldo financeiro de uma academia. Ela permite adicionar receitas 
 * e despesas, calcular o saldo atual e imprimir um resumo financeiro.
 * 
 * @author daniel
 */
public class GerenciamentoFinanceiro {
    private double saldo;
    private List<Double> receitas;
    private List<Double> despesas;

    /**
     * Construtor para inicializar o gerenciamento financeiro com saldo zero 
     * e listas vazias para receitas e despesas.
     */
    public GerenciamentoFinanceiro() {
        this.saldo = 0.0;
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    /**
     * Adiciona uma receita ao sistema, atualizando o saldo.
     * 
     * @param valor O valor da receita a ser adicionada.
     */
    public void adicionarReceita(double valor) {
        if (valor > 0) {
            receitas.add(valor);
            saldo += valor; // Atualiza o saldo
        } else {
            System.out.println("Valor da receita deve ser positivo.");
        }
    }

    /**
     * Adiciona uma despesa ao sistema, atualizando o saldo.
     * 
     * @param valor O valor da despesa a ser adicionada.
     */
    public void adicionarDespesa(double valor) {
        if (valor > 0) {
            despesas.add(valor);
            saldo -= valor; // Atualiza o saldo
        } else {
            System.out.println("Valor da despesa deve ser positivo.");
        }
    }

    /**
     * Calcula e retorna o saldo atual da academia.
     * 
     * @return O saldo atual.
     */
    public double calcularSaldo() {
        return saldo; // Retorna o saldo atual
    }

    /**
     * Obtém a lista de todas as receitas registradas.
     * 
     * @return A lista de receitas.
     */
    public List<Double> getReceitas() {
        return receitas;
    }

    /**
     * Obtém a lista de todas as despesas registradas.
     * 
     * @return A lista de despesas.
     */
    public List<Double> getDespesas() {
        return despesas;
    }

    /**
     * Imprime um resumo financeiro, exibindo receitas, despesas e saldo atual.
     */
    public void imprimirResumoFinanceiro() {
        System.out.println("Resumo Financeiro:");
        System.out.println("Receitas: " + receitas);
        System.out.println("Despesas: " + despesas);
        System.out.println("Saldo Atual: " + calcularSaldo());
    }

    @Override
    public String toString() {
        return "GerenciamentoFinanceiro{" + "saldo=" + saldo + ","
                + " receitas=" + receitas + ", "
                + "despesas=" + despesas + '}';
    }
    
}
