
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mäng {

    private Kaardipakk kaardipakk;
    private ArrayList<String> kaardidMängija;
    private ArrayList<String> kaardidDiiler;
    private Diiler diiler;

    public Mäng() {
        this.kaardipakk = new Kaardipakk();
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
    //int i=0;
    void alustadaMängu() throws IOException {

        /*
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
        }*/
    }

    public void diileriOsa() {
        boolean hoida = false;
        while (!hoida) {
            int otsus = Diiler.otsustada(kaardidDiiler);
            // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
            switch (otsus) {
                case 1:
                    kaardidDiiler.add(kaardipakk.võtaKaardi());
                    break;
                case 2:
                    hoida = true;
                    break;
                default:
                    throw new RuntimeException("Ootamatu otsusekood (diiler)");
            }
        }
    }

    public int arvutadaTulemus() {
        // Võrrelda kaartide summat
        int tulemus = 0;
        int summaMängija = 0;
        int summaDiiler = 0;
        boolean ületanudÄssMängija = false;
        boolean ületanudÄssDiiler = false;
        summaMängija = Mäng.arvutadaPunkte(kaardidMängija);
        summaDiiler = Mäng.arvutadaPunkte(kaardidDiiler);

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

        return tulemus;

    }

    public void alustaUutPartii() {
        // Anna mängijatele kaardid
        kaardidDiiler = new ArrayList<>();
        kaardidMängija = new ArrayList<>();
        kaardidDiiler.add(kaardipakk.võtaKaardi());
        kaardidDiiler.add(kaardipakk.võtaKaardi());
        kaardidMängija.add(kaardipakk.võtaKaardi());
        kaardidMängija.add(kaardipakk.võtaKaardi());
    }

    public void annaKaardiMängijale() {
        kaardidMängija.add(kaardipakk.võtaKaardi());
    }

    public ArrayList<String> getKaardidMängija() {
        return kaardidMängija;
    }

    public ArrayList<String> getKaardidDiiler() {
        return kaardidDiiler;
    }
}
