package dados.Classes;

import java.util.HashMap;
import java.util.Map;

import dados.Enum.TipoSala;

public class Sala {

    private int numero;
    private int capacidadeTotal;
    private int capacidade = 0;
    private TipoSala tipo;
    private Map<Character,Map<Integer,Poltrona>> poltronas;
    
    public Sala() {
        poltronas = new HashMap<Character, Map<Integer,Poltrona>>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public Map<Character, Map<Integer, Poltrona>> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(Map<Character, Map<Integer, Poltrona>> poltronas) {
        if (poltronas.size() == 0) return;
        int soma = 0;
        for (Map<Integer,Poltrona> fileiras : poltronas.values()) {
            soma += fileiras.size();
        }
        if (soma > capacidadeTotal) return;
        setCapacidade(soma);
        this.poltronas = poltronas;
    }

    public void adicionarPoltrona(Poltrona poltrona) {
        char i = poltrona.getFileira();
        int j = poltrona.getColuna();
        if (poltronas.containsKey(i)) { // Procura se a fileira existe
            if (poltronas.get(i).containsKey(j)) { // Procura se a coluna existe
                poltronas.get(i).put(j, poltrona); // Coloca a poltrona na coluna da fileira
            } else if (capacidade < capacidadeTotal) { // Verifica a capacidade
                poltronas.get(i).put(j, poltrona); // Coloca a nova poltrona
            }
        // Não existe nenhum map para fileira
        } else if (capacidade < capacidadeTotal) { // Verifica a capacidade
            poltronas.put(i, new HashMap<Integer,Poltrona>()); // Adiciona uma fileira
            poltronas.get(i).put(j, poltrona); // Coloca a nova poltrona
        }
        
    }
}
