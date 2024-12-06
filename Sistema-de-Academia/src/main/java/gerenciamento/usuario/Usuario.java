package gerenciamento.usuario;

/**
 * Classe abstrata que representa um Usuário no sistema.
 * Esta classe serve como base para diferentes tipos de usuários, como Funcionário e Administrador.
 */
public abstract class Usuario {
    private String nome;
    String cpf;
    private String nomeUsuario;
    private String senha;
    private String login;

    /**
     * Construtor da classe Usuario.
     * Inicializa os atributos do usuário com os valores fornecidos.
     *
     * @param nome O nome do usuário.
     * @param cpf O CPF do usuário.
     * @param nomeUsuario O nome de usuário para login.
     * @param senha A senha do usuário.
     */
    public Usuario(String nome, String cpf, String nomeUsuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do usuário.
     *
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param cpf O CPF a ser definido.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o nome de usuário.
     *
     * @return O nome de usuário.
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Define o nome de usuário.
     *
     * @param nomeUsuario O nome de usuário a ser definido.
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A senha a ser definida.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ","
                + " cpf=" + cpf + ", "
                + "nomeUsuario=" + nomeUsuario + ","
                + " senha=" + senha + '}';
    }
    
}
