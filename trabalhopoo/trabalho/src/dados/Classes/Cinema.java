package dados.Classes;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    
    private int codigo;
    private int numeroSalas;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Sala> salas;
    
    public Cinema() {
        salas = new ArrayList<Sala>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroSalas() {
        return numeroSalas;
    }
    
    public void setNumeroSalas(int numeroSalas) {
        this.numeroSalas = numeroSalas;
    }

    public void criarSalas() {
        for (int i = 0; i < numeroSalas; i++) {
            salas.add(new Sala());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereço() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        if (salas.size() != numeroSalas) return;
        this.salas = salas;
    }

    public boolean adicionarSala(Sala sala) {
        if (salas.size() == numeroSalas) {
            return false;
        }
        salas.add(sala);
        return true;
    }

    public String toString() {
        String retorno = "Cinema " + nome + ", codigo: " + codigo + ", salas disponíveis: ";
        for (i = 0; i < salas.size(); i++) {
            retorno += "";
        }
        return retorno;
    }

}
