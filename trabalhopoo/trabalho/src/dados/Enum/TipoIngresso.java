package dados.Enum;

public enum TipoIngresso {
    INTEIRA("Inteira"),
    MEIA("Meia"),
    PROMOCIONAL("Promocional");

    private String tipo;
    private TipoIngresso(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
