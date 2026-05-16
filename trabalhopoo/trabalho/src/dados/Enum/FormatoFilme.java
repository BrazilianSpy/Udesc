package dados.Enum;

public enum FormatoFilme {
    DOIS_D("2D"),
    TRES_D("3D");

    private String formato;
    private FormatoFilme(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }
}
