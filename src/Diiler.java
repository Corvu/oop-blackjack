import java.util.ArrayList;

public class Diiler {

    // Diileri otsustuse reeglite implementeerimine
    public int otsustada(ArrayList<String> kaardidDiiler) {

        // Arvutada summa käes
        int summaDiiler = 0;
        boolean ületanudÄssDiiler = false;
        for (String kaart : kaardidDiiler) {
            summaDiiler += Mäng.parseKaardi(kaart, ületanudÄssDiiler);
        }
        if (summaDiiler > 21) {
            summaDiiler = 0;
            ületanudÄssDiiler = true;
            for (String kaart : kaardidDiiler) {
                summaDiiler += Mäng.parseKaardi(kaart, ületanudÄssDiiler);
            }
        }

        // Otsus; see on lihtsaim strateeria - kui vähem 16-st, võta kaardi, kui ei, hoida
        if (summaDiiler < 16)
            return 1;
        else
            return 2;

    }

}
