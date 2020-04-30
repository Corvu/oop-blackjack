
public class Main {

    public static void main(String[] args) {

        // Luuda uuse kasutajaliidese (siin on käsureane)
        KasutajaLiides kasutajaLiides = new Mängija();

        // Alustada lõpmatut tsüklit, kust iga kord võimalik kas uut mängu alustada või programmist väljuda
        while(true) {

            // Näida peamenüü la lugeda valutatud nuppu
            int otsus = kasutajaLiides.näidaPeamenüü();

            // Kui mängija vajutas 1, alustada uut mängu; kui 0, väljuda programmist
            switch(otsus) {
                case 1:
                    Mäng mäng = new Mäng(kasutajaLiides);
                    mäng.alustadaMängu();
                    break;
                case 0:
                    return;
            }

        }
    }
}
