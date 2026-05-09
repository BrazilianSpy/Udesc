package dados;

public class Poltrona {
    private char fileira;
    private int coluna;
    private TipoPoltrona tipo;

    public enum TipoPoltrona {
        NORMAL,
        VIP,
        ADAPTADA
    }

    public char getFileira() {
        return fileira;
    }

    public void setFileira(char fileira) {
        this.fileira = fileira;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public TipoPoltrona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPoltrona tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Poltrona " + tipo + ", posição: " + fileira + coluna;
    }
}
