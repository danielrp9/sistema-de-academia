package gerenciamento.usuario;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import reservas.Reserva;
import reservas.SalaDeExercicio;

/**
 * Classe responsável pela gestão das reservas de salas de exercício na academia.
 * Permite adicionar salas, fazer reservas, cancelar reservas e listar reservas existentes.
 * 
 * @author Daniel Rodrigues
 */
public class GestaoDeReservas {

    // Atributos
    private ArrayList<Reserva> reservas;
    private ArrayList<SalaDeExercicio> salas;

    /**
     * Construtor da classe {@link GestaoDeReservas}.
     * Inicializa as listas de reservas e salas.
     */
    public GestaoDeReservas() {
        this.reservas = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova sala de exercício à lista de salas.
     *
     * @param sala A sala de exercício a ser adicionada.
     */
    public void adicionarSala(SalaDeExercicio sala) {
        salas.add(sala);
    }

    /**
     * Adiciona uma nova reserva para uma sala de exercício, se houver vagas disponíveis.
     * A reserva será adicionada à lista de reservas se a sala estiver disponível.
     * 
     * @param nomeCliente O nome do cliente que está reservando a sala.
     * @param cpfCliente O CPF do cliente que está reservando a sala.
     * @param sala A sala de exercício a ser reservada.
     * @param data A data da reserva.
     * @param horario O horário da reserva.
     */
    public void adicionarReserva(String nomeCliente, String cpfCliente, SalaDeExercicio sala, Date data, Time horario) {
        if (sala.getVagasDisponiveis() > 0) {
            boolean reservaFeita = sala.reservarSala(nomeCliente, data);

            if (reservaFeita) {
                Cliente cliente = new Cliente(nomeCliente, cpfCliente); // Instancia um Cliente
                Reserva reserva = new Reserva(cliente, sala, data, horario, false);
                reservas.add(reserva);
                System.out.println("Reserva adicionada para " + nomeCliente);
            } else {
                System.out.println("Falha ao reservar a sala para " + nomeCliente);
            }
        } else {
            System.out.println("Não há vagas disponíveis na sala " + sala.getNome());
        }
    }

    /**
     * Cancela uma reserva existente e libera a sala correspondente.
     * A sala será liberada e a reserva será removida da lista de reservas.
     *
     * @param reserva A reserva a ser cancelada.
     */
    public void cancelarReserva(Reserva reserva) {
        reserva.cancelarReserva();
        reserva.getSala().liberarSala(reserva.getNomeCliente());
        reservas.remove(reserva);
        System.out.println("Reserva cancelada para " + reserva.getNomeCliente());
    }

    /**
     * Lista todas as reservas existentes na academia.
     * Exibe as reservas na saída padrão.
     */
    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    /**
     * Retorna uma representação em formato de string da gestão de reservas, incluindo as reservas
     * e as salas de exercício registradas.
     * 
     * @return Uma string representando a gestão de reservas.
     */
    @Override
    public String toString() {
        return "GestaoDeReservas{" + "reservas=" + reservas + ", salas=" + salas + '}';
    }
}
