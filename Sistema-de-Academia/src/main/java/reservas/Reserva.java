package reservas;

import gerenciamento.usuario.Cliente;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Comparator;

/**
 * Classe que representa uma Reserva de uma sala de exercício.
 */
public class Reserva {
    private Cliente cli;
    private SalaDeExercicio sala;
    private Date data;
    private Time hora;
    private boolean conf;

    /**
     * Construtor da classe Reserva.
     * Inicializa os atributos da reserva com os valores fornecidos.
     *
     * @param cli O cliente que fez a reserva.
     * @param sala A sala de exercício reservada.
     * @param data A data da reserva.
     * @param hora O horário da reserva.
     * @param conf O status da reserva (confirmada ou não).
     */
    public Reserva(Cliente cli, SalaDeExercicio sala, Date data, Time hora, boolean conf) {
        this.cli = cli;
        this.sala = sala;
        this.data = data;
        this.hora = hora;
        this.conf = conf;
    }

    private Reserva(String nomeSala, String nomeCliente, String dataReserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Reserva(String string, String produto_A, String string0, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Construtor alternativo da classe Reserva.
     * Este construtor é gerado automaticamente e não está implementado.
     *
     */

    public void reservarSala(String nomeSala, String nomeCliente, String dataReserva) {
    Reserva novaReserva = new Reserva(nomeSala, nomeCliente, dataReserva);
    // Adicione lógica para armazenar a nova reserva
}


    /**
     * Gera e exibe o extrato da reserva.
     */
    public void gerarExtrato() {
        System.out.println("Extrato da Reserva:");
        System.out.println("Cliente: " + cli.getNome());
        System.out.println("CPF: " + cli.getCpf());
        System.out.println("Sala: " + sala.getNome());
        System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(data));
        System.out.println("Hora: " + hora);
        System.out.println("Status: " + (conf ? "Confirmada" : "Pendente"));
    }

    // Métodos para confirmar ou cancelar a reserva

    /**
     * Confirma a reserva.
     */
    public void confirmar() {
        this.conf = true;
    }

    /**
     * Cancela a reserva.
     */
    public void cancelar() {
        this.conf = false;
    }

    // Getters e Setters

    /**
     * Obtém o cliente da reserva.
     *
     * @return O cliente que fez a reserva.
     */
    public Cliente getCliente() {
        return cli;
    }

    /**
     * Define o cliente da reserva.
     *
     * @param cli O cliente a ser definido.
     */
    public void setCliente(Cliente cli) {
        this.cli = cli;
    }

    /**
     * Obtém a sala de exercício da reserva.
     *
     * @return A sala de exercício reservada.
     */
    public SalaDeExercicio getSala() {
        return sala;
    }

    /**
     * Define a sala de exercício da reserva.
     *
     * @param sala A sala a ser definida.
     */
    public void setSala(SalaDeExercicio sala) {
        this.sala = sala;
    }

    /**
     * Obtém a data da reserva.
     *
     * @return A data da reserva.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data da reserva.
     *
     * @param data A data a ser definida.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém a hora da reserva.
     *
     * @return A hora da reserva.
     */
    public Time getHora() {
        return hora;
    }

    /**
     * Define a hora da reserva.
     *
     * @param hora A hora a ser definida.
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * Verifica se a reserva está confirmada.
     *
     * @return true se a reserva está confirmada, false caso contrário.
     */
    public boolean isConfirmada() {
        return conf;
    }

    /**
     * Define o status da reserva como confirmada ou não.
     *
     * @param conf O status a ser definido.
     */
    public void setConfirmada(boolean conf) {
        this.conf = conf;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "cli=" + cli.getNome() +
                ", sala=" + sala.getNome() +
                ", data=" + new SimpleDateFormat("dd/MM/yyyy").format(data) +
                ", hora=" + hora +
                ", conf=" + conf +
                '}';
    }

    /**
     * Cancela a reserva.
     * Este método não está implementado.
     */
    public void cancelarReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Gerado automaticamente
    }

    public String getNomeCliente() {
         return cli.getNome();
     }

     public String getCpfCliente() {
         return cli.getCpf();
     }

     public String getHorario() {
         return hora.toString();
     }

    public void add(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    /**
     * Comparador de reservas por data.
     */
    public static class ComparadorPorData implements Comparator<Reserva> {
        @Override
        public int compare(Reserva r1, Reserva r2) {
            return r1.getData().compareTo(r2.getData());
        }
    }

    /**
     * Comparador de reservas por horário.
     */
    public static class ComparadorPorHora implements Comparator<Reserva> {
        @Override
        public int compare(Reserva r1, Reserva r2) {
            return r1.getHora().compareTo(r2.getHora());
        }
    }
}
