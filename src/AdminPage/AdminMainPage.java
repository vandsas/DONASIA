/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AdminPage;

import Deskripsi_Pembayaran.Payment;
import homepagedonasia.SimpanData;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author bagas
 */
public class AdminMainPage implements Initializable {

    ObservableList datahistori = observableArrayList();
    SimpanData sd = new SimpanData();
    @FXML
    private TableView tvHistory;
    @FXML
    private TableColumn cNama;
    @FXML
    private TableColumn cTujuan;
    @FXML
    private TableColumn cNominal;
    @FXML
    private TableColumn cTanggal;
    @FXML
    private TableColumn cMetodePembayaran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        datahistori = sd.ambilDataStok("HistoriDonasi");
            cNama.setCellValueFactory(new PropertyValueFactory<Payment, String>("nama"));
            cTujuan.setCellValueFactory(new PropertyValueFactory<Payment, String>("jenisDonasi"));
            cTanggal.setCellValueFactory(new PropertyValueFactory<Payment, String>("tanggal"));
            cMetodePembayaran.setCellValueFactory(new PropertyValueFactory<Payment, String>("metode"));
            cNominal.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("jumlah"));
            tvHistory.setItems(datahistori);
    }    

    @FXML
    private void btnHome(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vHomePage.fxml");
    }

    @FXML
    private void btnDataUser(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/AdminPage/vSemuaDataUser.fxml");
    }

    @FXML
    private void btnTransaksi(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/AdminPage/vAdminMainPage.fxml");
    }
    
}
