import java.util.ArrayList;
import java.util.Random;

public class Kaardipakk {

    ArrayList<String> kaardipakk;

    // Konstruktor, objekti loomisel genereertakse uus segatud kaardipakk
    public Kaardipakk() {
        String[] kaardipakkInit = {"2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠", "2♣", "3♣", "4♣", "5♣", "6♣",
                "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
                "A♥", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦"};
        kaardipakk = new ArrayList<>();
        for (String kaart : kaardipakkInit) {
            kaardipakk.add(kaart);
        }
        System.out.println(kaardipakk.size());
        Random rnd = new Random();
        for (int i = 0; i < kaardipakk.size(); i++) {
            int index = rnd.nextInt(i + 1);
            String a = kaardipakk.get(index);
            kaardipakk.set(index, kaardipakk.get(i));
            kaardipakk.set(i, a);
        }
    }

    public String võta_kaardi() {
        return kaardipakk.remove(0);
    }

    //genereerib uut segatud kaardipakki
    /*public ArrayList<String> genereerida_uue() {
        String[] kaardipakkInit = {"2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠", "2♣", "3♣", "4♣", "5♣", "6♣",
                "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
                "A♥", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦"};
        kaardipakk = new ArrayList<>();
        for (String kaart : kaardipakkInit) {
            kaardipakk.add(kaart);
        }
        System.out.println(kaardipakk.size());
        Random rnd = new Random();
        for (int i = 0; i < kaardipakk.size(); i++) {
            int index = rnd.nextInt(i + 1);
            String a = kaardipakk.get(index);
            kaardipakk.set(index, kaardipakk.get(i));
            kaardipakk.set(i, a);
        }
        return kaardipakk;
    }
     */

    //võtab ülemist kaarti kaardipakkist ja eemaldab kaardipakkist ülemist kaarti
    /*public String võta_kaardi() {
        String ülemine_kaart=kaardipakk[0];
        String[] eemaldatud_kaardiga=removeElement(kaardipakk);
        kaardipakk=eemaldatud_kaardiga;
        return ülemine_kaart;

    }*/

    //eemaldab esimest elementi massiivist
    /*public String[] removeElement(String[] kaardipakk){
        String[] eemaldatud_kaardiga=new String[kaardipakk.length-1];
        for (int i = 1; i < kaardipakk.length; i++) {
            eemaldatud_kaardiga[i-1]=kaardipakk[i];
        }
        kaardipakk=eemaldatud_kaardiga;
        return kaardipakk;
    }*/
}
