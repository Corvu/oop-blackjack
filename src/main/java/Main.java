import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static KasutajaLiides kasutajaLiides;

    @Override
    public void start(Stage peaLava) throws Exception {

        // Luuda uuse kasutajaliidese (käsureane või graafiline)
        kasutajaLiides = new MängijaGraafiline(peaLava);
        kasutajaLiides.show();

    }

    public static void main(String[] args) {

        // Käivitada JavaFX application-i
        launch(args);

    }
}
