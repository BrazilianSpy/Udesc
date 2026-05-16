package dados.Enum;

public enum CategoriaAlimento {
    SALGADO("Salgado"),
    DOCE("Doce"),
    BEBIDA("Bebida"),
    COMBO("Combo");

    private String categoria;
    private CategoriaAlimento(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}