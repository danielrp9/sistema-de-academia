/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.de.academia;

import java.util.Date;

/**
 * Classe que representa um relatório no sistema de academia.
 * Um relatório contém informações sobre uma determinada data, tipo e conteúdo.
 * 
 * @author Daniel Rodrigues
 */
public class Relatorio {
    private Date data; // Data em que o relatório foi gerado
    private String tipo; // Tipo do relatório (ex: financeiro, desempenho, etc.)
    private String conteudo; // Conteúdo do relatório

    /**
     * Construtor para a classe Relatorio.
     * 
     * @param data A data em que o relatório foi gerado.
     * @param tipo O tipo do relatório.
     * @param conteudo O conteúdo do relatório.
     */
    public Relatorio(Date data, String tipo, String conteudo) {
        this.data = data;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    /**
     * Gera o relatório.
     * Esta função pode incluir a lógica para compilar e salvar o relatório.
     */
    public void gerarRelatorio() {
        // Lógica para gerar o relatório
        System.out.println("Relatório do tipo " + tipo + " gerado.");
    }

    /**
     * Visualiza o conteúdo do relatório.
     * Esta função imprime as informações do relatório na saída padrão.
     */
    public void visualizarRelatorio() {
        // Lógica para visualizar o relatório
        System.out.println("Relatório do dia " + data + ": " + conteudo);
    }

    /**
     * Obtém a data do relatório.
     * 
     * @return A data do relatório.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data do relatório.
     * 
     * @param data A nova data do relatório.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém o tipo do relatório.
     * 
     * @return O tipo do relatório.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do relatório.
     * 
     * @param tipo O novo tipo do relatório.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém o conteúdo do relatório.
     * 
     * @return O conteúdo do relatório.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Define o conteúdo do relatório.
     * 
     * @param conteudo O novo conteúdo do relatório.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "data=" + data + ","
                + " tipo=" + tipo + ", "
                + "conteudo=" + conteudo + '}';
    }
    
}
