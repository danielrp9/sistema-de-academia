package gerenciamento.usuario;

/**
 * Classe que representa um Administrador, que herda de Funcionario.
 * Um administrador tem um departamento associado e possui as mesmas propriedades de um funcionário.
 * 
 * @author Daniel Rodrigues
 */
public class Administrador extends Funcionario {
    private String departamento; // Departamento ao qual o administrador pertence

    /**
     * Construtor para a classe Administrador.
     * 
     * @param nome Nome do administrador.
     * @param cpf CPF do administrador.
     * @param usuario Nome de usuário do administrador.
     * @param senha Senha do administrador.
     * @param cargo Cargo do administrador.
     * @param idFuncionario ID do funcionário associado ao administrador.
     * @param departamento Departamento do administrador.
     */
    public Administrador(String nome, String cpf, String usuario, String senha, String cargo, String idFuncionario, String departamento) {
        super(nome, cpf, usuario, senha, cargo, idFuncionario);
        this.departamento = departamento;
    }

    /**
     * Obtém o nome de usuário do administrador.
     * 
     * @return O nome de usuário do administrador.
     */
    public String getUsuario() {
        return getNomeUsuario(); // Acesso direto ao método da superclasse Funcionario
    }

    /**
     * Obtém a senha do administrador.
     * 
     * @return A senha do administrador.
     */
    @Override
    public String getSenha() {
        return super.getSenha(); // Chama o método getSenha da classe Funcionario
    }

    /**
     * Obtém o departamento do administrador.
     * 
     * @return O departamento ao qual o administrador pertence.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define o departamento do administrador.
     * 
     * @param departamento O novo departamento do administrador.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Administrador{" + "departamento='" + departamento + '\'' + '}';
    }
}
