public class Mäng {

    private Kaardipakk kaardipakk;
    private Diiler diiler;
    private Kaart[] kaardidMängija;
    private Kaart[] kaardidDiiler;

    // Mängu klassi konstruktor;
    public Mäng() {
        this.kaardipakk = new Kaardipakk();
        this.diiler = new Diiler();
    }

    // Alustada mängu; mäng lõpetab mängija soovil
    void alustadaMängu() {
        while(true) {

            // Iga tsükkel on üks partii
            kaardidDiiler = kaardipakk.võtaKaart();
            kaardidDiiler = kaardipakk.võtaKaart();
            kaardidMängija = kaardipakk.võtaKaart();
            kaardidMängija = kaardipakk.võtaKaart();

            // Nüüd mängukontroll läheb mängija kätte
            while(true) {
                int otsus = Mängija.näidaLauda(kaardidMängija, kaardidDiiler);
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidMängija = kaardipakk.võtaKaart();
                    case 2:
                        break;
                }
            }

            // Nüüd diiler teeb oma otsused
            while(true) {
                int otsus = diiler.otsustada(kaardidDiiler);
                // Kui vajutatud 1, võtta veel kaardi; kui 2, hoida
                switch (otsus) {
                    case 1:
                        kaardidDiiler = kaardipakk.võtaKaart();
                    case 2:
                        break;
                }
            }

            // Võrrelda kaartide summat
            int summaMängija = 0;
            int summaDiiler = 0;
            for (Kaart kaart : kaardidMängija) {
                summaMängija += (int)kaart;
            }
            for (Kaart kaart : kaardidDiiler) {
                summaDiiler += (int)kaart;
            }
            if (summaMängija > summaDiiler)

        }
    }

}
