package dados.Classes;

import dados.Enum.FormatoFilme;
import dados.Enum.StatusSessao;

public class Sessao {

    private String data;
    private String idioma;
    private float valor;
    private Filme filme;
    private Sala sala;
    private StatusSessao status;
    private FormatoFilme formato;
    private Horario horarioInicio;
    private Horario horarioTermino;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public StatusSessao getStatus() {
        return status;
    }

    public void setStatus(StatusSessao status) {
        this.status = status;
    }

    public FormatoFilme getFormato() {
        return formato;
    }

    public void setFormato(FormatoFilme formato) {
        this.formato = formato;
    }

    public Horario getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Horario horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Horario getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(Horario horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public void calculaTermino(int minutos) {
        Horario novoHorario = new Horario();
        int tempo = horarioInicio.getMinuto() + minutos;
        novoHorario.setMinuto(tempo % 60);
        novoHorario.setHora(horarioInicio.getHora() + tempo/60);
        horarioTermino = novoHorario;
    }
}
