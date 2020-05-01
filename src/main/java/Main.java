import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage peaLava) throws Exception {

        // Luuda uuse kasutajaliidese (käsureane või graafiline)
        KasutajaLiides kasutajaLiides = new Mängija(peaLava);
        kasutajaLiides.show();

        // Alustada lõpmatut tsüklit, kust iga kord võimalik kas uut mängu alustada või programmist väljuda
        while(true) {

            // Näida peamenüü la lugeda valutatud nuppu
            int otsus = kasutajaLiides.näidaPeamenüü();

            // Kui mängija vajutas 1, alustada uut mängu; kui 0, väljuda programmist
            switch(otsus) {
                case 1:
                    Mäng mäng = new Mäng(kasutajaLiides);
                    mäng.alustadaMängu();
                    break;
                case 0:
                    kasutajaLiides.close();
                    return;
            }

        }

    }

    public static void main(String[] args) {

        // Käivitada JavaFX application-i
        launch(args);

    }
}
