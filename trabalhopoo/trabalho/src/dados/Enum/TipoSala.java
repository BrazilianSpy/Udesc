package dados.Enum;

public enum TipoSala {
    DOIS_D("2D"),
    TRES_D("3D"),
    IMAX("IMAX"),
    VIP("VIP");

    private String tipo;
    private TipoSala(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}