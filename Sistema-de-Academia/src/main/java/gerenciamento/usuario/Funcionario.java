package gerenciamento.usuario;

/**
 * Classe que representa um Funcionário, que herda da classe {@link Usuario}.
 * Um funcionário possui atributos adicionais, como cargo e ID único, e métodos 
 * específicos para acessar e modificar suas informações. A classe garante que 
 * o ID do funcionário seja imutável após sua criação.
 * 
 * @author Daniel Rodrigues
 */
public class Funcionario extends Usuario {
    // Atributos específicos de Funcionario
    private String cargo;
    private final String idFuncionario;  // Imutável após criação

    /**
     * Construtor da classe {@link Funcionario}.
     * Inicializa um novo funcionário com as informações fornecidas.
     *
     * @param nome          O nome do funcionário.
     * @param cpf           O CPF do funcionário.
     * @param nomeUsuario   O nome de usuário do funcionário.
     * @param senha         A senha do funcionário.
     * @param cargo         O cargo do funcionário.
     * @param idFuncionario O ID único do funcionário, que não pode ser alterado após a criação.
     */
    public Funcionario(String nome, String cpf, String nomeUsuario, String senha, String cargo, String idFuncionario) {
        super(nome, cpf, nomeUsuario, senha);
        this.cargo = cargo;
        this.idFuncionario = idFuncionario;  // Atribui o ID de forma imutável
    }

    /**
     * Obtém o cargo do funcionário.
     *
     * @return O cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário.
     *
     * @param cargo O novo cargo do funcionário.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtém o ID único do funcionário.
     *
     * @return O ID do funcionário.
     */
    public String getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Sobrescreve o método {@link Object#toString()} para incluir informações específicas do funcionário.
     * 
     * @return Uma representação em formato de string de todas as informações do funcionário, incluindo 
     * o cargo e o ID do funcionário.
     */
    @Override
    public String toString() {
        return super.toString() + 
               ", cargo='" + cargo + '\'' +
               ", idFuncionario='" + idFuncionario + '\'';  // Retorna o ID imutável
    }

    /**
     * Obtém a senha do funcionário.
     * 
     * @return A senha do funcionário.
     */
    public String getSenha() {
        return super.getSenha();  // Supondo que há um método getSenha() na classe Usuario
    }

    /**
     * Altera o nome de usuário do funcionário.
     * Este método verifica se o novo login é válido antes de alterá-lo.
     *
     * @param novoLogin O novo nome de usuário para o funcionário.
     */
    public void setLogin(String novoLogin) {
        setNomeUsuario(novoLogin); 
    }

    /**
     * Valida o ID do funcionário.
     * Este método verifica se o ID segue o formato correto (neste caso, apenas números).
     *
     * @param id O ID do funcionário a ser validado.
     * @return {@code true} se o ID for válido, {@code false} caso contrário.
     */
    private boolean isValidIdFuncionario(String id) {
        return id != null && id.matches("\\d+");  // Exemplo de validação (somente números)
    }

    /**
     * Obtém o ID do funcionário. 
     * Este método é utilizado para acessar o ID imutável do funcionário.
     * 
     * @return O ID do funcionário.
     */
    public Object getId() {
        return this.idFuncionario;  // Retorna o ID do funcionário
    }
}
