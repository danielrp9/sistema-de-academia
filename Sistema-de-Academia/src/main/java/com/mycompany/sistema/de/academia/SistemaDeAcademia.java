package com.mycompany.sistema.de.academia;

import Json.Json;
import static Json.Json.carregarClientes;
import Produtos.Estoque;
import Produtos.Loja;
import Produtos.Produto;
import Vendas.GerenciadorVendas;
import Vendas.Venda;
import com.google.gson.Gson;
import gerenciamento.usuario.Administrador;
import gerenciamento.usuario.Cliente;
import gerenciamento.usuario.Funcionario;
import gerenciamento.usuario.Login;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import reservas.Reserva;
import reservas.SalaDeExercicio;

    /**
     * Classe SistemaDeAcademia representa a lógica central da academia, 
     * gerenciando funcionários, clientes, produtos, vendas, reservas, entre outros.
     */
    public class SistemaDeAcademia {
        private ArrayList<Funcionario> funcionarios;
        private ArrayList<Administrador> administradores;
        private Estoque produtosEmEstoque;
        private ArrayList<Relatorio> relatoriosDiarios;
        private ArrayList<Relatorio> relatoriosMensais;
        private ArrayList<Produto> alertasProdutosVencendo;
        private ArrayList<Venda> vendasRealizadas;
        private static final List<SalaDeExercicio> salas = new ArrayList<>(Arrays.asList(
            new SalaDeExercicio("Sala 1", 2, "Yoga"),
            new SalaDeExercicio("Sala 2", 2, "Musculação"),
            new SalaDeExercicio("Sala 3", 2, "Spinning"),
            new SalaDeExercicio("Sala 4", 2, "Pilates")
        ));
        // private Lanchonete lanchonete;
        private ArrayList<Despesa> despesas;
        private ArrayList<Reserva> reservas;
        private GerenciamentoFinanceiro gerenciamentoFinanceiro;
        private List<Cliente> clientes;
        private Catraca catraca;
        private final Loja loja = null;
        private List<Reserva> reserva;
        private ArrayList<Object> vendas;
        private List<Produto> produtos;
    
    // Variável estática protegida para contar os clientes criados
    protected static int contadorClientesProtegido = 0;
    // fazer o private
    
    /**
    * Construtor que inicializa o sistema de academia com dados predefinidos.
    * Isso inclui a criação de funcionários, administradores, clientes, produtos 
    * e outras informações necessárias para o funcionamento do sistema.
    */
    public SistemaDeAcademia() {
        this.funcionarios = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.relatoriosDiarios = new ArrayList<>();
        this.relatoriosMensais = new ArrayList<>();
        this.alertasProdutosVencendo = new ArrayList<>();
        this.vendasRealizadas = new ArrayList<>();
        this.despesas = new ArrayList<>();
        this.reserva = new ArrayList<>();
        this.produtosEmEstoque = new Estoque();
        this.gerenciamentoFinanceiro = new GerenciamentoFinanceiro();
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();  // Inicializando a lista de vendas
        inicializarDados(); // Chama o método para inicializar dados
        carregarProdutosPredefinidos();  // Carrega os produtos ao inicializar
        
    }
    
    //ITERATOR
    
   public void imprimirClientes() {
        // Obter o iterator da lista de clientes
        Iterator<Cliente> iterator = clientes.iterator();

        // Enquanto houver elementos no iterator, continue o loop
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();  // Obter o próximo cliente
              System.out.println(cliente.getNome());  // Imprimir o nome do cliente
        }
    }
    
  

 public static void main(String[] args) {
            SistemaDeAcademia sistema = new SistemaDeAcademia();
            Login login = new Login(sistema); // Inicializa a classe de login
       //     sistema.imprimirClientes();  // Imprime todos os clientes

            Catraca catraca = new Catraca("Catraca1"); 
            sistema.setCatraca(catraca);
            ArrayList<Object> listaDeProdutos = new ArrayList<>();


            Scanner scanner = new Scanner(System.in);
            String usuario;
            String senha;

            // Loop para autenticação
            boolean autenticado = false;
            while (!autenticado) {
                System.out.print("Digite o nome de usuário: ");
                usuario = scanner.nextLine();
                System.out.print("Digite a senha: ");
                senha = scanner.nextLine();

                if (login.autenticar(usuario, senha)) {
                    System.out.println("Login bem-sucedido!");
                    autenticado = true; // Sai do loop se o login for bem-sucedido
                } else {
                    System.out.println("Usuário ou senha incorretos. Tente novamente.");
                }
            }
            Menu.exibirMenu(sistema);
        }

    // Método para retornar a lista de vendas
    public ArrayList<Object> getVendas() {
        return vendas;
    }
    
    

    GerenciadorVendas gerenciadorVendas = new GerenciadorVendas();

    /**
    * Método auxiliar que inicializa dados de exemplo, incluindo funcionários, administradores e clientes.
    * Também imprime o número de clientes criados após a inicialização.
    */
    private void inicializarDados() {
        Funcionario funcionario = new Funcionario("Daniel", "12345678900", "dani", "senha123", "Instrutor", "F001");
        Administrador administrador = new Administrador("Maria", "09876543211", "maria123", "senha123", "Gerente", "F002", "Administração");
        Cliente cliente1 = new Cliente("Carlos", "11223344556", "carlos123", "senha123");
        Cliente cliente2 = new Cliente("Ana", "22334455667", "ana456", "senha456"); 

        //Adicionando clientes
       clientes.add(cliente1);
       clientes.add(cliente2);
        
        // Incrementando o contador de clientes
        incrementarContadorClientesProtegido();
        incrementarContadorClientesProtegido();

        // Adiciona os funcionários e administradores às listas
        funcionarios.add(funcionario);
        administradores.add(administrador);
    }

    /**
    * Método auxiliar para carregar produtos predefinidos no sistema.
    * Esses produtos são adicionados ao estoque inicial da academia.
    */
    private void carregarProdutosPredefinidos() {
        produtos.add(new Produto("GATORADE", 4.0f, 123, "ENERGÉTICO"));
        produtos.add(new Produto("BANANA", 1.0f, 34, "FRUTA"));
        produtos.add(new Produto("SUCO DE UVA", 7.0f, 29, "LÍQUIDO"));
        produtos.add(new Produto("SANDUICHE", 7.0f, 30, "SANDUÍCHE"));
        produtos.add(new Produto("AÇAI", 13.0f, 112, "GELADOS"));
        produtos.add(new Produto("VITAMINA", 4.0f, 76, "BEBIDA LÁCTEA"));
        produtos.add(new Produto("BANANA", 2.0f, 120, "FRUTAS"));
        produtos.add(new Produto("MAÇÃ", 1.0f, 100, "FRUTAS"));
        produtos.add(new Produto("ÁGUA MINERAL", 2.5f, 150, "LÍQUIDO"));
        produtos.add(new Produto("BISCOITO", 3.5f, 75, "SNACK"));
        produtos.add(new Produto("PÃO", 5.0f, 50, "PÃES"));
        produtos.add(new Produto("YOGURTE", 4.5f, 80, "LÁCTEO"));
        produtos.add(new Produto("SALADA DE FRUTAS", 10.0f, 45, "GELADOS"));
        produtos.add(new Produto("SUCOS NATURAIS", 8.0f, 120, "LÍQUIDO"));
    }
    
    
    //Questão 15: 
    public void exibirClientesComIterator() {
        // Criando um Iterator para a lista de clientes
        Iterator<Cliente> iterator = clientes.iterator();

        // Percorrendo a lista com o iterator
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            System.out.println(cliente);  // Imprime o cliente 
        }
        for (Cliente cliente : clientes) {
          System.out.println(cliente.getNome());
}

    }
    

    /**
    * Método auxiliar para incrementar o contador de clientes.
    */
    public static void incrementarContadorClientesProtegido() {
        contadorClientesProtegido++;
    }


     /**
      * Retorna a lista de funcionários.
      * 
      * @return lista de funcionários.
      */
     public ArrayList<Funcionario> getFuncionarios() {
         return funcionarios;
     }

   /**
  * Adiciona um produto à lista de produtos.
  * 
  * @param produto o objeto {@link Produto} a ser adicionado à lista.
  */
 public void adicionarProduto(Produto produto) {
     produtos.add(produto);
 }

 /**
  * Remove um produto da lista de produtos com base no seu ID.
  * Caso o produto não seja encontrado, uma mensagem será exibida informando isso.
  * 
  * @param id o ID do produto a ser removido.
  */
 public void removerProduto(int id) {
     Iterator<Produto> iterator = produtos.iterator();
     while (iterator.hasNext()) {
         Produto produto = (Produto) iterator.next();
         if (produto.getId() == id) {
             iterator.remove(); // Remove o produto
             System.out.println("Produto removido com sucesso.");
             return;
         }
     }
     System.out.println("Produto não encontrado.");
 }

    /**
     * Retorna a lista de produtos.
     * 
     * @return a lista {@link List} de objetos {@link Produto}.
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Exibe o total de clientes cadastrados.
     * O total é obtido a partir do tamanho da lista de clientes.
     */
    public void mostrarTotalDeClientes() {
        System.out.println("Total de clientes: " + clientes.size());
    }


     /**
      * Retorna a lista de salas de exercício.
      * 
      * @return lista de salas de exercício.
      */
     public static List<SalaDeExercicio> getSalas() {
         return salas;
     }

     /**
      * Retorna a lista de reservas.
      * 
      * @return lista de reservas.
      */
     public ArrayList<Reserva> getReservas() {
         return (ArrayList<Reserva>) reserva;
     }

     /**
      * Retorna a lista de administradores.
      * 
      * @return lista de administradores.
      */
     public ArrayList<Administrador> getAdministradores() {
         return administradores;
     }

     /**
      * Cadastra um produto no estoque.
      * 
      * @param produto O produto a ser adicionado ao estoque.
      */
     public void cadastrarProduto(Produto produto) {
         produtosEmEstoque.adicionarProduto(produto);
     }

     /**
      * Realiza uma venda, adicionando-a à lista de vendas realizadas.
      * 
      * @param venda A venda a ser registrada.
      */
     public void realizarVenda(Venda venda) {
         vendasRealizadas.add(venda);
     }


     /**
      * Retorna o total de clientes cadastrados.
      * 
      * @return O número total de clientes.
      */
     public int obterTotalClientes() {
         return clientes.size();
     }



     /**
      * Adiciona um novo cliente à lista de clientes e salva no arquivo JSON.
      * 
      * @param cliente O cliente a ser adicionado.
      */
     public void adicionarCliente(Cliente cliente) {
         clientes.add(cliente);
         Json.salvarClientes(clientes);
     }

     /**
      * Adiciona um novo funcionário à lista de funcionários e salva no arquivo JSON.
      * 
      * @param funcionario O funcionário a ser adicionado.
      */
     public void adicionarFuncionario(Funcionario funcionario) {
         funcionarios.add(funcionario);
         Json.salvarFuncionarios(funcionarios); // Salva a lista de funcionários
     }



     /**
      * Define um novo administrador e o adiciona à lista de administradores e salva no arquivo JSON.
      * 
      * @param administrador O administrador a ser adicionado.
      */
     public void setAdministrador(Administrador administrador) {
         administradores.add(administrador);
         Json.salvarAdministradores(administradores); // Salva a lista de administradores
     }


     /**
      * Calcula e exibe o saldo financeiro atual da academia.
      */
     public void gerenciarFinancas() {
         gerenciamentoFinanceiro.calcularSaldo();
     }

     /**
      * Define o estoque de produtos da academia.
      * 
      * @param estoque O estoque a ser configurado.
      */
     public void setEstoque(Estoque estoque) {
         this.produtosEmEstoque = estoque;
     }

     /**
      * Busca um funcionário pelo CPF.
      * 
      * @param cpf O CPF do funcionário a ser buscado.
      * @return O funcionário correspondente, ou null se não for encontrado.
      */
     public Funcionario buscarFuncionarioPorCpf(String cpf) {
         for (Funcionario funcionario : funcionarios) {
             if (funcionario.getCpf().equals(cpf)) {
                 return funcionario;
             }
         }
         return null;
     }

     /**
      * Remove um funcionário pelo ID.
      * 
      * @param idColaborador O ID do funcionário a ser removido.
      * @return true se o funcionário foi removido, false se não foi encontrado.
      */
     public boolean removerFuncionarioPorId(String idColaborador) {
         return funcionarios.removeIf(funcionario -> funcionario.getId().equals(idColaborador));
     }

     /**
      * Remove um cliente pelo CPF.
      * 
      * @param cpf O CPF do cliente a ser removido.
      * @return true se o cliente foi removido, false se não foi encontrado.
      */
     public boolean removerClientePorCpf(String cpf) {
         return clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
     }

     /**
      * Busca um cliente pelo CPF.
      * 
      * @param cpf O CPF do cliente a ser buscado.
      * @return O cliente correspondente, ou null se não for encontrado.
      */
     public Cliente buscarClientePorCpf(String cpf) {
         List<Cliente> clientes = Json.carregarClientes(); // Certifique-se de que o JSON é carregado aqui
         for (Cliente cliente : clientes) {
             if (cliente.getCpf().equals(cpf)) {
                 return cliente;
             }
         }
         return null; // Retorna null se não encontrar
     }


     /**
      * Busca uma sala de exercício pelo nome.
      * 
      * @param nomeSala O nome da sala a ser buscada.
      * @return A sala correspondente, ou null se não for encontrada.
      */
     public SalaDeExercicio buscarSalaPorNome(String nomeSala) {
         for (SalaDeExercicio sala : salas) {
             if (sala.getNome().equalsIgnoreCase(nomeSala)) {
                 return sala;
             }
         }
         return null;
     }

     /**
      * Retorna a lista de clientes.
      * 
      * @return lista de clientes.
      */
     public List<Cliente> getClientes() {
         return clientes;
     }



     /**
      * Define a catraca do sistema.
      * 
      * @param catraca A catraca a ser configurada.
      */
     public void setCatraca(Catraca catraca) {
         this.catraca = catraca;
     }

     /**
      * Retorna a catraca configurada no sistema.
      * 
      * @return A catraca do sistema.
      */
     public Catraca getCatraca() {
         return catraca;
     }

     /**
      * Salva a lista de vendas realizadas no arquivo JSON.
      */
     public void salvarVendas() {
         try (FileWriter writer = new FileWriter("Venda.json")) {
             Gson gson = new Gson();
             String json = gson.toJson(vendasRealizadas);
             writer.write(json);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }



        /**
         * Reserva uma sala de exercício para um cliente em uma data específica.
         * 
         * @param sala a sala de exercício a ser reservada.
         * @param clienteNome o nome do cliente que está fazendo a reserva.
         * @param data a data da reserva da sala.
         * @throws IllegalArgumentException se a sala fornecida for nula.
         */
        public void reservarSala(SalaDeExercicio sala, String clienteNome, Date data) {
            if (sala != null) {
                boolean reservaFeita = sala.reservarSala(clienteNome, data); // Método que usa clienteNome e data
                if (reservaFeita) {
                    System.out.println("Sala reservada com sucesso para " + clienteNome + " na data " + data + "!");
                } else {
                    System.out.println("Falha ao reservar a sala, vagas esgotadas ou data indisponível.");
                }
            } else {
                throw new IllegalArgumentException("Sala não pode ser nula.");
            }
        }

        /**
         * Libera uma sala de exercício que foi reservada por um cliente.
         * 
         * @param sala a sala de exercício a ser liberada.
         * @param clienteNome o nome do cliente que está liberando a sala.
         */
        void liberarSala(SalaDeExercicio sala, String clienteNome) {
            if (sala.liberarSala(clienteNome)) {
                System.out.println("Sala liberada com sucesso.");
            } else {
                System.out.println("Falha ao liberar sala.");
            }
        }


        /**
         * Retorna a loja associada ao sistema.
         * 
         * @return o objeto {@link Loja} associado ao sistema.
         */
        public Loja getLoja() {
            return loja;
        }

        /**
         * Retorna o gerenciador de vendas do sistema.
         * 
         * @return o objeto {@link GerenciadorVendas} associado ao sistema.
         */
        public GerenciadorVendas getGerenciadorVendas() {
            GerenciadorVendas gerenciadorVendas = null;
            return gerenciadorVendas;
        }

        /**
         * Adiciona uma reserva à lista de reservas do sistema.
         * 
         * @param reserva o objeto {@link Reserva} que representa a reserva a ser adicionada.
         */
        public void adicionarReserva(Reserva reserva) {
            reserva.add(reserva);
        }

        /**
         * Lista todas as reservas ordenadas por data.
         * As reservas serão exibidas em ordem crescente de data.
         */
        public void listarReservasPorData() {
            Collections.sort(reserva, new Reserva.ComparadorPorData());
            for (Reserva reserva : reserva) {
                System.out.println(reserva);
            }
        }

        /**
         * Lista todas as reservas ordenadas por hora.
         * As reservas serão exibidas em ordem crescente de hora.
         */
        public void listarReservasPorHora() {
            Collections.sort(reserva, new Reserva.ComparadorPorHora());
            for (Reserva reserva : reserva) {
                System.out.println(reserva);
            }
        }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SistemaDeAcademia{");
        sb.append("funcionarios=").append(funcionarios);
        sb.append(", administradores=").append(administradores);
        sb.append(", produtosEmEstoque=").append(produtosEmEstoque);
        sb.append(", relatoriosDiarios=").append(relatoriosDiarios);
        sb.append(", relatoriosMensais=").append(relatoriosMensais);
        sb.append(", alertasProdutosVencendo=").append(alertasProdutosVencendo);
        sb.append(", vendasRealizadas=").append(vendasRealizadas);
        sb.append(", despesas=").append(despesas);
        sb.append(", reservas=").append(reserva);
        sb.append(", gerenciamentoFinanceiro=").append(gerenciamentoFinanceiro);
        sb.append(", clientes=").append(clientes);
        sb.append(", catraca=").append(catraca);
        sb.append(", produtos=").append(produtos);
        sb.append(", loja=").append(loja);
        sb.append('}');
        return sb.toString();
    }


}
