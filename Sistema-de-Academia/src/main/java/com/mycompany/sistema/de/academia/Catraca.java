package com.mycompany.sistema.de.academia;

import gerenciamento.usuario.Cliente;
import java.util.ArrayList;

/**
 * A classe Catraca simula o controle de acesso em uma academia, permitindo
 * liberar ou bloquear o acesso de clientes, além de registrar suas entradas e
 * saídas. A catraca também mantém um histórico de acessos dos clientes.
 * 
 * Ela gerencia o estado (liberada ou bloqueada) e registra as ações dos
 * clientes por meio de seu CPF.
 * 
 * @author daniel
 */
public class Catraca {
    private String idCatraca;
    private String estado; // Pode ser "liberada" ou "bloqueada"
    private ArrayList<String> historicoAcessos; // Registro de acessos

    /**
     * Construtor para inicializar a catraca com um ID específico e o estado inicial
     * como "liberada".
     * 
     * @param idCatraca O identificador da catraca.
     */
    public Catraca(String idCatraca) {
        this.idCatraca = idCatraca;
        this.estado = "liberada"; // Estado inicial
        this.historicoAcessos = new ArrayList<>(); // salvando os dados da catraca de forma dinâmica
    }


    /**
     * Libera o acesso ao cliente, registrando o CPF do cliente no histórico de
     * acessos, caso a catraca esteja no estado "liberada".
     * 
     * @param cpfCliente O CPF do cliente que está acessando.
     */
    public void liberarAcesso(String cpfCliente) {
        if ("liberada".equals(estado)) {
            historicoAcessos.add("Acesso permitido ao cliente com CPF: " + cpfCliente);
            System.out.println("Acesso liberado para: " + cpfCliente);
        } else {
            System.out.println("Acesso bloqueado para: " + cpfCliente);
        }
    }

    /**
     * Bloqueia o acesso ao cliente, mudando o estado da catraca para "bloqueada" e
     * registrando o CPF do cliente no histórico de acessos.
     * 
     * @param cpfCliente O CPF do cliente cujo acesso foi bloqueado.
     */
    public void bloquearAcesso(String cpfCliente) {
        estado = "bloqueada";
        historicoAcessos.add("Acesso bloqueado para cliente com CPF: " + cpfCliente);
        System.out.println("Acesso bloqueado para: " + cpfCliente);
    }

    /**
     * Registra a entrada de um cliente na academia, desde que a catraca esteja
     * liberada.
     * 
     * @param cliente O cliente que está entrando na academia.
     */
    public void registrarEntrada(Cliente cliente) {
        if ("liberada".equals(estado)) {
            historicoAcessos.add("Entrada registrada para cliente: " + cliente.getNome() + " com CPF: " + cliente.getCpfPseudoAnonimizado());
            System.out.println("Entrada registrada para cliente: " + cliente.getNome());
        } else {
            System.out.println("A catraca está bloqueada. Entrada não permitida para: " + cliente.getNome());
        }
    }

    /**
     * Registra a saída de um cliente da academia e salva no histórico.
     * 
     * @param cliente O cliente que está saindo da academia.
     */
    public void registrarSaida(Cliente cliente) {
        historicoAcessos.add("Saída registrada para cliente: " + cliente.getNome() + " com CPF: " + cliente.getCpfPseudoAnonimizado());
        System.out.println("Saída registrada para cliente: " + cliente.getNome());
    }

    /**
     * Atualiza o estado da catraca (liberada ou bloqueada).
     * 
     * @param novoEstado O novo estado da catraca ("liberada" ou "bloqueada").
     */
    public void atualizarEstado(String novoEstado) {
        this.estado = novoEstado;
    }

    /**
     * Retorna o histórico completo de acessos (entradas e saídas) registrados na
     * catraca.
     * 
     * @return Uma lista de strings contendo o histórico de acessos.
     */
    public ArrayList<String> getHistoricoAcessos() {
        return historicoAcessos;
    }

    /**
     * Retorna o ID da catraca.
     * 
     * @return O ID da catraca.
     */
    public String getIdCatraca() {
        return idCatraca;
    }

    /**
     * Retorna o estado atual da catraca.
     * 
     * @return O estado atual da catraca (liberada ou bloqueada).
     */
    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Catraca{" + "idCatraca=" + idCatraca + ", "
                + "estado=" + estado + ","
                + " historicoAcessos=" + historicoAcessos + '}';
    }
    
}
