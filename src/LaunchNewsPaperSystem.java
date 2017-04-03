/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Rutul
 */
public class LaunchNewsPaperSystem extends Application {

    NewsPaper theStar, torontoSun, barrieExaminer, globeAndMail;

    @Override
    public void start(Stage primaryStage) throws IOException {

        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NewsPaperSystemView.fxml"));
            
            AnchorPane newsPaperPane = loader.load();
            Scene scene = new Scene(newsPaperPane);
            
            Button theStarBtn, torontoSunBtn, barrieExaminerBtn, globeAndMailBtn;
            
            primaryStage.setTitle("The NewsPaper Shop");
            primaryStage.setScene(scene);
            primaryStage.show();
        
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
