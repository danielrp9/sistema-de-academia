package gerenciamento.usuario;

/**
 * Classe que representa um Cliente no sistema.
 * Um cliente possui informações pessoais, como endereço, telefone, e-mail, e status de ativação.
 * Além disso, ele herda propriedades da classe {@link Usuario}.
 * 
 * A classe também mantém um contador estático para rastrear o número de instâncias de clientes criadas.
 */
public class Cliente extends Usuario {
    
    /**
     * Endereço do cliente.
     */
    private String endereco;
    
    /**
     * Telefone do cliente.
     */
    private String telefone;
    
    /**
     * E-mail do cliente.
     */
    private String email;
    
    /**
     * CPF pseudoanonimizado do cliente.
     */
    private String cpfPseudoAnonimizado;
    
    /**
     * Status de ativação do cliente (ativo ou inativo).
     */
    private String status;
    
    /**
     * Contador estático para manter o número de instâncias de clientes.
     */
    private static int contadorClientes = 0;

    /**
     * Construtor da classe {@link Cliente}.
     * Este construtor é utilizado quando se deseja criar um cliente informando apenas o CPF, 
     * que será comparado com outras instâncias de clientes.
     * 
     * @param cpf O CPF do cliente.
     */
    public Cliente(String cpf) {
        super(null, cpf, null, null); // Chamando o construtor da classe mãe e passando o CPF
    }

    /**
     * Construtor da classe {@link Cliente}.
     * Este construtor é utilizado para criar um cliente informando o nome e o CPF.
     * 
     * @param nomeCliente O nome do cliente.
     * @param cpfCliente O CPF do cliente.
     */
    public Cliente(String nomeCliente, String cpfCliente) {
        super(nomeCliente, cpfCliente, "usuario_" + contadorClientes, "senha_padrao");
        this.status = "ativo";
        contadorClientes++;
    }

    /**
     * Construtor da classe {@link Cliente}.
     * Este construtor é utilizado quando se deseja criar um cliente com todos os campos necessários.
     * 
     * @param nome O nome do cliente.
     * @param cpf O CPF do cliente.
     * @param nomeUsuario O nome de usuário do cliente.
     * @param senha A senha do cliente.
     */
    public Cliente(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
        this.status = "ativo";
        contadorClientes++;
    }

    // Métodos Getters e Setters

    /**
     * Retorna o contador de clientes.
     * 
     * @return O número de clientes criados.
     */
    public static int getContadorClientes() {
        return contadorClientes;
    }

    /**
     * Retorna o endereço do cliente.
     * 
     * @return O endereço do cliente.
     */
    public String getEndereco() { 
        return endereco; 
    }

    /**
     * Define o endereço do cliente.
     * 
     * @param endereco O endereço a ser definido.
     */
    public void setEndereco(String endereco) { 
        this.endereco = endereco; 
    }

    /**
     * Retorna o telefone do cliente.
     * 
     * @return O telefone do cliente.
     */
    public String getTelefone() { 
        return telefone; 
    }

    /**
     * Define o telefone do cliente.
     * Valida o formato do telefone como "(xx) xxxxx-xxxx".
     * 
     * @param telefone O telefone a ser definido.
     * 
     */
    public void setTelefone(String telefone) {
        if (!telefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}")) {
            throw new IllegalArgumentException("Número de telefone inválido.");
        }
        this.telefone = telefone;
    }

    /**
     * Retorna o e-mail do cliente.
     * 
     * @return O e-mail do cliente.
     */
    public String getEmail() { 
        return email; 
    }

    /**
     * Define o e-mail do cliente.
     * Valida o formato do e-mail, verificando se contém "@" e ".".
     * 
     * @param email O e-mail a ser definido.
     * 
     */
    public void setEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    /**
     * Retorna o CPF pseudoanonimizado do cliente.
     * 
     * @return O CPF pseudoanonimizado do cliente.
     */
    public String getCpfPseudoAnonimizado() { 
        return cpfPseudoAnonimizado; 
    }

    /**
     * Define o CPF pseudoanonimizado do cliente.
     * 
     * @param cpfPseudoAnonimizado O CPF pseudoanonimizado a ser definido.
     */
    public void setCpfPseudoAnonimizado(String cpfPseudoAnonimizado) { 
        this.cpfPseudoAnonimizado = cpfPseudoAnonimizado; 
    }

    /**
     * Retorna o status de ativação do cliente.
     * 
     * @return O status do cliente.
     */
    public String getStatus() { 
        return status; 
    }

    /**
     * Define o status de ativação do cliente.
     * 
     * @param status O status a ser definido.
     */
    public void setStatus(String status) { 
        this.status = status; 
    }

    /**
     * Ativa o cliente, alterando seu status para "ativo".
     */
    public void ativar() { 
        this.status = "ativo"; 
    }

    /**
     * Desativa o cliente, alterando seu status para "inativo".
     */
    public void desativar() { 
        this.status = "inativo"; 
    }

    /**
     * Retorna o CPF do cliente.
     * 
     * @return O CPF do cliente.
     */
    public String getCpf() { 
        return cpf; 
    }

    /**
     * Retorna a quantidade de instâncias de clientes criadas.
     * 
     * @return A quantidade de instâncias de clientes.
     */
    public static int getQuantidadeInstancias() { 
        return contadorClientes; 
    }
    
    /**
     * Retorna uma representação em string do cliente.
     * 
     * @return A string representando o cliente, incluindo as propriedades herdadas e as específicas da classe Cliente.
     */
@Override
public String toString() {
    return "Cliente{" +
            "Nome='" + getNome() + '\'' +
            ", CPF='" + getCpf() +
            '}';
}
}
