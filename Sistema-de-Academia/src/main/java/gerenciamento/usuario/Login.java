package gerenciamento.usuario;

import com.mycompany.sistema.de.academia.SistemaDeAcademia;

/**
 * Classe responsável pela autenticação de usuários no sistema da academia.
 * Permite verificar se um usuário e sua senha estão corretos.
 * A autenticação verifica se o usuário é um Funcionário ou um Administrador no sistema.
 * 
 * @author Daniel Rodrigues
 */
public class Login {
    private SistemaDeAcademia sistema;

    /**
     * Construtor da classe {@link Login}.
     * Inicializa a instância do sistema da academia, que contém os usuários a serem autenticados.
     *
     * @param sistema O sistema da academia, que contém os usuários a serem autenticados.
     */
    public Login(SistemaDeAcademia sistema) {
        this.sistema = sistema;
    }

    /**
     * Autentica um usuário com base no nome de usuário e na senha fornecidos.
     * O método verifica se o usuário é um Funcionário ou um Administrador e se a senha corresponde.
     * 
     * @param usuario O nome de usuário a ser autenticado.
     * @param senha A senha do usuário a ser autenticada.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     */
    public boolean autenticar(String usuario, String senha) {
        // Verifica se o usuário é um Funcionário
        for (Funcionario funcionario : sistema.getFuncionarios()) {
            if (funcionario.getNomeUsuario().equals(usuario) && funcionario.getSenha().equals(senha)) {
                return true;
            }
        }

        // Verifica se o usuário é um Administrador
        for (Administrador administrador : sistema.getAdministradores()) {
            if (administrador.getNomeUsuario().equals(usuario) && administrador.getSenha().equals(senha)) {
                return true;
            }
        }

        return false; // Retorna false se a autenticação falhar
    }

    /**
     * Retorna uma representação em formato de string da classe {@link Login}.
     * 
     * @return Uma string representando o estado atual do objeto Login.
     */
    @Override
    public String toString() {
        return "Login{" + "sistema=" + sistema + '}';
    }
}
