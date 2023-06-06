/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Deskripsi_Pembayaran;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ZakatController implements Initializable {

    @FXML
    private void btnDonasi(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "Payment.fxml");

    }

    @FXML
    private void btnKembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "HomePage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
