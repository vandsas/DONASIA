/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Deskripsi_Pembayaran;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Asus
 */
public class DonasiAlamController implements Initializable {

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
