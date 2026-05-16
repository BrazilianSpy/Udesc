package dados.Enum;

public enum Genero {
    ACAO("Ação"),
    COMEDIA("Comêdia"),
    DRAMA("Drama"),
    TERROR("Terror"),
    AVENTURA("Aventura"),
    DOCUMENTARIO("Documentário");

    private String genero;
    private Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
