/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Deskripsi_Pembayaran;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class KonfirmasiController implements Initializable {

    @FXML
    private void histori(ActionEvent event) throws IOException {
        ModelHalaman h = new ModelHalaman ();
        h.pindahHalaman(event, "/accountsetting/Histori.fxml");
    }
    @FXML
    private void kembali(ActionEvent event){
        ModelHalaman h = new ModelHalaman ();
        h.pindahHalaman(event, "/homepagedonasia/vHomePage2.fxml");
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
