package dados.Classes;

import java.util.HashMap;
import java.util.Map;

public class Combo extends Alimento {
    
    private Map<Alimento, Integer> combo;

    public Combo() {
        combo = new HashMap<Alimento, Integer>();
    }

    public Map<Alimento, Integer> getCombo() {
        return combo;
    }

    public void setCombo(Map<Alimento, Integer> combo) {
        this.combo = combo;
    }

    public void adicionarAlimento(Alimento alimento, int quantidade) {
        if (quantidade <= 0) { // Remover alimento
            if (combo.containsKey(alimento)) {
                if (combo.get(alimento) < quantidade || quantidade == 0) {
                    combo.remove(alimento);
                    return;
                }
                combo.put(alimento, combo.get(alimento) - quantidade);
            }
            return;
        } // Adicionar alimento
        if (combo.containsKey(alimento)) {
            combo.put(alimento, quantidade + combo.get(alimento));
            return;
        }
        combo.put(alimento, quantidade);
    }
}
