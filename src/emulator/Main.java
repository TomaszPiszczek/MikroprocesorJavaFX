package emulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Logger logger = Logger.getLogger("src/emulator/Main.java");

        if(System.getProperty("java.util.logging.config.class") ==null
                && System.getProperty("java.util.logging.config.file") ==null)
        {
            try
            {
                Logger.getLogger("").setLevel(Level.FINE);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("LOG_FILE",0,LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler);
            }
            catch (IOException e)
            {
                logger.log(Level.SEVERE,"NIE MOZNA UTROWRYC PLIKU DZIENNIKA",e);
            }}





        Parent root = FXMLLoader.load(getClass().getResource("view/Scene1.fxml"));
        primaryStage.setTitle("Intel 8086");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}
