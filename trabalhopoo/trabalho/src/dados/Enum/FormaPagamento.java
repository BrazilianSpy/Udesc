package dados.Enum;

public enum FormaPagamento {
    CREDITO("Crédito"),
    DEBITO("Débito"),
    PIX("PIX"),
    DINHEIRO("Dinheiro");

    private String forma;
    private FormaPagamento(String forma) {
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }
}
