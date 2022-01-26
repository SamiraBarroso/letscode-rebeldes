package br.com.letscode;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RebeldeView {

    private InteligenciaCentral inteligenciaCentral = new InteligenciaCentral();
    private Rebelde rebelde;
    private Scanner scanner;

    public RebeldeView() {
        this.scanner = new Scanner(System.in);
    }

    private String perguntaNome(){
        System.out.println("Nome do Rebelde: ");
        String nome = scanner.nextLine();
        if (nome.isBlank()) {
            return perguntaNome();
        }
        return nome;
    }
    private int perguntaIdade(){
        System.out.println("Idade do Rebelde: ");
        int idade;
        try {
            idade  = scanner.nextInt();
            return idade;
        } catch (InputMismatchException exception) {
            System.out.println("Idade inválida!");
            return perguntaIdade();
        }
    }
    private Raca perguntaRaca(){
        System.out.println("Raça do Rebelde: ");
        for (Raca raca : Raca.values()) {
            System.out.printf("%d - %s\n", raca.ordinal(), raca.name());
        }
        int racaIndex = scanner.nextInt();
        if (racaIndex < 0 || racaIndex >= Raca.values().length) {
            System.out.println("Raça inválida!");
            return perguntaRaca();
        }
        else
            return Raca.values()[racaIndex];
    }

    private void dadosRebelde(){
        this.rebelde = Rebelde.builder()
                .nome(perguntaNome())
                .idade(perguntaIdade())
                .raca(perguntaRaca())
                .build();
    }

    private void geraRelatorio(){
        try {
            this.inteligenciaCentral.gerarRelatorio();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void solicitaIngresso(){
        boolean solicitacao = this.inteligenciaCentral.solicitarIngressoRebelde();
        if(solicitacao){
            System.out.println("Acesso Permitido! ");
            this.inteligenciaCentral.cadastrarRebelde(rebelde);
            geraRelatorio();
            System.out.println(rebelde.getNome() + " Cadastrado. ");
        }
        else {
            System.out.println("Acesso Negado.");
            System.out.println(rebelde.getNome() + " Recusado. ");
        }
    }
    public void showMenu(){
        System.out.println("----------- Cadastro de Rebeldes-----------");
        System.out.println();
        System.out.println("1 - Solicitar Ingresso na Aliança");
        System.out.println("0 - Sair");

        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":

                dadosRebelde();
                solicitaIngresso();
                scanner.nextLine();
                showMenu();
                break;
            case "0":
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println("Opção inválida. Escolha um opção válida");
                showMenu();
            }
    }
}
