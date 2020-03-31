
import java.util.ArrayList;

public class Mäng {

    private String[] kaardipakk;
    private Diiler diiler;
    private ArrayList<String> kaardidMängija;
    private ArrayList<String> kaardidDiiler;

    // Mängu klassi konstruktor;
    public Mäng() {
        this.kaardipakk = Kaardipakk.genereerida_uue();
        this.diiler = new Diiler();
    }

    // Arvutada punkti summat käes
    // TODO veenduda, et ässi korral summa arvutatakse korrektselt
    public static int arvutadaPunkte(ArrayList<String> kaardid) {
        int summa = 0;
        boolean ületanudÄss = false;
        // Esimene proov - eeldame, et summma ei ületa 21
        for (String kaart : kaardid) {
            summa += parseKaardi(kaart, ületanudÄss);
        }
        // Kui summa on üle 21, proovida arvutada jälle, kasutades ässi 1-punktiga
        if (summa > 21) {
            summa = 0;
            ületanudÄss = true;
            for (String kaart : kaardid) {
                summa += parseKaardi(kaart, ületanudÄss);
            }
        }
        return summa;
    }

    // Parseerida kaardi väärtuse;
    // ületanudÄss on lipp, mis märkab, kas äss annab 1 või 11 punkti
    public static int parseKaardi(String kaart, boolean ületanudÄss) {
        // Võetakse kaardi tähe ilma mastita
        String täht = kaart.substring(0, 1);
        int väärtus = -1;
        if (täht == "J" || täht == "Q" || täht == "K") {
            väärtus = 10;
        }
        else if (täht == "A" && !ületanudÄss) {
            väärtus = 11;
        }
        else if (täht == "A" && ületanudÄss) {
            väärtus = 1;
        }
        else {
            väärtus = Integer.parseInt(täht);
        }
        return väärtus;
    }

    // Alustada mängu; mäng lõpetab mängija soovil
    void alustadaMängu() {
        while(true) {

            // Iga tsükkel on üks partii
            kaardidDiiler = new ArrayList<>();
            kaardidMängija = new ArrayList<>();
            kaardidDiiler.add(Kaardipakk.võta_kaardi(kaardipakk));
            kaardidDiiler.add(Kaardipakk.võta_kaardi(kaardipakk));
            kaardidMängija.add(Kaardipakk.võta_kaardi(kaardipakk));
            kaardidMängija.add(Kaardipakk.võta_kaardi(kaardipakk));

            // Nüüd mängukontroll läheb mängija kätte
            while(true) {
                int otsus = Mängija.näidaLauda(kaardidMängija, kaardidDiiler);
                boolean hoida = false;
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidMängija.add(Kaardipakk.võta_kaardi(kaardipakk));
                    case 2:
                        hoida = true;
                }
                if (hoida)
                    break;
            }

            // Nüüd diiler teeb oma otsused
            while(true) {
                int otsus = Diiler.otsustada(kaardidDiiler);
                boolean hoida = false;
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidDiiler.add(Kaardipakk.võta_kaardi(kaardipakk));
                    case 2:
                        hoida = true;
                }
                if (hoida)
                    break;
            }

            // Võrrelda kaartide summat
            int summaMängija = 0;
            int summaDiiler = 0;
            boolean ületanudÄssMängija = false;
            boolean ületanudÄssDiiler = false;
            summaMängija = arvutadaPunkte(kaardidMängija);
            summaDiiler = arvutadaPunkte(kaardidDiiler);

            // Võrrelda punktid
            int võit = 0;
            if (summaMängija > 21 && summaDiiler > 21)
                võit = 0;
            else if (summaMängija > 21 && summaDiiler <= 21)
                võit = -1;
            else if (summaDiiler > 21 && summaMängija <= 21)
                võit = 1;
            else {
                if (summaMängija > summaDiiler)
                    võit = 1;
                else if (summaDiiler > summaMängija)
                    võit = -1;
                else
                    võit = 0;
            }

            // Näida ekraanile partii tulemust - punktisummaid ja kes võitis
            Mängija.näida_tulemus(võit, summaMängija, summaDiiler);

        }
    }

}
