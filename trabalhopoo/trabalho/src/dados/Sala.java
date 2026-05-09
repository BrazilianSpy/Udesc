package dados;

import java.util.HashMap;
import java.util.Map;

public class Sala {
    private Map<Character,Map<Integer,Poltrona>> poltronas;
    
    public Sala() {
        poltronas = new HashMap<Character, Map<Integer,Poltrona>>();
    }

    public void adicionarAssento(Poltrona poltrona) {
        char i = poltrona.getFileira();
        int j = poltrona.getColuna();
        if (poltronas.containsKey(i)) { // Procura se a fileira existe
            poltronas.get(i).put(j, poltrona); // Coloca a poltrona na coluna da fileira
        
        } else { // Não existe nenhum map para fileira
            poltronas.put(i, new HashMap<Integer,Poltrona>()); // Adiciona uma fileira
            poltronas.get(i).put(j, poltrona); // Coloca a nova poltrona
        }
    }
}
