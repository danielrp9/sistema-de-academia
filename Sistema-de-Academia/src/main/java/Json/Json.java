package Json;

import Produtos.Produto;
import Vendas.Venda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sistema.de.academia.ClienteComparatorPorCPF;
import com.mycompany.sistema.de.academia.Relatorio;
import gerenciamento.usuario.Administrador;
import gerenciamento.usuario.Cliente;
import gerenciamento.usuario.Funcionario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import reservas.Reserva;

public class Json {

    private static final String CLIENTE_FILE_PATH = "src/main/java/Json/Cliente.json"; 
    private static final String ADMINISTRADOR_FILE_PATH = "src/main/java/Json/Administrador.json"; 
    private static final String FUNCIONARIO_FILE_PATH = "src/main/java/Json/Funcionario.json"; 
    private static final String PRODUTO_FILE_PATH = "src/main/java/Json/Produto.json"; 
    private static final String VENDA_FILE_PATH = "src\\main\\java\\Vendas\\Venda.java";
    private static final String RESERVA_FILE_PATH = "src\\main\\java\\reservas\\Reserva.java";
    private static final String RELATORIO_FILE_PATH = "src\\main\\java\\com\\mycompany\\sistema\\de\\academia\\Relatorio.java";
   
    
    /**
     * Salva a lista de clientes no arquivo JSON.
     * 
     * Este método converte a lista de objetos {@link Cliente} em uma representação JSON
     * e a escreve em um arquivo localizado no caminho especificado por {@code CLIENTE_FILE_PATH}.
     * Caso ocorra algum erro durante a escrita do arquivo, uma mensagem de erro será exibida.
     * 
     * @param clientes A lista de objetos {@link Cliente} a ser salva no arquivo.
     *
     */
    public static void salvarClientes(List<Cliente> clientes) {
        Gson gson = new Gson();
        String json = gson.toJson(clientes);  
        try (FileWriter writer = new FileWriter(CLIENTE_FILE_PATH)) {
            writer.write(json);  
            System.out.println("Dados de clientes salvos com sucesso em " + CLIENTE_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }


    /**
    * Carrega a lista de clientes a partir de um arquivo JSON.
    * 
    * Este método lê um arquivo localizado no caminho especificado por {@code CLIENTE_FILE_PATH},
    * converte o conteúdo JSON em uma lista de objetos {@link Cliente} e a retorna.
    * Se o arquivo não for encontrado ou ocorrer algum erro durante a leitura,
    * o método exibirá uma mensagem de erro e retornará uma lista vazia.
    * 
    * @return Uma lista de objetos {@link Cliente} carregada a partir do arquivo, ou uma lista vazia
    *         em caso de erro ou se o arquivo não for encontrado.
    */
   public static List<Cliente> carregarClientes() {
       Gson gson = new Gson();
       try (FileReader reader = new FileReader(CLIENTE_FILE_PATH)) {
           Type clienteListType = new TypeToken<ArrayList<Cliente>>(){}.getType();
           return gson.fromJson(reader, clienteListType);  
       } catch (FileNotFoundException e) {
           System.err.println("Arquivo de clientes não encontrado: " + CLIENTE_FILE_PATH);
       } catch (IOException e) {
           System.err.println("Erro ao carregar dados: " + e.getMessage());
       }
       return new ArrayList<>();  
   }

    
        /**
      * Edita os dados de um cliente na lista de clientes.
      * 
      * Este método recebe um objeto {@link Cliente} contendo as informações atualizadas de um cliente.
      * Ele carrega a lista de clientes a partir de um arquivo, procura o cliente com o mesmo CPF 
      * e, caso encontrado, substitui os dados antigos pelos novos. Após a atualização, a lista de 
      * clientes é salva novamente no arquivo.
      * 
      * Se o cliente com o CPF especificado não for encontrado, uma mensagem de erro será exibida.
      * 
      * @param clienteEditado O objeto {@link Cliente} contendo os dados atualizados do cliente.
      */
     public static void editarCliente(Cliente clienteEditado) {
         List<Cliente> clientes = carregarClientes();
         Iterator<Cliente> iterator = clientes.iterator(); 
         while (iterator.hasNext()) {
             Cliente cliente = iterator.next();
             if (cliente.getCpf().equals(clienteEditado.getCpf())) { // Usando CPF como identificador
                 iterator.remove(); // Remove o cliente antigo
                 clientes.add(clienteEditado); // Adiciona o cliente editado
                 salvarClientes(clientes); // Salva a lista atualizada
                 System.out.println("Cliente editado com sucesso.");
                 return;
             }
         }
         System.out.println("Cliente não encontrado.");
     }


    /**
   * Remove um cliente da lista de clientes com base no CPF fornecido.
   * 
   * Este método recebe um CPF e procura o cliente correspondente na lista. 
   * Se o cliente for encontrado, ele será removido da lista e a lista atualizada 
   * será salva de volta no arquivo. Caso contrário, uma mensagem indicando que o cliente 
   * não foi encontrado será exibida.
   * 
   * @param cpfCliente O CPF do cliente a ser removido.
   */
  public static void removerCliente(String cpfCliente) {
      List<Cliente> clientes = carregarClientes();
      Iterator<Cliente> iterator = clientes.iterator(); // Criando o Iterator
      boolean removido = false;
      while (iterator.hasNext()) {
          Cliente cliente = iterator.next();
          if (cliente.getCpf().equals(cpfCliente)) { // Encontrando o cliente pelo CPF
              iterator.remove(); // Remove o cliente
              removido = true;
              break; // Sai do loop após encontrar o cliente
          }
      }
      if (removido) {
          salvarClientes(clientes); // Salva a lista atualizada
          System.out.println("Cliente removido com sucesso.");
      } else {
          System.out.println("Cliente não encontrado.");
      }
  }

  
    /**
     * Salva a lista de administradores no arquivo especificado.
     * 
     * Este método recebe uma lista de administradores e a converte em formato JSON, 
     * que é então gravado em um arquivo utilizando a biblioteca Gson. Caso o processo 
     * de salvamento seja bem-sucedido, uma mensagem de confirmação será exibida. 
     * Em caso de erro, uma mensagem de erro será mostrada.
     * 
     * @param administradores A lista de administradores a ser salva.
     */
    public static void salvarAdministradores(List<Administrador> administradores) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ADMINISTRADOR_FILE_PATH)) {
            gson.toJson(administradores, writer);
            System.out.println("Administradores salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar administradores: " + e.getMessage());
        }
    }

    
    /**
  * Carrega a lista de administradores a partir do arquivo especificado.
  * 
  * Este método lê os dados de administradores do arquivo JSON e os converte de volta
  * para uma lista de objetos do tipo {@link Administrador}. Caso o arquivo não seja
  * encontrado ou ocorra algum erro durante a leitura, uma mensagem de erro será exibida.
  * Se não houver dados no arquivo ou se ocorrer algum problema, uma lista vazia será retornada.
  * 
  * @return Uma lista de administradores carregada do arquivo, ou uma lista vazia em caso de erro.
  */
 public static List<Administrador> carregarAdministradores() {
     Gson gson = new Gson();
     try (FileReader reader = new FileReader(ADMINISTRADOR_FILE_PATH)) {
         Type administradorListType = new TypeToken<ArrayList<Administrador>>(){}.getType();
         return gson.fromJson(reader, administradorListType);  
     } catch (FileNotFoundException e) {
         System.err.println("Arquivo de administradores não encontrado: " + ADMINISTRADOR_FILE_PATH);
     } catch (IOException e) {
         System.err.println("Erro ao carregar dados: " + e.getMessage());
     }
     return new ArrayList<>();  
 }

    
    /**
   * Remove um funcionário da lista com base no CPF fornecido.
   * 
   * Este método busca o funcionário na lista utilizando o CPF e, caso encontrado,
   * o remove da lista. Após a remoção, a lista atualizada é salva no arquivo.
   * Se o funcionário não for encontrado, uma mensagem de erro será exibida.
   * 
   * @param cpfFuncionario O CPF do funcionário que será removido da lista.
   */
  public static void removerFuncionario(String cpfFuncionario) {
      List<Funcionario> funcionarios = carregarFuncionarios();
      boolean removido = funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpfFuncionario)); // Remove o funcionário pelo CPF
      if (removido) {
          salvarFuncionarios(funcionarios); // Salva a lista atualizada
          System.out.println("Funcionário removido com sucesso.");
      } else {
          System.out.println("Funcionário não encontrado.");
      }
  }


    /**
    * Salva a lista de funcionários em um arquivo JSON.
    * 
    * Este método converte a lista de funcionários fornecida para o formato JSON e a escreve
    * no arquivo especificado pelo caminho `FUNCIONARIO_FILE_PATH`. Caso ocorra um erro durante
    * o processo de escrita, uma mensagem de erro é exibida.
    * 
    * @param funcionarios A lista de funcionários que será salva no arquivo.
    */
   public static void salvarFuncionarios(List<Funcionario> funcionarios) {
       Gson gson = new Gson();
       try (FileWriter writer = new FileWriter(FUNCIONARIO_FILE_PATH)) {
           gson.toJson(funcionarios, writer);
           System.out.println("Funcionários salvos com sucesso!");
       } catch (IOException e) {
           System.out.println("Erro ao salvar funcionários: " + e.getMessage());
       }
   }


    /**
     * Carrega a lista de funcionários a partir de um arquivo JSON.
     * 
     * Este método tenta ler o arquivo especificado pelo caminho `FUNCIONARIO_FILE_PATH` e converte
     * o conteúdo JSON em uma lista de objetos `Funcionario`. Se o arquivo não for encontrado ou se
     * ocorrer um erro de leitura, o método exibe uma mensagem de erro e retorna uma lista vazia.
     * 
     * @return Uma lista de objetos `Funcionario` carregada a partir do arquivo, ou uma lista vazia 
     *         se ocorrer algum erro durante o processo de leitura.
     */
    public static List<Funcionario> carregarFuncionarios() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FUNCIONARIO_FILE_PATH)) {
            Type funcionarioListType = new TypeToken<ArrayList<Funcionario>>(){}.getType();
            return gson.fromJson(reader, funcionarioListType);  
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de funcionários não encontrado: " + FUNCIONARIO_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
        return new ArrayList<>();  
    }
 

    /**
     * Adiciona um novo produto à lista de produtos e salva a lista atualizada em um arquivo JSON.
     * 
     * Este método carrega a lista atual de produtos, adiciona o novo produto à lista, e em seguida 
     * salva a lista atualizada no arquivo especificado por `PRODUTO_FILE_PATH`. Uma mensagem de 
     * sucesso é exibida após a adição do produto.
     * 
     * @param produto O objeto `Produto` a ser adicionado à lista de produtos.
     */
    public static void adicionarProduto(Produto produto) {
        List<Produto> produtos = carregarProdutos();
        produtos.add(produto);  // Adiciona o produto à lista
        salvarProdutos(produtos);  // Salva a lista atualizada
        System.out.println("Produto adicionado com sucesso.");
    }
    
      /**
     * Salva a lista de produtos em um arquivo JSON.
     * 
     * Este método converte a lista de objetos `Produto` em formato JSON e a escreve em um arquivo 
     * especificado pelo caminho `PRODUTO_FILE_PATH`. Se a operação for bem-sucedida, uma mensagem 
     * de sucesso será exibida. Caso ocorra algum erro ao salvar os dados, uma mensagem de erro será 
     * exibida.
     * 
     * @param produtos A lista de objetos `Produto` a ser salva no arquivo.
     */
    public static void salvarProdutos(List<Produto> produtos) {
        Gson gson = new Gson();
        String json = gson.toJson(produtos);
        try (FileWriter writer = new FileWriter(PRODUTO_FILE_PATH)) {
            writer.write(json);
            System.out.println("Produtos salvos com sucesso em " + PRODUTO_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }



    /**
     * Remove um produto da lista de produtos com base no nome e salva a lista atualizada em um arquivo JSON.
     * 
     * Este método carrega a lista de produtos, tenta remover o produto que corresponde ao nome fornecido 
     * (ignorando diferenças de maiúsculas e minúsculas), e em seguida salva a lista atualizada no arquivo 
     * especificado por `PRODUTO_FILE_PATH`. Uma mensagem de sucesso é exibida se o produto for removido,
     * caso contrário, uma mensagem informando que o produto não foi encontrado será exibida.
     * 
     * @param nomeProduto O nome do produto a ser removido da lista de produtos.
     */
    public static void removerProduto(String nomeProduto) {
        List<Produto> produtos = carregarProdutos();
        if (produtos.removeIf(produto -> produto.getNome().equalsIgnoreCase(nomeProduto))) {
            salvarProdutos(produtos);  // Salva a lista atualizada
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }



    /**
     * Edita um produto existente na lista de produtos com base no nome fornecido e salva a lista atualizada em um arquivo JSON.
     * 
     * Este método carrega a lista de produtos, localiza o produto cujo nome corresponde ao nome fornecido 
     * (ignorando diferenças de maiúsculas e minúsculas), e substitui o produto existente pelo novo produto fornecido. 
     * A lista atualizada é então salva no arquivo especificado por `PRODUTO_FILE_PATH`. Uma mensagem de sucesso 
     * é exibida se o produto for editado, caso contrário, uma mensagem indicando que o produto não foi encontrado será exibida.
     * 
     * @param produtoEditado O produto com os novos dados que substituirá o produto existente na lista.
     */
    public static void editarProduto(Produto produtoEditado) {
        List<Produto> produtos = carregarProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(produtoEditado.getNome())) { // Usando nome como identificador
                produtos.set(i, produtoEditado); // Substitui o produto
                salvarProdutos(produtos); // Salva a lista atualizada
                System.out.println("Produto editado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }


    /**
     * Verifica se um produto está disponível em estoque com base no nome fornecido.
     * 
     * Este método carrega a lista de produtos e percorre todos os produtos, comparando o nome fornecido
     * (ignorando diferenças de maiúsculas e minúsculas) com o nome de cada produto na lista. Se um produto com
     * o nome fornecido for encontrado, o método verifica se a quantidade em estoque do produto é maior que zero.
     * O método retorna `true` se o produto estiver disponível (quantidade em estoque maior que zero) e `false`
     * se o produto não estiver disponível ou não for encontrado.
     * 
     * @param nomeProduto O nome do produto a ser verificado.
     * @return `true` se o produto estiver disponível em estoque (quantidade maior que zero), 
     *         `false` caso contrário (produto não encontrado ou sem estoque).
     * Apenas exibe o estoque atual, não verifica ################
     */
    public static boolean verificarDisponibilidade(String nomeProduto) {
        List<Produto> produtos = carregarProdutos();
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto.getQuantidadeEmEstoque() > 0; // Retorna true se o produto estiver disponível
            }
        }
        return false; // Retorna false se o produto não estiver disponível
    }


  
    /**
    * Salva uma lista de vendas no arquivo JSON.
    * 
    * Este método converte a lista de vendas fornecida para o formato JSON e escreve os dados no arquivo especificado
    * pelo caminho `VENDA_FILE_PATH`. Caso o processo de salvamento seja bem-sucedido, uma mensagem de sucesso será
    * exibida no console. Se ocorrer algum erro durante o salvamento, uma mensagem de erro será exibida.
    * 
    * @param vendas A lista de objetos `Venda` a ser salva no arquivo.
    */
   public static void salvarVendas(List<Venda> vendas) {
       Gson gson = new Gson();
       try (FileWriter writer = new FileWriter(VENDA_FILE_PATH)) {
           gson.toJson(vendas, writer);
           System.out.println("Vendas salvas com sucesso em " + VENDA_FILE_PATH);
       } catch (IOException e) {
           System.err.println("Erro ao salvar vendas: " + e.getMessage());
       }
   }



    /**
     * Carrega a lista de reservas a partir de um arquivo JSON.
     * 
     * Este método lê o arquivo especificado pelo caminho `RESERVA_FILE_PATH`, converte o conteúdo JSON
     * para uma lista de objetos `Reserva` e retorna essa lista. Se o arquivo não for encontrado ou ocorrer
     * algum erro durante o processo de leitura, será exibida uma mensagem de erro no console e uma lista vazia
     * será retornada.
     * 
     * @return Uma lista de objetos `Reserva` carregados a partir do arquivo JSON. Se ocorrer algum erro durante
     *         a leitura, uma lista vazia será retornada.
     */
    public static List<Reserva> carregarReservas() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(RESERVA_FILE_PATH)) {
            Type reservaListType = new TypeToken<ArrayList<Reserva>>(){}.getType();
            return gson.fromJson(reader, reservaListType);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de reservas não encontrado: " + RESERVA_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao carregar reservas: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    
    /**
     * Encontra um cliente na lista pelo CPF.
     * 
     * Este método utiliza um comparador para verificar se algum cliente na lista tem o mesmo CPF fornecido.
     * O CPF é usado como critério de comparação e, se encontrado, o cliente correspondente é retornado.
     * Caso contrário, o método retorna `null`.
     * 
     * @param clientes A lista de clientes onde a busca será realizada.
     * @param cpf O CPF do cliente que está sendo procurado.
     * @return O cliente encontrado com o CPF fornecido, ou `null` se o cliente não for encontrado.
     */
    public static Cliente find(List<Cliente> clientes, String cpf) {
        ClienteComparatorPorCPF comparator = new ClienteComparatorPorCPF();
        Cliente clienteComparado = new Cliente(cpf); // Usando o construtor que aceita apenas CPF

        Iterator<Cliente> iterator = clientes.iterator(); // Usando o Iterator manualmente
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (comparator.compare(cliente, clienteComparado) == 0) {
                return cliente; // Retorna o cliente encontrado
            }
        }
        return null; // Retorna null se não encontrar
    }

    
    

/**
 * Carrega a lista de produtos a partir de um arquivo JSON. O método utiliza um cache para evitar
 * a leitura do arquivo múltiplas vezes, carregando os produtos apenas na primeira execução.
 * Caso o arquivo não seja encontrado ou ocorra um erro de leitura, o cache será inicializado
 * com uma lista vazia.
 * 
 * @return Uma lista contendo os produtos carregados do arquivo. Se o arquivo não for encontrado
 *         ou ocorrer um erro na leitura, será retornada uma lista vazia.
 */
    public static List<Produto> carregarProdutos() {
        Object produtosCache = null;
        if (produtosCache == null) { // Verifica se o cache está vazio
            Gson gson = new Gson();
            try (FileReader reader = new FileReader(PRODUTO_FILE_PATH)) {
                Type produtoListType = new TypeToken<ArrayList<Produto>>(){}.getType();
                produtosCache = gson.fromJson(reader, produtoListType); // Carrega produtos no cache
                System.out.println("Produtos carregados: " + produtosCache);
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo de produtos não encontrado: " + PRODUTO_FILE_PATH);
                produtosCache = new ArrayList<>(); // Inicializa o cache vazio
            } catch (IOException e) {
                System.err.println("Erro ao carregar dados: " + e.getMessage());
                produtosCache = new ArrayList<>();
            }
        }
        return (List<Produto>) produtosCache; // Retorna o cache
    }


    /**
     * Salva a lista de relatórios em um arquivo JSON. O método converte a lista de relatórios para o formato
     * JSON e grava no arquivo especificado pela constante RELATORIO_FILE_PATH.
     * 
     * @param relatorios A lista de objetos {@link Relatorio} a ser salva no arquivo.
     */
    private void salvarRelatorios(List<Relatorio> relatorios) {
        try (FileWriter writer = new FileWriter(RELATORIO_FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(relatorios, writer); // Converte a lista de relatórios em JSON e escreve no arquivo
        } catch (IOException e) {
            System.err.println("Erro ao salvar relatórios: " + e.getMessage());
        }
    }



    /**
     * Carrega a lista de relatórios de vendas a partir de um arquivo JSON. O método lê o arquivo JSON,
     * converte seu conteúdo para uma lista de objetos {@link Relatorio} e armazena os dados.
     * Se o arquivo não for encontrado ou ocorrer um erro de leitura, o método captura a exceção e
     * imprime uma mensagem de erro. Caso o conteúdo do arquivo seja nulo, é inicializada uma lista vazia.
     * 
     *
     */
    private void carregarRelatorios() {
        try (FileReader reader = new FileReader(RELATORIO_FILE_PATH)) {
            Gson gson = new Gson();
            Type relatorioListType = new TypeToken<ArrayList<Relatorio>>(){}.getType();
            Object relatorios = gson.fromJson(reader, relatorioListType);
            if (relatorios == null) {
                relatorios = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de relatórios não encontrado: " + RELATORIO_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao carregar relatórios: " + e.getMessage());
        }
    }


}
