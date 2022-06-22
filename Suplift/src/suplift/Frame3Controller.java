
package suplift;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ghaid + Raneen
 */
public class Frame3Controller implements Initializable {

   
    @FXML
    private ComboBox<String> Actvities;


    @FXML
    private Button ClearB;

    @FXML
    private DatePicker Date;

    @FXML
    private TextField Email;

    @FXML
    private RadioButton FEMALE;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton MALE;

    @FXML
    private TextField Name;

    @FXML
    private TextField Phone;
    
    @FXML
    private ToggleGroup Time;
    
    @FXML
    private RadioButton am9;

    @FXML
    private RadioButton pm8;
    
    @FXML
    private Button SubmitB;

    @FXML
    private Spinner<Integer> Ticket;

    @FXML
    private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Actvities.getItems().addAll(
                "Hiking",
                "Scubadiving",
                "Skydiving",
                "Camping"
        );
	SpinnerValueFactory<Integer> valueFactory = 
               new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
        Ticket.setValueFactory(valueFactory);
    }    

    @FXML
    private void ClearBAction(ActionEvent event) {
        Name.setText("");
        Email.setText("");
        Phone.setText("");
        Gender.selectToggle(null);
        Actvities.getSelectionModel().select(null);
        Ticket.getValueFactory().setValue(1);
        Date.setValue(null);
    }

    @FXML
    private void SubmitBAction(ActionEvent event) throws Exception {
        String gen;
        String time;
        //Step 1: input validation
        inputValidation();

        //Step2: send the data to the third window
        try {
            //hide the current window
           ((Node)event.getSource()).getScene().getWindow().hide();
          
           //load third window
           FXMLLoader loader = new FXMLLoader(getClass().getResource("lastFrame.fxml"));
           Parent root = loader.load();
           
           //create obkect of the third window controller
           LastFrameController controller3 = loader.getController();
           
           if(MALE.isSelected())
               gen = "Male";
           else
               gen = "Female";
           
           if (am9.isSelected())
               time = "09:00";
           else
               time = "20:00";
           
           controller3.setUserData(Name.getText(), Email.getText(),
                   Phone.getText(), gen, Actvities.getValue(),time,
                   Ticket.getValue(),Date.getValue());
   
           //show the third window
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.show();
   
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    private void inputValidation() throws Exception {

        //First: check that all fields are valid
        if (!validateName()) {
            //only letters
            JOptionPane.showMessageDialog(null, "Invalid Name !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
            
        }
        
        if (!validateEmail()) {

            JOptionPane.showMessageDialog(null, "Invalid Email !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!validateMobile()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid Mobile number !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!MALE.isSelected() && !FEMALE.isSelected()) {
            JOptionPane.showMessageDialog(null, "Select the gender!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!am9.isSelected() && !pm8.isSelected()) {
            JOptionPane.showMessageDialog(null, "Select the time!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (Actvities.getValue() == null || Actvities.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Select major!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (Date.getValue() == null || Date.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick Date!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
    }
    
    private boolean validateName() {

        return Name.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    private boolean validateEmail() {

        return Email.getText().matches("^(.+)@(.+)$");
    }

    private boolean validateMobile() {

        return Phone.getText().matches("(05)[0-9]{8}");

    }

}


