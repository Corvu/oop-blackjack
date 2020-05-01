import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

// Kasutaja liidese käsurea implementatsioon
public class Mängija implements KasutajaLiides {

    Stage stage;

    public Mängija(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {
        // Käsureas liidese valmistamiseks midagi teha ei ole vaja
    }

    @Override
    public void close() {
        stage.show();
        stage.close();
    }

    // Näitab mängija käes olevad kaardiid ja küsib otsust
    @Override
    public int näidaLauda(ArrayList<String> kaardidMängija, ArrayList<String> kaardidDiiler) {
        for (int i = 0; i < kaardidMängija.size(); i++) {
            System.out.print("|"+kaardidMängija.get(i)+"|   ");
        }
        Scanner s = new Scanner(System.in);
        System.out.println("\nSisesta 1, et võtta veel kaardi; sisesta 2, et hoida; loobumise soovil sisesta 0: ");
        int valik = s.nextInt();
        return valik;
    }

    // Väljastab mängija ja diileri punktid ning teatab, kes on võitja
    @Override
    public void näidaTulemus(int võit, int summaMängija, int summaDiiler) {
        System.out.println("Sinu tulemus: " + summaMängija);
        System.out.println("Diileri tulemus: " + summaDiiler);
        if (võit > 0) {
            System.out.println("Õnnitlen, oled võitja!");
        }
        else if (võit < 0) {
            System.out.println("Diiler võitis, järgmine kord vedab. :)");
        }
        else {
            System.out.println("Mäng jäi viiki.");
        }
    }

    // Tervitab mängijat ja pakkub alustada mängu
    @Override
    public int näidaPeamenüü() {
        System.out.println("Tere tulemast, mängusse blackjack!");
        System.out.println("Mängi arvutiga ja proovi oma õnne.");
        Scanner s = new Scanner(System.in);
        System.out.println("Kui soovid alustada mängu sisesta 1, vastasel juhul 0:");
        int sisestatud = s.nextInt();
        return sisestatud;
    }

}
