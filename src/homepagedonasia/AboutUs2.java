package homepagedonasia;

import homepagedonasia.ModelHalaman;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AboutUs2 implements Initializable {
    
    private Label label;
    @FXML
    private Button bKembali;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnKembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHomePage2.fxml");
    }
    
}
