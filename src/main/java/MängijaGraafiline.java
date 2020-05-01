import javafx.stage.Stage;

import java.util.ArrayList;

public class MängijaGraafiline implements KasutajaLiides{

    Stage stage;

    public MängijaGraafiline(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {
        stage.show();
    }

    @Override
    public void close() {
        stage.close();
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
         Text text=new Text();
        text.setText("          Tere tulemast, mängusse blackjack!\n" +
                     "          Mängi arvutiga ja proovi oma õnne.\n " +
                     "Kui soovid alustada mängu, siis vajuta 'Start' nuppu.");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setY(130);
        text.setX(90);


        BorderPane root=new BorderPane();

        Scene peamenüü = new Scene(root,600,335);  // luuakse stseen

        root.setCenter(text);



        final int[] i = new int[1];

        Button nupp1 = new Button("Start"); // luuakse nupp
        nupp1.setPrefWidth(75);
        root.setBottom(nupp1);
        nupp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                i[0] = 1;
            }
        });

        Button nupp2=new Button("Loobu");
        nupp2.setPrefWidth(75);
        root.setRight(nupp2);

        nupp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                i[0]=0;
            }
        });
        return i[0];
    }
}
