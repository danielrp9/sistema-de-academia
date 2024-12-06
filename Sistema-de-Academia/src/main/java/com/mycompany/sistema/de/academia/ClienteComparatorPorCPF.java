package com.mycompany.sistema.de.academia;

import gerenciamento.usuario.Cliente;

/**
 * Classe para comparar objetos da classe {Cliente} com base em seus números de CPF.
 * Essa classe permite a ordenação de clientes por CPF em ordem alfabética.
 * 
 * @author danie
 */
public class ClienteComparatorPorCPF {

    /**
     * Compara dois objetos {Cliente} com base em seus CPFs.
     * 
     * @param c1 o primeiro cliente a ser comparado.
     * @param c2 o segundo cliente a ser comparado.
     * @return um valor negativo, zero ou positivo, dependendo se o CPF do primeiro cliente
     * 
     */
    public int compare(Cliente c1, Cliente c2) {
        if (c1 == null || c2 == null) {
            throw new IllegalArgumentException("Os clientes não podem ser nulos.");
        }
        if (c1.getCpf() == null || c2.getCpf() == null) {
            throw new IllegalArgumentException("Os CPFs dos clientes não podem ser nulos.");
        }
        return c1.getCpf().compareTo(c2.getCpf());
    }
}
