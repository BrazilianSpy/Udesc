package dados.Enum;

public enum CanalVenda {
    PRESENCIAL("Presencial"),
    ONLINE("On-Line");

    private String canal;
    private CanalVenda(String canal) {
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }
}
