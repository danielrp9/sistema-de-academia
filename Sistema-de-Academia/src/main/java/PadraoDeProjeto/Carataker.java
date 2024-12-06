import PadraoDeProjeto.Memento;
import java.util.Stack;

/**
 * A classe {@link Carataker} gerencia os estados anteriores e os estados refazer 
 * de um objeto originador, utilizando pilhas para armazenar esses estados. 
 * Ela permite a funcionalidade de desfazer e refazer ações, mantendo o histórico 
 * de estados utilizando o padrão de projeto Memento.
 * 
 * A classe tem duas pilhas: uma para os estados anteriores (desfazer) e outra 
 * para os estados que foram desfeitos e podem ser refeitos.
 * 
 * @author danie
 */
public class Carataker {
    private Stack<Memento> estadosAnteriores = new Stack<>();
    private Stack<Memento> estadosRefazer = new Stack<>();

    /**
     * Salva o estado atual de um objeto no histórico de estados anteriores.
     * Limpa o histórico de refazer, pois um novo estado foi salvo.
     * 
     * @param memento O estado atual a ser salvo no histórico de desfazer.
     */
    public void salvarEstado(Memento memento) {
        estadosAnteriores.push(memento);
        estadosRefazer.clear(); // Limpa o refazer, pois há um novo estado
    }

    /**
     * Desfaz o último estado salvo, movendo-o para o histórico de refazer.
     * Retorna o estado atual após o desfazer, ou o estado inicial se não houver mais estados a desfazer.
     * 
     * @return O estado atual após o desfazer, ou null se não houver mais estados para desfazer.
     */
    public Memento desfazer() {
        if (!estadosAnteriores.isEmpty()) {
            Memento estado = estadosAnteriores.pop(); // Remove o estado atual
            estadosRefazer.push(estado); // Salva no histórico de refazer
            return !estadosAnteriores.isEmpty() ? estadosAnteriores.peek() : estado; // Retorna o novo topo da pilha de desfazer
        }
        return null; // Se não houver mais estados para desfazer
    }

    /**
     * Refaz o último estado desfeito, movendo-o de volta para o histórico de desfazer.
     * Retorna o estado que foi "refeito".
     * 
     * @return O estado que foi "refeito", ou null se não houver mais estados para refazer.
     */
    public Memento refazer() {
        if (!estadosRefazer.isEmpty()) {
            Memento estado = estadosRefazer.pop(); // Remove do histórico de refazer
            estadosAnteriores.push(estado); // Salva novamente no histórico de desfazer
            return estado; // Retorna o estado que foi "refeito"
        }
        return null; // Se não houver mais estados para refazer
    }
}
