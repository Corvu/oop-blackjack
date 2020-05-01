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

    public String võtaKaardi() {
        return kaardipakk.remove(0);
    }

}
