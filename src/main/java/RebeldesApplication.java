import domain.Quicksort;
import domain.Rebelde;
import enums.Ordem;
import enums.Raca;
import view.RebeldeView;

import java.util.LinkedList;

public class RebeldesApplication {
    public static void main(String[] args) {
        RebeldeView rebeldeView = new RebeldeView();
        rebeldeView.showMenu();
    /*    Rebelde rebelde1 = Rebelde.builder().nome("Joana").idade(22).raca(Raca.GREE).build();
        Rebelde rebelde2 = Rebelde.builder().nome("Marcus").idade(18).raca(Raca.HUMANO).build();
        Rebelde rebelde3 = Rebelde.builder().nome("Pedro").idade(36).raca(Raca.RAKATA).build();
        Rebelde rebelde4 = Rebelde.builder().nome("Ana").idade(19).raca(Raca.HUMANO).build();

        LinkedList<Rebelde> rebeldes = new LinkedList<>();
        rebeldes.add(rebelde1);
        rebeldes.add(rebelde2);
        rebeldes.add(rebelde3);
        rebeldes.add(rebelde4);

        Quicksort quick = new Quicksort();
        quick.ordenar(rebeldes, rebeldes.indexOf(rebeldes.peekFirst()), rebeldes.indexOf(rebeldes.peekLast()), Ordem.IDADE);

        for (Rebelde rebelde : rebeldes){
            System.out.println(" - " + rebelde.toString());
        }
*/
    }
}
