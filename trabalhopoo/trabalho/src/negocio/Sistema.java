package negocio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dados.Cinema;
import dados.Distribuidora;
import dados.Sala;
import dados.Filme;
import dados.Poltrona.TipoPoltrona;
import dados.Filme.Classificacao;

public class Sistema {

    private Scanner leitor = new Scanner(System.in);
    private List<Cinema> cinemas;
    private List<Filme> filmes;
    private List<Distribuidora> distribuidoras;

    public Sistema() {
        cinemas = new ArrayList<Cinema>();
        filmes = new ArrayList<Filme>();
        distribuidoras = new ArrayList<Distribuidora>();
    }
    
    public void cadastrarCinema() {
        Cinema novoCinema = new Cinema();
        novoCinema.setCodigo(cinemas.size()+1);
        System.out.println("Digite o nome do Cinema");
        novoCinema.setNome(leitor.nextLine());
        System.out.println("Digite o nome do Cinema");
        novoCinema.setNumeroSalas(Integer.parseInt(leitor.nextLine()));
        System.out.println("Digite o nome do Cinema");
        novoCinema.setTelefone(leitor.nextLine());
        System.out.println("Digite o endereço do Cinema");
        novoCinema.setEndereco(leitor.nextLine());
    }

    public void cadastrarPoltrona() {
        if (cinemas.size() == 0) return;
        System.out.println("Cinemas disponíveis:");
        int selecionado;
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println("Cinema " + i + ": " + cinemas.get(i));
        }
        System.out.println("Digite o indice do Cinema desejado");
        selecionado = Integer.parseInt(leitor.nextLine());
        Cinema cinema = cinemas.get(selecionado);
        for (int i = 0; i < cinema.getSalas().size(); i++) {
            System.out.println("Sala " + i + ": " + cinema.getSalas().get(i));
        }
        System.out.println("Digite o indice da Sala desejada");
        selecionado = Integer.parseInt(leitor.nextLine());

    }

    public void cadastrarFilme() {
        Filme filme = new Filme();

        System.out.println("Digite o titulo original do filme");
        filme.setTituloOriginal(leitor.nextLine());

        System.out.println("Digite o titulo em português do filme");
        filme.setTituloPortugues(leitor.nextLine());

        System.out.println("Digite o diretor do filme");
        filme.setDiretor(leitor.nextLine());

        System.out.println("Digite o país do filme");
        filme.setPais(leitor.nextLine());

        System.out.println("Digite a sinopse do filme");
        filme.setSinopse(leitor.nextLine());

        System.out.println("Digite o link do trailer do filme");
        filme.setTrailer(leitor.nextLine());

        System.out.println("Selecione a classificação do filme\n 1 - G\n2 - PG\n 3 - PG13\n4 - R\n5 -  NC17");
        boolean repetir = true;
        while (repetir) {
            int clas = Integer.parseInt(leitor.nextLine());
            if (clas > 0 && clas <= 5) {
                repetir = false;
                switch (clas) {
                    case 1:
                        filme.setClassificacao(Classificacao.G);
                        break;

                    case 2:
                        filme.setClassificacao(Classificacao.PG);
                        break;

                    case 3:
                        filme.setClassificacao(Classificacao.PG13);
                        break;
                    
                    case 4:
                        filme.setClassificacao(Classificacao.R);
                        break;

                    case 5:
                        filme.setClassificacao(Classificacao.NC17);
                        break;
                }
            } else {
                System.out.println("Classificação não existe");
            }
        }

        filme.setDistribuidora(selecionarDistribuidora());

        System.out.println("Digite o ano de lançamento do filme");
        filme.setAno(Integer.parseInt(leitor.nextLine()));

        System.out.println("Digite a duração em minutos do filme");
        filme.setDuracao(Integer.parseInt(leitor.nextLine()));

        repetir = true;
        while (repetir) {
            System.out.println("Digite o genero do filme, use \"sair\" para parar");
            String genero = leitor.nextLine();
            if (genero.toLowerCase() == "sair" && filme.getGeneros().size() > 0) {
                repetir = false;

            } else if (filme.adicionarGenero(genero)) {
                System.out.println("Genero adicionado");
            } else {
                System.out.println("O filme já possui esse genero");
            }
        }
        filmes.add(filme);
    }

    public Distribuidora selecionarDistribuidora() {
        boolean repetir = true;
        int selecionado = 0;
        while (repetir) {
            System.out.println("Distribuidoras:");
            for (int i = 0; i < distribuidoras.size(); i++) {
                System.out.println(i + " - " + distribuidoras.get(i));
            }
            System.out.println("Digite o indice da distribuidora, use -1 para criar uma nova");
            selecionado = Integer.parseInt(leitor.nextLine());
            if (selecionado >= 0 && selecionado < distribuidoras.size()) {
                repetir = false;

            } else if (selecionado == -1) {
                selecionado = distribuidoras.size();
                cadastrarDistribuidora();
                repetir = false;
            }
        }        
        return distribuidoras.get(selecionado);
    }

    public void cadastrarDistribuidora() {
        Distribuidora distribuidora = new Distribuidora();
        System.out.println("Digite o nome da distribuidora");
        distribuidora.setNome(leitor.nextLine());
        System.out.println("Digite o cnpj da distribuidora");
        distribuidora.setCnpj(leitor.nextLine());
        System.out.println("Digite o telefone da distribuidora");
        distribuidora.setTelefone(leitor.nextLine());
        distribuidoras.add(distribuidora);
    }

    public int menu() {
        System.out.println("Sistema de Cinemas");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Criar Sessão");
        System.out.println("4 - Comprar ingresso");
        System.out.println("0 - Sair");
        return Integer.parseInt(leitor.nextLine());
    }

    public int cadastro() {
        System.out.println("Sistema de cadastro");
        System.out.println("1 - Filme");
        System.out.println("2 - Cinema");
        System.out.println("3 - Poltrona");
        System.out.println("0 - Voltar");
        return Integer.parseInt(leitor.nextLine());
    }

    public int alterar() {
        System.out.println("Sistema de alteração");
        System.out.println("1 - Filme");
        System.out.println("2 - Cinema");
        System.out.println("3 - Sala");
        System.out.println("0 - voltar");
        return Integer.parseInt(leitor.nextLine());
    }

    public void run() {
        boolean rodando = true;
        while (rodando) {
            boolean interno = true;
            int acao = menu();
            switch (acao) {
                case 1: // Cadastrar
                    while (interno) {
                        acao = cadastro();
                        switch (acao) {
                            case 1:
                                cadastrarCinema();
                                break;
                            
                            case 2:
                                cadastrarFilme();
                                break;

                            case 3:
                                cadastrarPoltrona();
                                break;

                            case 0:
                                interno = false;
                                break;
                            
                            default:
                                System.out.println("Input incorreto");
                                break;
                        }
                    }
                    break;

                case 2: // alterar
                    while (interno) {
                        acao = alterar();
                        switch (acao) {
                            case 1:

                                break;
                            
                            case 2:

                                break;

                            case 3:

                                break;
                            
                            case 0:

                                break;

                            default:
                                System.out.println("Input desconhecido");
                                break;
                        }
                    }
            
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.run();
    }
}
