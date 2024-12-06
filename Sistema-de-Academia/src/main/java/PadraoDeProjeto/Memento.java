package PadraoDeProjeto;

/**
 * O Memento armazena o estado de um objeto Originator (neste caso, um Funcionário).
 * Ele é imutável, ou seja, uma vez criado, seu estado não pode ser alterado.
 * Este padrão de projeto permite que o estado do objeto seja salvo e restaurado sem expor
 * a implementação interna do estado ao restante do sistema.
 * 
 * @author danie
 */
public class Memento {
    private final String nome;
    private final double salario;
    private final String cargo;

    /**
     * Construtor da classe {@link Memento}.
     * Inicializa o estado do memento com o nome, salário e cargo de um funcionário.
     * 
     * @param nome O nome do funcionário no momento do armazenamento do estado.
     * @param salario O salário do funcionário no momento do armazenamento do estado.
     * @param cargo O cargo do funcionário no momento do armazenamento do estado.
     */
    public Memento(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    /**
     * Retorna o nome do funcionário armazenado no estado do memento.
     * 
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o salário do funcionário armazenado no estado do memento.
     * 
     * @return O salário do funcionário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Retorna o cargo do funcionário armazenado no estado do memento.
     * 
     * @return O cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }
}
