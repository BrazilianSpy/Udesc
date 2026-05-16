package dados.Enum;

public enum StatusSessao {
    DISPONIVEL("Disponível"),
    EM_EXIBICAO("Em exibição"),
    ESGOTADA("Esgotada"),
    CANCELADA("Cancelada");

    private String status;
    private StatusSessao(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
