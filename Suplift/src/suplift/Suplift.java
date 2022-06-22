package suplift;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ghaid + Raneen
 */
public class Suplift extends Application {
    
    @Override
    public void start(Stage stage) throws IOException{
        try {
            // Load the FXML file.
            Parent parent = FXMLLoader.load(getClass().getResource("Suplift.fxml"));

            // Build the scene graph.
            Scene scene = new Scene(parent);
            
            stage.getIcons().add(new Image(Suplift.class.getResourceAsStream("nature.png")));
            
            // Display our window, using the scene graph.
            stage.setTitle("Outtera");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("FXML Loading Error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
