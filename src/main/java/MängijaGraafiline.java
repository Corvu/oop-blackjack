import javafx.stage.Stage;

import java.util.ArrayList;

public class MängijaGraafiline implements KasutajaLiides{

    Stage stage;

    public MängijaGraafiline(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void close() {

    }

    @Override
    public int näidaLauda(ArrayList<String> kaardidMängija, ArrayList<String> kaardidDiiler) {
        return 0;
    }

    @Override
    public void näidaTulemus(int võit, int summaMängija, int summaDiiler) {

    }

    @Override
    public int näidaPeamenüü() {
        return 0;
    }
}
