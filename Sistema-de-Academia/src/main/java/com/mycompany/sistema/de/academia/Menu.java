package com.mycompany.sistema.de.academia;

import Json.Json;
import Produtos.Loja;
import Produtos.Produto;
import Vendas.Venda;
import com.google.gson.Gson;
import gerenciamento.usuario.Cliente;
import gerenciamento.usuario.Funcionario;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import reservas.Reserva;
import reservas.SalaDeExercicio;

    /**
     * Classe responsável por exibir e gerenciar o menu principal do sistema de academia.
     * O menu permite ao usuário acessar e realizar diversas operações, como cadastro e
     * manipulação de colaboradores, clientes, reservas e produtos.
     * 
     * <p>O usuário pode selecionar opções para registrar entradas e saídas,
     * listar reservas e clientes, gerenciar o estoque e realizar vendas.</p>
     * 
     * @author daniel rodrigues
     */
    public class Menu {

    /**
         * Exibe o menu principal de opções do sistema para o usuário e gerencia a execução
         * das ações escolhidas. Cada opção chama um método específico para realizar operações
         * no sistema, como cadastrar, alterar ou excluir colaboradores, clientes e produtos,
         * além de gerenciar reservas e vendas.
         * 
         * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
         */
    static void exibirMenu(SistemaDeAcademia sistema) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Colaborador");
            System.out.println("2. Alterar Colaborador");
            System.out.println("3. Excluir Colaborador");
            System.out.println("4. Cadastrar Cliente");
            System.out.println("5. Alterar Cliente");
            System.out.println("6. Excluir Cliente");
            System.out.println("7. Verificar Vagas");
            System.out.println("8. Reservar Sala");
            System.out.println("9. Liberar Sala");
            System.out.println("10. Listar Reservas");
            System.out.println("11. Registrar Entrada na Catraca");
            System.out.println("12. Registrar Saída na Catraca");
            System.out.println("13. Exibir Quantidade de Instâncias de Cliente");
            System.out.println("14. Listar Clientes Ordenados");
            System.out.println("15. Verificar Produtos no Estoque");
            System.out.println("16. Cadastrar Produto");
            System.out.println("17. Remover Produto");
            System.out.println("18. Exibir quantidade de produtos cadastrados");
            System.out.println("19. Listar Reservas Ordenadas");
            System.out.println("20. Realizar Venda");
            System.out.println("21. Instancia do Iterator: ");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: cadastrarColaborador(sistema, scanner); break;
                case 2: alterarColaborador(sistema, scanner); break;
                case 3: excluirColaborador(sistema, scanner); break;
                case 4: cadastrarCliente(sistema, scanner); break;
                case 5: alterarCliente(sistema, scanner); break;
                case 6: excluirCliente(sistema, scanner); break;
                case 7: verificarVagas(sistema); break;
                case 8: reservarSala(sistema, scanner); break;
                case 9: liberarSala(sistema, scanner); break;
                case 10: listarReservas(sistema); break;
                case 11: registrarEntradaCatraca(sistema, scanner); break;
                case 12: registrarSaidaCatraca(sistema, scanner); break;
                case 13:
                    System.out.println("Quantidade de instâncias de Cliente: " + Cliente.getQuantidadeInstancias());
                    break;
                case 14: listarClientesOrdenados(sistema, scanner); break;
                case 15: VerificarProdutosEstoque(sistema, scanner); break;
                case 16: cadastrarProduto(sistema, scanner); break;
                case 17: removerProduto(sistema, scanner); break; 
                case 18: System.out.println("Quantidade de produtos cadastrados: " + Produto.getQuantidadeInstancias());
                    break;
                case 19: listarReservasOrdenadas(sistema); break;
                    case 20: realizarVenda(sistema, scanner); break; 
                    case 21: sistema.exibirClientesComIterator();
                    break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Registra a entrada de um cliente na catraca da academia.
     * <p>
     * Este método verifica se a catraca do sistema está inicializada. Caso esteja, 
     * solicita ao usuário o CPF do cliente, realiza a busca pelo cliente no sistema
     * e, se encontrado, registra a entrada do cliente na catraca. Caso contrário, 
     * exibe uma mensagem de erro indicando que o cliente não foi encontrado.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a catraca.
     * @param scanner O objeto {@link Scanner} utilizado para ler a entrada do usuário.
     */
    private static void registrarEntradaCatraca(SistemaDeAcademia sistema, Scanner scanner) {
        if (sistema.getCatraca() == null) {
            System.out.println("Erro: Catraca não inicializada.");
            return;
        }

        System.out.print("Digite o CPF do cliente que está entrando: ");
        String cpf = scanner.nextLine();
            Cliente cliente = sistema.buscarClientePorCpf(cpf);

        if (cliente != null) {
            sistema.getCatraca().registrarEntrada(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    /**
     * Registra a saída de um cliente na catraca da academia.
     * <p>
     * Este método solicita o CPF do cliente, busca o cliente no sistema, 
     * e, caso ele seja encontrado, verifica se a catraca está inicializada 
     * para registrar a saída. Exibe uma mensagem de sucesso ou, caso contrário, 
     * uma mensagem de erro caso o cliente não seja encontrado ou a catraca não esteja inicializada.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a catraca.
     * @param scanner O objeto {@link Scanner} usado para ler o CPF do cliente que está saindo.
     */
    private static void registrarSaidaCatraca(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.print("Digite o CPF do cliente que está saindo: ");
        String cpf = scanner.nextLine();
        Cliente cliente = sistema.buscarClientePorCpf(cpf);

        if (cliente != null) {
            if (sistema.getCatraca() != null) {
                sistema.getCatraca().registrarSaida(cliente);
                System.out.println("Saída registrada com sucesso para o cliente: " + cliente.getNome());
            } else {
                System.out.println("Erro: Catraca não inicializada.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    /**
     * Verifica a disponibilidade de vagas em uma sala específica de exercício.
     * <p>
     * Este método solicita o nome da sala ao usuário, busca a sala no sistema, 
     * e exibe a quantidade de vagas disponíveis se a sala for encontrada. 
     * Caso a sala não seja encontrada, uma mensagem de erro é exibida.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo as salas de exercício.
     */
    private static void verificarVagas(SistemaDeAcademia sistema) {
        System.out.print("Digite o nome da sala para verificar as vagas: ");
        Scanner scanner = new Scanner(System.in);
        String nomeSala = scanner.nextLine();
        SalaDeExercicio sala = sistema.buscarSalaPorNome(nomeSala);

        if (sala != null) {
            System.out.println("Vagas disponíveis na " + nomeSala + ": " + sala.getVagasDisponiveis());
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Lista os clientes cadastrados no sistema, ordenando-os por nome e CPF.
     * <p>
     * Este método carrega os clientes a partir de um arquivo JSON, verifica se existem clientes
     * cadastrados, e exibe a lista de clientes ordenada primeiro por nome e, em seguida, por CPF.
     * Caso não haja clientes cadastrados, uma mensagem é exibida.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
        private static void listarClientesOrdenados(SistemaDeAcademia sistema, Scanner scanner) {
            List<Cliente> clientes = Json.carregarClientes(); // Carrega os clientes do JSON

            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
                return;
            }

            // Ordena os clientes por nome
            Collections.sort(clientes, Comparator.comparing(Cliente::getNome));
            System.out.println("Clientes ordenados por nome:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
            }

            // Ordena os clientes por CPF
            Collections.sort(clientes, Comparator.comparing(Cliente::getCpf));
            System.out.println("\nClientes ordenados por CPF:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
            }

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
        }

    /**
     * Cadastra um novo colaborador (funcionário) no sistema.
     * <p>
     * Este método solicita as informações necessárias para cadastrar um colaborador no sistema,
     * incluindo nome, CPF, login, senha e função. Após criar o objeto {@link Funcionario}, o colaborador
     * é adicionado à lista de funcionários do sistema e os dados são salvos em um arquivo JSON.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
    private static void cadastrarColaborador(SistemaDeAcademia sistema, Scanner scanner) {
            System.out.println("Digite o nome do colaborador:");
            String nome = scanner.nextLine();
            System.out.println("Digite o CPF do colaborador:");
            String cpf = scanner.nextLine();
            System.out.println("Digite o login do colaborador:");
            String login = scanner.nextLine();
            System.out.println("Digite a senha do colaborador:");
            String senha = scanner.nextLine();
            System.out.println("Digite a função do colaborador:");
            String funcao = scanner.nextLine();
            String idFuncionario = "F" + (sistema.getFuncionarios().size() + 1);

            Funcionario colaborador = new Funcionario(nome, cpf, login, senha, funcao, idFuncionario);
            sistema.getFuncionarios().add(colaborador);
            System.out.println("Colaborador cadastrado com sucesso!");

          
            Json.salvarFuncionarios(sistema.getFuncionarios());
        }

    /**
     * Altera as informações de um colaborador existente no sistema.
     * <p>
     * Este método permite ao usuário alterar as informações de um colaborador, como nome, login e senha.
     * O colaborador é identificado pelo CPF, e as novas informações são fornecidas pelo usuário. 
     * Caso o usuário não forneça um novo valor para algum campo, o valor atual é mantido.
     * Após as alterações, as informações do colaborador são atualizadas e salvas em um arquivo JSON.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
    private static void alterarColaborador(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o CPF do colaborador que deseja alterar:");
        String cpf = scanner.nextLine();
        Funcionario colaborador = sistema.buscarFuncionarioPorCpf(cpf);

        if (colaborador != null) {
            System.out.println("Digite o novo nome (ou pressione Enter para manter o atual):");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                colaborador.setNome(novoNome);
            }
            System.out.println("Digite o novo login (ou pressione Enter para manter o atual):");
            String novoLogin = scanner.nextLine();
            if (!novoLogin.isEmpty()) {
                colaborador.setLogin(novoLogin);
            }
            System.out.println("Digite a nova senha (ou pressione Enter para manter a atual):");
            String novaSenha = scanner.nextLine();
            if (!novaSenha.isEmpty()) {
                colaborador.setSenha(novaSenha);
            }
            System.out.println("Colaborador alterado com sucesso!");

            // Salva os funcionários no arquivo JSON após a alteração
            Json.salvarFuncionarios(sistema.getFuncionarios());
        } else {
            System.out.println("Colaborador não encontrado.");
        }
    }

    /**
         * Exclui um colaborador do sistema.
         * <p>
         * Este método permite ao usuário excluir um colaborador do sistema, identificando-o pelo CPF.
         * Após a exclusão, o colaborador é removido tanto da lista de colaboradores em memória quanto do arquivo JSON
         * que armazena os dados persistentes. A lista de colaboradores é então atualizada e salva novamente no arquivo.
         * </p>
         * 
         * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
         * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
         */
    private static void excluirColaborador(SistemaDeAcademia sistema, Scanner scanner) {
            System.out.println("Digite o CPF do colaborador que deseja excluir:");
            String cpf = scanner.nextLine();
            Funcionario colaborador = sistema.buscarFuncionarioPorCpf(cpf);

            if (colaborador != null) {
                // Remove o colaborador da lista em memória
                sistema.getFuncionarios().remove(colaborador);

                // Remove o colaborador do JSON
                Json.removerFuncionario(cpf); 

                // Salva a lista atualizada de funcionários
                Json.salvarFuncionarios(sistema.getFuncionarios());

                System.out.println("Colaborador excluído com sucesso!");
            } else {
                System.out.println("Colaborador não encontrado.");
            }
        }

    /**
     * Cadastra um novo cliente no sistema.
     * <p>
     * Este método permite ao usuário cadastrar um novo cliente fornecendo informações como nome, CPF, login e senha.
     * Após o cadastro, o cliente é adicionado à lista de clientes em memória e ao arquivo JSON que armazena os dados persistentes.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
    private static void cadastrarCliente(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o login do cliente:");
        String login = scanner.nextLine();
        System.out.println("Digite a senha do cliente:");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, login, senha);
        sistema.getClientes().add(cliente);
        sistema.adicionarCliente(cliente);
        Json.salvarClientes(sistema.getClientes()); // Salva após o cadastro
        System.out.println("Cliente cadastrado com sucesso!");
    }

    /**
     * Altera os dados de um cliente existente no sistema.
     * <p>
     * Este método permite ao usuário alterar o nome e a senha de um cliente, identificando-o por seu CPF.
     * Se o usuário não fornecer um novo valor, os dados atuais do cliente permanecem inalterados. Após a alteração,
     * os dados do cliente são salvos no arquivo JSON para persistência.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
    private static void alterarCliente(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o CPF do cliente que deseja alterar:");
        String cpf = scanner.nextLine();
        Cliente cliente = sistema.buscarClientePorCpf(cpf);

        if (cliente != null) {
            System.out.println("Digite o novo nome (ou pressione Enter para manter o atual):");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }
            System.out.println("Digite a nova senha (ou pressione Enter para manter a atual):");
            String novaSenha = scanner.nextLine();
            if (!novaSenha.isEmpty()) {
                cliente.setSenha(novaSenha);
            }

            // Salva as alterações no cliente no arquivo JSON
            Json.editarCliente(cliente);
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    /**
     * Exclui um cliente do sistema.
     * <p>
     * Este método permite ao usuário excluir um cliente do sistema, identificando-o por seu CPF.
     * Se o cliente for encontrado, ele será removido da lista local de clientes e também do arquivo JSON.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia.
     * @param scanner O objeto {@link Scanner} utilizado para interação com o usuário.
     */
    private static void excluirCliente(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o CPF do cliente que deseja excluir:");
        String cpf = scanner.nextLine();
        Cliente cliente = sistema.buscarClientePorCpf(cpf);

        if (cliente != null) {
            sistema.getClientes().remove(cliente); // Remove da lista local
            Json.removerCliente(cpf); // Remove do JSON
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    /**
     * Reserva uma sala de exercício para um cliente em uma data específica.
     * <p>
     * Este método permite que um cliente reserve uma sala de exercício, fornecendo o nome da sala e a data desejada para a reserva. 
     * O método verifica se a sala existe e se a data fornecida é válida. Caso a sala não seja encontrada ou a data seja inválida,
     * uma mensagem de erro é exibida.
     * </p>
     * 
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo reservas de salas.
     * @param scanner O objeto {@link Scanner} utilizado para capturar as entradas do usuário, como o nome da sala, nome do cliente e a data da reserva.
     */
    private static void reservarSala(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o nome da sala a reservar:");
        String nomeSala = scanner.nextLine();
        SalaDeExercicio sala = sistema.buscarSalaPorNome(nomeSala);

        if (sala != null) {
            System.out.println("Digite o nome do cliente:");
            String clienteNome = scanner.nextLine(); // Solicita o nome do cliente

            System.out.println("Digite a data da reserva (formato dd/MM/yyyy):");
            String dataString = scanner.nextLine();
            Date data;
            try {
                data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
                sistema.reservarSala(sala, clienteNome, data); // Passa o cliente e a data
                System.out.println("Sala reservada com sucesso para " + clienteNome + " na data " + dataString + "!");
            } catch (ParseException e) {
                System.out.println("Data inválida.");
            }
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Libera uma sala de exercício que foi reservada por um cliente.
     * <p>
     * Este método permite que uma sala de exercício seja liberada após o uso de um cliente. O nome da sala e o nome do cliente que
     * está utilizando a sala são solicitados. Se a sala existir, o método chama o procedimento para liberar a sala. Caso contrário,
     * uma mensagem de erro é exibida.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a liberação de salas.
     * @param scanner O objeto {@link Scanner} utilizado para capturar as entradas do usuário, como o nome da sala e o nome do cliente.
     */
    private static void liberarSala(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.println("Digite o nome da sala a liberar:");
        String nomeSala = scanner.nextLine();
        SalaDeExercicio sala = sistema.buscarSalaPorNome(nomeSala);

        if (sala != null) {
            System.out.println("Digite o nome do cliente para liberar a sala:");
            String clienteNome = scanner.nextLine();

            // Chama o método que não retorna nada
            sistema.liberarSala(sala, clienteNome);
            System.out.println("Sala liberada com sucesso!");
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Exibe todas as reservas registradas no sistema de academia.
     * <p>
     * Este método verifica se há reservas registradas no sistema. Se houver, ele exibe cada uma delas, utilizando o método
     * {@link Reserva#toString()} para formatar a saída. Caso não haja nenhuma reserva, uma mensagem informando a ausência de reservas é exibida.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo as reservas.
     */
    private static void listarReservas(SistemaDeAcademia sistema) {
        if (sistema.getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
            return;
        }

        System.out.println("Reservas registradas:");
        for (Reserva reserva : sistema.getReservas()) {
            System.out.println(reserva.toString());
        }
    }

    /**
     * Exibe os produtos disponíveis no estoque da loja da academia.
     * <p>
     * Este método verifica se a loja está configurada no sistema e, caso positivo, recupera e exibe todos os produtos disponíveis no estoque.
     * Caso o estoque esteja vazio, uma mensagem informando isso será exibida. Caso contrário, são apresentados os detalhes de cada produto,
     * como ID, nome, preço, quantidade disponível, validade e categoria.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a loja e seu estoque.
     * @param scanner O objeto {@link Scanner} utilizado para capturar entradas do usuário, caso necessário para a interação.
     */
    private static void VerificarProdutosEstoque(SistemaDeAcademia sistema, Scanner scanner) {
        Loja loja = sistema.getLoja();

        if (loja != null) {
            ArrayList<Produto> produtos = loja.getEstoque().getProdutos(); // Obtém a lista de produtos do estoque

            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto disponível no estoque.");
            } else {
                System.out.println("Produtos disponíveis no estoque:");
                for (Produto produto : produtos) {
                    System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() +
                            ", Quantidade: " + produto.getQuantidade() + ", Validade: " + produto.getValidade() + ", Categoria: " + produto.getCategoria());
                }
            }
        } else {
            System.out.println("A loja não está configurada no sistema.");
        }
    }

    /**
     * Cadastra um novo produto no estoque da loja da academia.
     * <p>
     * Este método solicita ao usuário informações sobre o produto, como nome, preço, quantidade disponível e categoria, e em seguida
     * cria um novo objeto {@link Produto}. O produto é então adicionado ao estoque da loja, e as informações são salvas usando o
     * método {@link Json#adicionarProduto(Produto)} para persistência.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a loja e seu estoque.
     * @param scanner O objeto {@link Scanner} utilizado para capturar entradas do usuário.
     */
    private static void cadastrarProduto(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Informe a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Informe a categoria do produto: ");
        String categoria = scanner.nextLine();

        // Cria um novo produto e adiciona ao estoque
        Produto novoProduto = new Produto(nome, preco, quantidade, categoria); // Removendo validade
        Json.adicionarProduto(novoProduto);
    }

    /**
     * Remove um produto do estoque da loja da academia.
     * <p>
     * Este método solicita ao usuário o nome do produto que deseja remover e, em seguida, utiliza o método {@link Json#removerProduto(String)} 
     * para remover o produto correspondente do estoque da loja.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que gerencia as operações da academia, incluindo a loja e seu estoque.
     * @param scanner O objeto {@link Scanner} utilizado para capturar a entrada do usuário.
     */
    private static void removerProduto(SistemaDeAcademia sistema, Scanner scanner) {
        System.out.print("Informe o nome do produto a ser removido: ");
        String nomeProduto = scanner.nextLine();

        // Remove o produto do estoque
        Json.removerProduto(nomeProduto);
    }

    /**
     * Lista as reservas ordenadas com base na escolha do usuário, seja por data ou por hora.
     * <p>
     * O método solicita ao usuário que escolha como as reservas devem ser ordenadas (por data ou por hora), 
     * e, em seguida, ordena a lista de reservas de acordo com a opção selecionada. 
     * As reservas ordenadas são então exibidas.
     * </p>
     *
     * @param sistema O objeto {@link SistemaDeAcademia} que contém a lista de reservas a ser ordenada e exibida.
     */
    public static void listarReservasOrdenadas(SistemaDeAcademia sistema) {
        List<Reserva> reservas = sistema.getReservas(); // Supondo que você tenha um método getReservas() em SistemaDeAcademia

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a opção para ordenar as reservas:");
        System.out.println("1. Ordenar por Data");
        System.out.println("2. Ordenar por Hora");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            Collections.sort(reservas, new Reserva.ComparadorPorData());
            System.out.println("Reservas ordenadas por data:");
        } else if (opcao == 2) {
            Collections.sort(reservas, new Reserva.ComparadorPorHora());
            System.out.println("Reservas ordenadas por hora:");
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        // Exibe as reservas ordenadas
        for (Reserva reserva : reservas) {
            reserva.gerarExtrato();  // Método que imprime os detalhes da reserva
        }
    }

    /**
     * Salva a lista de reservas em um arquivo JSON.
     * <p>
     * Este método converte a lista de reservas em formato JSON usando a biblioteca Gson e salva 
     * as reservas em um arquivo especificado. Caso ocorra um erro durante o processo de escrita, 
     * o erro será capturado e uma mensagem de erro será exibida.
     * </p>
     *
     * @param reservas A lista de {@link Reserva} que será convertida para JSON e salva no arquivo.
     */
    public static void salvarReservas(List<Reserva> reservas) {
        Gson gson = new Gson();
        String json = gson.toJson(reservas);
        String RESERVA_FILE_PATH = "src\\main\\java\\reservas\\Reserva.java";
        try (FileWriter writer = new FileWriter(RESERVA_FILE_PATH)) {
            writer.write(json);
            System.out.println("Reservas salvas com sucesso em " + RESERVA_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }

    /**
     * Realiza a venda de produtos em um sistema de academia.
     * <p>
     * Este método exibe a lista de produtos disponíveis para venda, permite ao usuário escolher os produtos e a quantidade desejada, 
     * e realiza a venda, atualizando o estoque e o total da compra. O usuário pode continuar comprando até decidir finalizar a compra.
     * </p>
     *
     * @param sistema O sistema da academia, que contém a lista de produtos disponíveis para venda.
     * @param scanner O scanner utilizado para capturar as entradas do usuário no console.
     */
    public static void realizarVenda(SistemaDeAcademia sistema, Scanner scanner) {
    // Solicitar o CPF do cliente
    System.out.print("Digite o CPF do cliente para vincular à venda: ");
    String cpfCliente = scanner.nextLine();

    // Verificar se a lista de produtos não é nula ou vazia
    List<Produto> produtos = sistema.getProdutos();
    if (produtos == null || produtos.isEmpty()) {
        System.out.println("Nenhum produto disponível para venda.");
        return;
    }

    // Exibir os produtos disponíveis
    System.out.println("Produtos disponíveis:");
    for (int i = 0; i < produtos.size(); i++) {
        Produto p = produtos.get(i);
        System.out.println((i + 1) + ". " + p.getNome() + " - R$ " + p.getPreco() + " (Estoque: " + p.getQuantidadeEmEstoque() + ")");
    }

    // Inicializar o total da venda
    double totalVenda = 0.0;

    // Loop para permitir a compra de múltiplos produtos
    while (true) {
        // Solicitar dados para a venda
        System.out.print("Digite o número ou o nome do produto (ou 0 para finalizar a compra): ");
        String input = scanner.nextLine();

        // Verificar se o usuário deseja finalizar a compra
        if (input.equals("0")) {
            break;
        }

        Produto produtoSelecionado = null;

        try {
            // Tentar interpretar a entrada como um número
            int numeroProduto = Integer.parseInt(input);

            // Validar o número do produto
            if (numeroProduto < 1 || numeroProduto > produtos.size()) {
                System.out.println("Produto inválido!");
                continue; // Voltar para o início do loop
            }

            // Selecionar o produto pelo índice
            produtoSelecionado = produtos.get(numeroProduto - 1);
        } catch (NumberFormatException e) {
            // Se não for um número, buscar pelo nome do produto
            produtoSelecionado = buscarProdutoPorNome(produtos, input);

            if (produtoSelecionado == null) {
                System.out.println("Produto não encontrado!");
                continue; // Voltar para o início do loop
            }
        }

        // Solicitar a quantidade desejada
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se a quantidade está disponível em estoque
        if (produtoSelecionado.getQuantidadeEmEstoque() < quantidade) {
            System.out.println("Estoque insuficiente! Temos apenas " + produtoSelecionado.getQuantidadeEmEstoque() + " unidades.");
            continue; // Voltar para o início do loop
        }

        // Atualizar o estoque
        produtoSelecionado.setQuantidadeEmEstoque(produtoSelecionado.getQuantidadeEmEstoque() - quantidade);

        // Atualizar o total da venda
        double valorVenda = produtoSelecionado.getPreco() * quantidade;
        totalVenda += valorVenda;

        // Exibir o resumo da compra
        System.out.println("-------------------------------------------------");
        System.out.println("RELATÓRIO DA COMPRA");
        System.out.println("-------------------------------------------------");
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Produto: " + produtoSelecionado.getNome());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Subtotal: R$ " + valorVenda);
        System.out.println("-------------------------------------------------");
    }

    // Exibir o total da venda
    System.out.println("-------------------------------------------------");
    System.out.println("TOTAL DA VENDA: R$ " + totalVenda);
    System.out.println("-------------------------------------------------");
    System.out.println("Obrigado pela compra!");
}

    /**
     * Busca um produto na lista de produtos com base no nome.
     *
     * @param produtos    A lista de produtos a ser pesquisada.
     * @param nomeProduto O nome do produto que está sendo buscado.
     * @return O produto correspondente ao nome fornecido, ou null se o produto não for encontrado.
     */
    public static Produto buscarProdutoPorNome(List<Produto> produtos, String nomeProduto) {
    for (Produto p : produtos) {
        if (p.getNome().equalsIgnoreCase(nomeProduto)) {
            return p;
        }
    }
    return null; // Produto não encontrado
}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{");
        sb.append('}');
        return sb.toString();
    }
}
