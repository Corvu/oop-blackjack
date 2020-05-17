import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public KasutajaLiides kasutajaLiides;
    public Mäng mäng;

    @Override
    public void start(Stage peaLava) throws Exception {
        // Luuda uuse kasutajaliidese (käsureane või graafiline)
        kasutajaLiides = new MängijaGraafiline(peaLava, mäng);
        kasutajaLiides.show();
    }

    public static void main(String[] args) {
        // Käivitada JavaFX application-i
        launch(args);
    }
}
