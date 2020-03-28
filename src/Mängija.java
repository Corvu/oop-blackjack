import java.util.Scanner;
public class Mängija {
      public static int näidaLauda(String[] kaardidMängija,String[] kaardidDiiler){
        for (int i = 0; i < kaardidMängija.lenght; i++) {
            System.out.print("|"+kaardidMängija[i]+"|   ")
        }
        Scanner s=new Scanner(System.in);
        System.out.println(" Kui vajutatud 1, võtta veel kaardi; kui 2, hoida: ");
        int valik=s.nextInt();
        return valik;
    }
      public static void näida_tulemus(){

    }
   public static int näida_peamenüü(){
        System.out.println("Tere tulemast, mängusse blackjack!");
        System.out.println("Mängi arvutiga ja proovi oma õnne.");
        Scanner s= new Scanner(System.in);
        System.out.println("Kui soovid alustada mängu sisesta 1, vastasel juhul 0:");
        int sisestatud=s.nextInt());
        return sisestatud;
    }
    
}
