package dados.Enum;

public enum TurnoTrabalho {
    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    private String turno;
    private TurnoTrabalho(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }
}
