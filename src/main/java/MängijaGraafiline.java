import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MängijaGraafiline implements KasutajaLiides{

    Stage stage;

    public MängijaGraafiline(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {
        stage.show();
        näidaPeamenüü();
    }

    @Override
    public void close() {
        stage.close();
    }

    @Override
    public void näidaLauda(ArrayList<String> kaardidMängija, ArrayList<String> kaardidDiiler) {
        Text text=new Text();
        String kaardid="";
        for (int i = 0; i < kaardidMängija.size(); i++) {
            kaardid+="|"+kaardidMängija.get(i)+"|   ";
        }
        text.setText(kaardid);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setText("Vajuta 1, et võtta veel kaardi; vajuta 2, et hoida; loobumise soovil vajuta 0:");

    }

    @Override
    public void näidaTulemus(int võit, int summaMängija, int summaDiiler) {
        Text text=new Text();
        Text text2=new Text();
        text.setText("Sinu tulemus: "+ summaMängija+"\n Diileri Tulemus: "+summaDiiler);
        if (võit > 0) {
            text2.setText("Õnnitlen, oled võitja!");
        }
        else if (võit < 0) {
            text2.setText("Diiler võitis, järgmine kord vedab. :)");
        }
        else {
            text2.setText("Mäng jäi viiki.");
        }
        BorderPane root=new BorderPane();
        Scene peamenüü=new Scene(root,600,334);
        stage.setScene(peamenüü);
        root.setCenter(text);
        root.setBottom(text2);
    }

    @Override
    public void näidaPeamenüü() {
         Text text=new Text();
        text.setText("          Tere tulemast, mängusse blackjack!\n" +
                     "          Mängi arvutiga ja proovi oma õnne.\n " +
                     "Kui soovid alustada mängu, siis vajuta 'Start' nuppu.");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setY(130);
        text.setX(90);


        BorderPane root=new BorderPane();

        Scene peamenüü = new Scene(root,600,335);  // luuakse stseen
        stage.setScene(peamenüü);
        root.setCenter(text);

        Button nupp1 = new Button("Start"); // luuakse nupp
        nupp1.setPrefWidth(75);
        root.setBottom(nupp1);
        nupp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                Mäng mäng = new Mäng();
                try {
                    mäng.alustadaMängu();
                } catch (IOException ex) {
                    // TODO
                }
            }
        });

        Button nupp2=new Button("Loobu");
        nupp2.setPrefWidth(75);
        root.setRight(nupp2);

        nupp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                close();
            }
        });
    }
}
