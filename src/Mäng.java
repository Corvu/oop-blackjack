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
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidMängija.add(Kaardipakk.võta_kaardi(kaardipakk));
                    case 2:
                        break;
                }
            }

            // Nüüd diiler teeb oma otsused
            while(true) {
                int otsus = diiler.otsustada(kaardidDiiler);
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidDiiler.add(Kaardipakk.võta_kaardi(kaardipakk));
                    case 2:
                        break;
                }
            }

            // Võrrelda kaartide summat
            int summaMängija = 0;
            int summaDiiler = 0;
            boolean ületanudÄssMängija = false;
            boolean ületanudÄssDiiler = false;
            // Mängija summa
            for (String kaart : kaardidMängija) {
                summaMängija += parseKaardi(kaart, ületanudÄssMängija);
            }
            // Kui summa on üle 21, proovida arvutada jälle, kasutades ässi 1-punktiga
            if (summaMängija > 21) {
                summaMängija = 0;
                ületanudÄssMängija = true;
                for (String kaart : kaardidMängija) {
                    summaMängija += parseKaardi(kaart, ületanudÄssMängija);
                }
            }
            // Diileri summa
            for (String kaart : kaardidDiiler) {
                summaDiiler += parseKaardi(kaart, ületanudÄssDiiler);
            }
            if (summaDiiler > 21) {
                summaDiiler = 0;
                ületanudÄssDiiler = true;
                for (String kaart : kaardidDiiler) {
                    summaDiiler += parseKaardi(kaart, ületanudÄssDiiler);
                }
            }

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
