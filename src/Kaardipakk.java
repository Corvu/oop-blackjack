
import java.util.Random;
public class Kaardipakk {
  //genereerib uut segatud kaardipakki
  public static String[] genereerida_uue() {
        String[] kaardipakk = {"2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠", "2♣", "3♣", "4♣", "5♣", "6♣",
                "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
                "A♥", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦"};
        System.out.println(kaardipakk.length);
        Random rnd = new Random();
        for (int i = 0; i < kaardipakk.length; i++) {
            int index = rnd.nextInt(i + 1);
            String a = kaardipakk[index];
            kaardipakk[index] = kaardipakk[i];
            kaardipakk[i] = a;
        }
        return kaardipakk;
    }
  //võtab ülemist kaarti kaardipakkist ja eemaldab kaardipakkist ülemist kaarti
  public static String võta_kaardi(String [] kaardipakk){
        String ülemine_kaart=kaardipakk[0];
        String[] eemaldatud_kaardiga=removeElement(kaardipakk);
        kaardipakk=eemaldatud_kaardiga;
        return ülemine_kaart;
    }
  //eemaldab esimest elementi massiivist
    public static String[] removeElement(String[] kaardipakk){
        String[] eemaldatud_kaardiga=new String[kaardipakk.length-1];
        for (int i = 1; i < kaardipakk.length; i++) {
            eemaldatud_kaardiga[i-1]=kaardipakk[i];
        }
        kaardipakk=eemaldatud_kaardiga;
        return kaardipakk;
    }
}
