import java.util.ArrayList;

public interface KasutajaLiides {

    // Valmistada kasutajaliidese
    public void show();

    // Panna kasutajaliidese kinni
    public void close();

    // Näitab mängija käes olevad kaardiid ja küsib otsust
    public int näidaLauda(ArrayList<String> kaardidMängija, ArrayList<String> kaardidDiiler);

    // Väljastab mängija ja diileri punktid ning teatab, kes on võitja
    public void näidaTulemus(int võit, int summaMängija, int summaDiiler);

    // Tervitab mängijat ja pakkub alustada mängu
    public int näidaPeamenüü();

}
