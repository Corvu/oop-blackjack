import javafx.event.ActionEvent;
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
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MängijaGraafiline implements KasutajaLiides {

    Stage stage;

    private Mäng mäng;
    private FileWriter logWriter;

    public MängijaGraafiline(Stage stage, Mäng mäng) {

        this.stage = stage;
        this.mäng = new Mäng();

        try {
            this.logWriter = new FileWriter("log.txt", StandardCharsets.UTF_8);
            logWriter.write(LocalDateTime.now() + " Logfail loodud\n");
        } catch (IOException e) {
            throw new RuntimeException("Ei saanud logfaili luua.");
        }

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                try {
                    logWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Ei saanud logfaili sulgeda.");
                }
            }
        });
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
        Text text = new Text();
        String kaardid = "";
        for (int i = 0; i < kaardidMängija.size(); i++) {
            kaardid += "|" + kaardidMängija.get(i) + "|   ";
        }
        text.setText(kaardid);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        BorderPane root = new BorderPane();
        Scene peamenüü = new Scene(root,600,334);
        stage.setScene(peamenüü);
        root.setCenter(text);

        Button nupp1 = new Button("Võtta veel kaart.");
        root.setLeft(nupp1);
        nupp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mäng.annaKaardiMängijale();
                näidaLauda(mäng.getKaardidMängija(), mäng.getKaardidDiiler());
            }
        });

        Button nupp2 = new Button("Jätta seis.");
        root.setRight(nupp2);
        nupp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mäng.diileriOsa();
                int tulemus = mäng.arvutadaTulemus();
                int summaMängija = mäng.arvutadaPunkte(mäng.getKaardidMängija());
                int summaDiiler = mäng.arvutadaPunkte(mäng.getKaardidDiiler());

                näidaTulemus(tulemus, summaMängija, summaDiiler);
            }
        });

    }

    @Override
    public void näidaTulemus(int võit, int summaMängija, int summaDiiler) {

        Text textKaardidPunktid = new Text();
        textKaardidPunktid.setText("Sinu kaardid: " + mäng.getKaardidMängija() + "\n" +
                "Diileri kaardid: " + mäng.getKaardidDiiler() + "\n\n" +
                "Sinu tulemus: "+ summaMängija+"\n Diileri Tulemus: "+summaDiiler);
        textKaardidPunktid.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Text textTulemus = new Text();
        textTulemus.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        if (võit > 0) {
            textTulemus.setText("Õnnitlen, oled võitja!");
        } else if (võit < 0) {
            textTulemus.setText("Diiler võitis, järgmine kord vedab. :)");
        } else {
            textTulemus.setText("Mäng jäi viiki.");
        }

        Button buttonJärgminePartii = new Button();
        buttonJärgminePartii.setText("Alusta uut partii");

        BorderPane root = new BorderPane();
        Scene peamenüü = new Scene(root,600,334);
        stage.setScene(peamenüü);
        root.setCenter(textKaardidPunktid);
        root.setBottom(textTulemus);
        root.setLeft(buttonJärgminePartii);
        buttonJärgminePartii.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mäng.alustaUutPartii();
                näidaLauda(mäng.getKaardidMängija(), mäng.getKaardidDiiler());
            }
        });

        try {
            logWriter.write(LocalDateTime.now() + " Mängija tulemus: " + võit + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ei saanud logfaili kirjutada");
        }
    }

    @Override
    public void näidaPeamenüü() {
        Text text = new Text();
        text.setText("          Tere tulemast, mängusse blackjack!\n" +
                     "          Mängi arvutiga ja proovi oma õnne.\n " +
                     "Kui soovid alustada mängu, siis vajuta 'Start' nuppu.");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setY(130);
        text.setX(90);

        BorderPane root = new BorderPane();

        Scene peamenüü = new Scene(root,600,335);  // luuakse stseen
        stage.setScene(peamenüü);
        root.setCenter(text);

        Button nupp1 = new Button("Start"); // luuakse nupp
        nupp1.setPrefWidth(75);
        root.setBottom(nupp1);
        nupp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mäng.alustaUutPartii();
                näidaLauda(mäng.getKaardidMängija(), mäng.getKaardidDiiler());
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
