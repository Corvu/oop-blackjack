import java.util.Scanner;
public class Mängija {
      public static void näida_mängu(){

    }
    public static void näida_peamenüü(){
        System.out.println("Tere tulemast, mängusse blackjack!");
        System.out.println("Mängi arvutiga ja proovi oma õnne.");
        Scanner s= new Scanner(System.in);
        System.out.println("Kui soovid alustada mängu sisesta 'start':");
        String sisestatud=s.nextLine();
        if (sisestatud=="start"){
            näida_mängu();
        }
    }
}
