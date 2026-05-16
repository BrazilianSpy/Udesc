package dados.Enum;

public enum Cargo {
    BILHETERIA("Bilheteria"),
    BOMBONIERE("Bomboniere"),
    PROJECIONISTA("Projecionista"),
    GERENTE("Gerente");

    private String cargo;
    private Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}