/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountsetting;

import Deskripsi_Pembayaran.Payment;
import Login.DataUser;
import Login.dataParse;
import homepagedonasia.SimpanData;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author apras
 */
public class HistoryController implements Initializable {

    ObservableList data = observableArrayList();
    ObservableList datahistori = observableArrayList();
    SimpanData sd = new SimpanData();
    dataParse dp = new dataParse();
    DataUser du;

    @FXML
    private TableView tvHistory;
    @FXML
    private Button button;
    @FXML
    private Label ltNama;
    @FXML
    private Label ltEmail;
    @FXML
    private Button button1;
    @FXML
    private Button button11;
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
    @FXML
    private TableView tvUtama;
    @FXML
    private TableColumn tvFullname;
    @FXML
    private TableColumn tvUsername;
    @FXML
    private TableColumn tvPhoneNumber;
    @FXML
    private TableColumn tvDateOfBirth;
    @FXML
    private TableColumn tvEmail;
    @FXML
    private TableColumn tvPassword;

    @FXML
    private void fbProfile(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "/accountsetting/Profile.fxml");
    }

    @FXML
    private void fbHistory(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "/accountsetting/History.fxml");
    }

    @FXML
    private void fbLogout(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vHomePage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        datahistori = sd.ambilDataStok("HistoriDonasi");
            cNama.setCellValueFactory(new PropertyValueFactory<Payment, String>("nama"));
            cTujuan.setCellValueFactory(new PropertyValueFactory<Payment, String>("jenisDonasi"));
            cTanggal.setCellValueFactory(new PropertyValueFactory<Payment, String>("tanggal"));
            cMetodePembayaran.setCellValueFactory(new PropertyValueFactory<Payment, String>("metode"));
            cNominal.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("jumlah"));
            tvHistory.setItems(datahistori);
        data = sd.ambilDataStok("DataUser");
        tvFullname.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Fullname"));
        tvUsername.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Username"));
        tvPhoneNumber.setCellValueFactory(new PropertyValueFactory<DataUser, String>("PhoneNumber"));
        tvDateOfBirth.setCellValueFactory(new PropertyValueFactory<DataUser, String>("DateOfBirth"));
        tvEmail.setCellValueFactory(new PropertyValueFactory<DataUser, String>("EmailUser"));
        tvPassword.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Password"));
        tvUtama.setItems(data);
        ltNama.setText(tvUsername.getCellData(dp.getData()).toString());
        ltEmail.setText(tvEmail.getCellData(dp.getData()).toString());
    }

    @FXML
    private void btnGalangDana(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vHalamanGalangDana.fxml");
    }

    @FXML
    private void btnSetting(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vLogin.fxml");
    }

    @FXML
    private void btnAboutUs(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vaboutUs2.fxml");
    }

    @FXML
    private void btnHome(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vHomePage2.fxml");
    }

}
