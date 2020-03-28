import java.util.Scanner;
public class Mängija {
      public static int näida_lauda(kaardidMängija, kaardidDiiler){
        for (int i = 0; i < kaardidMängija.lenght; i++) {
            System.out.print("|"+kaardidMängija[i]+"|   ")
        }
        Scanner s=new Scanner(System.in);
        System.out.println(" Kui vajutatud 1, võtta veel kaardi; kui 2, hoida: ");
        int valik=(int) valueof(s.nextLine());
        return valik;
    }
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
