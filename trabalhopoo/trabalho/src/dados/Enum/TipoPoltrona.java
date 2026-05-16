package dados.Enum;

public enum TipoPoltrona {
    NORMAL("Normal"),
    VIP("VIP"),
    ADAPTADA("Adaptada");

    private String tipo;
    private TipoPoltrona(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}