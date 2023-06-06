package Deskripsi_Pembayaran;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DonasiPenyakitController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;

    @FXML
    private void btnDonasi(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "vPayment.fxml");

    }

    @FXML
    private void btnKembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "/homepagedonasia/vHomePage2.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
