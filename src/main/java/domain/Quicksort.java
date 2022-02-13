package domain;

import enums.Ordem;
import enums.Raca;

import java.util.LinkedList;

public class Quicksort {

    public void ordenar(LinkedList<Rebelde> rebeldes, int inicio, int fim, Ordem ordem){
        if(inicio < fim){
            int pivo = particiona(rebeldes, inicio , fim, ordem);
            ordenar(rebeldes, inicio, pivo - 1, ordem);
            ordenar(rebeldes, pivo + 1, fim, ordem);
        }
    }

    private int particiona(LinkedList<Rebelde> rebeldes, int inicio, int fim, Ordem ordem) {
        int i = inicio - 1;

        if(ordem.equals(Ordem.NOME)){
            String pivo = rebeldes.get(fim).getNome();
            for(int j = inicio; j <= fim - 1; j++)
            {   if(rebeldes.get(j).getNome().compareTo(pivo) <= 0){
                    i++;
                    troca(rebeldes,i,j);
                }
            }
            troca(rebeldes,i+1,fim);
            return (i+1);
        }
        if(ordem.equals(Ordem.IDADE)){
            int pivo = rebeldes.get(fim).getIdade();
            for(int j = inicio; j <= fim - 1; j++){
                if(rebeldes.get(j).getIdade() <= pivo){
                    i++;
                    troca(rebeldes,i,j);
                }
            }
            troca(rebeldes,i+1,fim);
            return (i+1);
        }
        else{
            Raca pivo = rebeldes.get(fim).getRaca();
            for(int j = inicio; j <= fim - 1; j++){
                if(rebeldes.get(j).getRaca().compareTo(pivo) <= 0){
                    i++;
                    troca(rebeldes,i,j);
                }
            }
            troca(rebeldes,i+1,fim);
            return (i+1);
        }
    }

    private void troca(LinkedList<Rebelde> rebeldes, int i, int j) {
        Rebelde aux = rebeldes.get(i);
        rebeldes.set(i, rebeldes.get(j));
        rebeldes.set(j, aux);
    }
}
