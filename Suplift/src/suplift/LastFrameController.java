
package suplift;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghaid + Raneen
 */
public class LastFrameController implements Initializable  {

    @FXML
    private Button CancelB;
    @FXML
    private Button ConfirmB;
    @FXML
    private TextField Name;
    @FXML
    private TextField Date;
    @FXML
    private TextField Time;
    @FXML
    private TextField NumTick;

    private Cutomer s;
    @FXML
    private VBox vbox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ConfirmBAction(ActionEvent event) {
        writeToFile(s);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("frame2.fxml"));
            Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage2.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        } 
    }
    @FXML
    private void CancelBAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Frame3.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    public void setUserData (String Name, String Email ,String Phone,String Gender,
               String Activity,String time, int NumTicket, LocalDate Date){
        s = new Cutomer(Name, Email, Phone, Gender, Activity,time, NumTicket, Date);
        
        this.Name.setText(Name);
        NumTick.setText(""+NumTicket);
        this.Date.setText(""+Date);
        this.Time.setText(time);
        }
    
    private void writeToFile(Object o)  {
            // Create the stream objects.
           ObjectOutputStream objectOutputFile = null;
           FileOutputStream outStream = null;
           try {
                System.out.println(s);
               outStream = new FileOutputStream("Suplift.txt");
               objectOutputFile = new ObjectOutputStream(outStream);
               // Write the serialized objects to the file.
               objectOutputFile.writeObject(s);
               //show confirmation message
               JOptionPane.showMessageDialog(null, "Ticket has been booked successfully");
               objectOutputFile.close();

           } catch (FileNotFoundException ex) {
               System.out.println("Error wrting to file");
           } catch (IOException ex) {
               System.out.println("Error wrting to file");
           }   
    }
    
}
