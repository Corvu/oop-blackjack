
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mäng {
private Kaardipakk kaardipakk;
    private Diiler diiler;
    private ArrayList<String> kaardidMängija;
    private ArrayList<String> kaardidDiiler;
    private KasutajaLiides kasutajaLiides;

    // Mängu klassi konstruktor; luues täpsustatakse kasutajaliides
    public Mäng(KasutajaLiides kasutajaLiides) {
        this.kaardipakk = new Kaardipakk();
        this.diiler = new Diiler();
        this.kasutajaLiides = kasutajaLiides;
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
        if (täht.equals("J") || täht.equals("Q") || täht.equals("K")) {
            väärtus = 10;
        }
        else if (täht.equals("A") && !ületanudÄss) {
            väärtus = 11;
        }
        else if (täht.equals("A") && ületanudÄss) {
            väärtus = 1;
        }
        else {
            väärtus = Integer.parseInt(täht);
        }
        return väärtus;
    }

    // Alustada mängu; mäng lõpetab mängija soovil
    int i=0;
    void alustadaMängu() throws IOException {
        FileWriter writer = new FileWriter("log.txt");
        while(true) {
            i++;
            // Iga tsükkel on üks partii
            kaardidDiiler = new ArrayList<>();
            kaardidMängija = new ArrayList<>();
            kaardidDiiler.add(kaardipakk.võtaKaardi());
            kaardidDiiler.add(kaardipakk.võtaKaardi());
            kaardidMängija.add(kaardipakk.võtaKaardi());
            kaardidMängija.add(kaardipakk.võtaKaardi());

            // Nüüd mängukontroll läheb mängija kätte
            while (true) {
                int otsus = kasutajaLiides.näidaLauda(kaardidMängija, kaardidDiiler);
                boolean hoida = false;
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 0:
                        return;
                    case 1:
                        kaardidMängija.add(kaardipakk.võtaKaardi());
                        break;
                    case 2:
                        hoida = true;
                        break;
                }
                if (hoida)
                    break;
            }

            // Nüüd diiler teeb oma otsused
            while (true) {
                int otsus = Diiler.otsustada(kaardidDiiler);
                boolean hoida = false;
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidDiiler.add(kaardipakk.võtaKaardi());
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
            else if (summaMängija > 21)
                võit = -1;
            else if (summaDiiler > 21)
                võit = 1;
            else
                võit = Integer.compare(summaMängija, summaDiiler);

            // Näida ekraanile partii tulemust - punktisummaid ja kes võitis
            kasutajaLiides.näidaTulemus(võit, summaMängija, summaDiiler);
            String mängijaKaardid="";
            String diileriKaardid="";

            for (int i = 0; i < kaardidMängija.size(); i++) {
                mängijaKaardid+="|"+kaardidMängija.get(i)+"|   ";
            }
            for (int i = 0; i < kaardidDiiler.size(); i++) {
                diileriKaardid+="|"+kaardidDiiler.get(i)+"|   ";
            }

            try ( writer) {
                String partii="Partii nr."+i+"\n";
                writer.write(partii);
                writer.write("Mängija kaardid: "+mängijaKaardid+"\n"+ "Mängija punktid:"+summaMängija+"\n");
                writer.write("Diileri kaardid: "+diileriKaardid+"\n"+"Diileri punktid: "+summaDiiler);
                writer.flush();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
   
}
