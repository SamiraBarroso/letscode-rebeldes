package br.com.letscode;

import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteligenciaCentral {
    private List<Rebelde> rebeldes = new ArrayList<>();

    public boolean solicitarIngressoRebelde(){
        int num = new Random().nextInt(5);
        if (num % 2 == 0)
            return true;
        else
            return  false;
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
}
