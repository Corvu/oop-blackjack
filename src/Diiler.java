

import java.util.ArrayList;

public class Diiler {

    // Diileri otsustuse reeglite implementeerimine
    public static int otsustada(ArrayList<String> kaardidDiiler) {

        // Arvutada summa käes
        int summaDiiler = Mäng.arvutadaPunkte(kaardidDiiler);

        // Otsus; see on lihtsaim strateeria - kui vähem 16-st, võta kaardi, kui ei, hoida
        if (summaDiiler < 16)
            return 1;
        else
            return 2;

    }

}
