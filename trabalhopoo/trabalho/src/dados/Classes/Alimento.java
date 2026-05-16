package dados.Classes;

import dados.Enum.CategoriaAlimento;
import dados.Enum.FormaPagamento;

public class Alimento {

    private int codigo;
    private int disponibilidade;
    private String descricao;
    private float valor;
    private CategoriaAlimento categoria;
    private FormaPagamento formaPagamento;
    private Funcionario bomboniere;
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getDisponibilidade() {
        return disponibilidade;
    }
    
    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public float getValor() {
        return valor;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public CategoriaAlimento getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriaAlimento categoria) {
        this.categoria = categoria;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Funcionario getBomboniere() {
        return bomboniere;
    }

    public void setBomboniere(Funcionario bomboniere) {
        this.bomboniere = bomboniere;
    }

    public String toString() {
        return "";
    }
}