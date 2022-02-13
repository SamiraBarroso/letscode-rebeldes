package controller;

import domain.Quicksort;
import domain.Rebelde;
import enums.Ordem;
import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Random;

public class InteligenciaCentral {
    private LinkedList<Rebelde> rebeldes = new LinkedList<>();

    public boolean solicitarIngressoRebelde(){
        int num = new Random().nextInt(5);
        return num % 2 == 0;
    }
    public void cadastrarRebelde(Rebelde rebelde){
        this.rebeldes.add(rebelde);
    }
    public void gerarRelatorio() throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter("rebeldes.txt", "UTF-8");
        writer.println("LISTA DE REBELDES:");
        writer.println("");
        int count = 0;
        for (Rebelde rebelde : this.rebeldes) {
            writer.println(count + " - " + rebelde.toString());
            count++;
        }
    }

    public void ordenaLista(Ordem ordem){
        Quicksort quick = new Quicksort();
        quick.ordenar(this.rebeldes, this.rebeldes.indexOf(rebeldes.peekFirst()), this.rebeldes.indexOf(rebeldes.peekLast()), ordem);
    }

    public void imprimirListaRebeldes() {
        for (Rebelde rebelde : rebeldes){
            System.out.println(" - " + rebelde.toString());
        }
    }
}
