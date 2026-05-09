package dados;
import java.util.ArrayList;
import java.util.List;


public class Filme {
    
    public enum Classificacao {
        G,
        PG,
        PG13,
        R,
        NC17
    }
    
    private String tituloOriginal;
    private String tituloPortugues;
    private String diretor;
    private String pais;
    private String sinopse;
    private String trailer; // Link
    private Classificacao classificacao;
    private Distribuidora distribuidora;
    private int ano;
    private int duracao; // Em minutos
    private List<String> generos;

    public Filme() {
        generos = new ArrayList<String>();
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloPortugues() {
        return tituloPortugues;
    }

    public void setTituloPortugues(String tituloPortugues) {
        this.tituloPortugues = tituloPortugues;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public boolean adicionarGenero(String genero) {
        if (generos.contains(genero)) return false;
        
        generos.add(genero);
        return true;
    }

    public boolean removerGenero(String genero) {
        if (generos.contains(genero)) {
            generos.remove(generos.indexOf(genero));
            return true;
        }
        return false;
    }

}
