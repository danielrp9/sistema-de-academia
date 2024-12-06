package reservas;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Date;

/**
 * Classe que representa uma sala de exercício no sistema.
 * Contém informações sobre a sala e suas reservas.
 */
public class SalaDeExercicio {
    // Atributos
    private String nome;  // Nome da sala de exercício
    private int capacidade;  // Capacidade máxima da sala
    private int vagasOcupadas;  // Quantidade de vagas ocupadas
    private String tipoDeExercicio;  // Tipo de exercício oferecido na sala
    private List<Reserva> reservas;  // Lista de reservas realizadas na sala

    /**
     * Construtor da classe SalaDeExercicio.
     * 
     * @param nome             Nome da sala de exercício.
     * @param capacidade       Capacidade máxima da sala.
     * @param tipoDeExercicio  Tipo de exercício que a sala oferece.
     */
    public SalaDeExercicio(String nome, int capacidade, String tipoDeExercicio) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipoDeExercicio = tipoDeExercicio;
        this.vagasOcupadas = 0; // Inicializa com 0 vagas ocupadas
        this.reservas = new ArrayList<>(); // Inicializa a lista de reservas
    }

    // Métodos Getters e Setters

    /**
     * Retorna o nome da sala de exercício.
     * 
     * @return Nome da sala de exercício.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da sala de exercício.
     * 
     * @param nome Nome da sala de exercício.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a capacidade máxima da sala de exercício.
     * 
     * @return Capacidade da sala de exercício.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade máxima da sala de exercício.
     * 
     * @param capacidade Capacidade da sala de exercício.
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Retorna o tipo de exercício que a sala oferece.
     * 
     * @return Tipo de exercício da sala.
     */
    public String getTipoDeExercicio() {
        return tipoDeExercicio;
    }

    /**
     * Define o tipo de exercício que a sala oferece.
     * 
     * @param tipoDeExercicio Tipo de exercício da sala.
     */
    public void setTipoDeExercicio(String tipoDeExercicio) {
        this.tipoDeExercicio = tipoDeExercicio;
    }

    /**
     * Retorna o número de vagas ocupadas na sala.
     * 
     * @return Vagas ocupadas.
     */
    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    /**
     * Retorna o número de vagas disponíveis na sala.
     * 
     * @return Vagas disponíveis.
     */
    public int getVagasDisponiveis() {
        return capacidade - vagasOcupadas; // Calcula as vagas disponíveis
    }

    // Métodos de Operação

    /**
     * Realiza a reserva de uma sala de exercício para um cliente.
     * 
     * @param clienteNome Nome do cliente que deseja realizar a reserva.
     * @param data       Data da reserva.
     * @return Retorna true se a reserva for realizada com sucesso, caso contrário, false.
     */
    public boolean reservarSala(String clienteNome, Date data) {
        if (getVagasDisponiveis() > 0) {
            Reserva novaReserva = new Reserva(clienteNome, data); // Inclui data na reserva
            reservas.add(novaReserva);
            vagasOcupadas++;
            System.out.println("Sala reservada com sucesso para " + clienteNome + " na data " + data + "!");
            return true;
        } else {
            System.out.println("Não é possível reservar a sala, vagas esgotadas!");
            return false;
        }
    }

    /**
     * Libera a reserva de uma sala de exercício para um cliente.
     * 
     * @param clienteNome Nome do cliente cuja reserva será liberada.
     * @return Retorna true se a reserva for liberada com sucesso, caso contrário, false.
     */
    public boolean liberarSala(String clienteNome) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeCliente().equals(clienteNome)) {
                reservas.remove(reserva);
                vagasOcupadas--;
                System.out.println("Reserva liberada para " + clienteNome + "!");
                return true;
            }
        }
        System.out.println("Não há reserva para " + clienteNome + " na sala.");
        return false;
    }

    /**
     * Retorna uma lista com todas as reservas feitas na sala.
     * 
     * @return Lista de reservas.
     */
    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas); // Retorna uma cópia da lista de reservas
    }

    /**
     * Classe interna que representa uma reserva na sala de exercício.
     */
    public static class Reserva {
        private String nomeCliente; // Nome do cliente que fez a reserva
        private Date data; // Data da reserva

        /**
         * Construtor da classe Reserva.
         * 
         * @param nomeCliente Nome do cliente que fez a reserva.
         * @param data       Data da reserva.
         */
        public Reserva(String nomeCliente, Date data) {
            this.nomeCliente = nomeCliente;
            this.data = data;
        }

        /**
         * Retorna o nome do cliente que fez a reserva.
         * 
         * @return Nome do cliente.
         */
        public String getNomeCliente() {
            return nomeCliente;
        }

        /**
         * Retorna a data da reserva.
         * 
         * @return Data da reserva.
         */
        public Date getData() {
            return data;
        }

        /**
         * Retorna uma representação em string da reserva.
         * 
         * @return Representação em string da reserva.
         */
        @Override
        public String toString() {
            return "Reserva{" +
                   "nomeCliente='" + nomeCliente + '\'' +
                   ", data=" + data +
                   '}';
        }
    }

    // Comparadores implementando Comparator

    /**
     * Compara duas salas de exercício pelo nome.
     */
    public static class SalaDeExercicioComparatorPorNome implements Comparator<SalaDeExercicio> {
        @Override
        public int compare(SalaDeExercicio s1, SalaDeExercicio s2) {
            return s1.getNome().compareTo(s2.getNome());
        }
    }

    /**
     * Compara duas salas de exercício pela capacidade.
     */
    public static class SalaDeExercicioComparatorPorCapacidade implements Comparator<SalaDeExercicio> {
        @Override
        public int compare(SalaDeExercicio s1, SalaDeExercicio s2) {
            return Integer.compare(s1.getCapacidade(), s2.getCapacidade());
        }
    }

    /**
     * Compara duas salas de exercício pelo número de vagas disponíveis.
     */
    public static class SalaDeExercicioComparatorPorVagasDisponiveis implements Comparator<SalaDeExercicio> {
        @Override
        public int compare(SalaDeExercicio s1, SalaDeExercicio s2) {
            return Integer.compare(s1.getVagasDisponiveis(), s2.getVagasDisponiveis());
        }
    }

    /**
     * Compara duas salas de exercício pelo tipo de exercício.
     */
    public static class SalaDeExercicioComparatorPorTipoDeExercicio implements Comparator<SalaDeExercicio> {
        @Override
        public int compare(SalaDeExercicio s1, SalaDeExercicio s2) {
            return s1.getTipoDeExercicio().compareTo(s2.getTipoDeExercicio());
        }
    }

    /**
     * Retorna uma representação em string da sala de exercício.
     * 
     * @return Representação em string da sala de exercício.
     */
    @Override
    public String toString() {
        return "SalaDeExercicio{" +
               "nome='" + nome + '\'' +
               ", capacidade=" + capacidade +
               ", vagasOcupadas=" + vagasOcupadas +
               ", tipoDeExercicio='" + tipoDeExercicio + '\'' +
               ", reservas=" + reservas +
               '}';
    }
}
