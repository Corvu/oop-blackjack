
public class Main {

    public static void main(String[] args) {

        // Alustada lõpmatut tsüklit, kust iga kord võimalik kas uut mängu alustada või programmist väljuda
        while(true) {

            // Näida peamenüü la lugeda valutatud nuppu
            int otsus = Mängija.näida_peamenüü();

            // Kui mängija vajutas 1, alustada uut mängu; kui 0, väljuda programmist
            switch(otsus) {
                case 1:
                    Mäng mäng = new Mäng();
                    mäng.alustadaMängu();
                    break;
                case 0:
                    return;
            }

        }
    }
}
