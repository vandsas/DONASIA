package homepagedonasia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Berhasil implements Initializable {
    
    private Label label;
    
    @FXML
    private void btnOk(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHomePage2.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
