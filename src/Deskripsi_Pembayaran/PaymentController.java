/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Deskripsi_Pembayaran;

import Login.DataUser;
import Login.dataParse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import homepagedonasia.DataGalangDana;
import homepagedonasia.SimpanData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PaymentController implements Initializable {

    ObservableList data = observableArrayList();
    SimpanData sd = new SimpanData();
    dataParse ss = new dataParse();
    DataGalangDana dg;
    private int counter;
    @FXML
    private Button donasi;
    @FXML
    private TableView tvUtama;
    @FXML
    private TableColumn tvnama;
    @FXML
    private TableColumn tvdonasi;
    @FXML
    private TableColumn tvwaktu;
    @FXML
    private TableColumn tvpembayaran;
    @FXML
    private TableColumn tvjumlah;

    void addData(String nama, String jenisDonasi, String tanggal, String metode, String jumlah) {
        data.add(new Payment(nama, jenisDonasi, tanggal, metode, jumlah));
    }

    @FXML
    private TextField knama;
    @FXML
    private TextField jumlahUang;
    @FXML
    ChoiceBox jenisDonasi;
    @FXML
    private ChoiceBox jenisBayar;
    @FXML
    private DatePicker ktanggal;
    @FXML
    private Label catatan1;
    @FXML
    private Button kembali;
    @FXML
    private Label catatan2;
    @FXML
    private Label catatan3;
    @FXML
    private Label catatan4;
    @FXML
    private Label catatan5;

    @FXML
    private void kembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "/homepagedonasia/vHomePage2.fxml");

    }

    @FXML
    private void Donasi(ActionEvent event) throws IOException {

        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "vKonfirmasi.fxml");

    }

    @FXML
    public void simpanButton(ActionEvent event) {
        String nama = knama.getText().toString();
        String donasi = jenisDonasi.getValue().toString();
        String waktu = ktanggal.getValue().toString();
        String pembayaran = jenisBayar.getValue().toString();
        String jumlah = jumlahUang.getText();
        if (nama.isEmpty() || donasi.isEmpty() || waktu.isEmpty() || pembayaran.isEmpty() || jumlahUang.getText().isEmpty()) {
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Mohon masukan semua data yang dibutuhkan!");
            art.show();
        } else {
            addData(nama, donasi, waktu, pembayaran, jumlah);
            sd.simpanDataStok(data, "HistoriDonasi");
            knama.setText("");
            ktanggal.setValue(LocalDate.now());
            jumlahUang.setText("");

            Alert art = new Alert(Alert.AlertType.INFORMATION);
            art.setHeaderText(null);
            art.setTitle("PEMBERITAHUAN");
            art.setContentText("Donasi Berhasil!");
            art.show();

            dataParse.dataparse = counter;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jenisDonasi.getItems().addAll("Bencana Alam", "Penyakit", "Zakat");
        jenisBayar.getItems().addAll("DANA", "OVO", "QRIS", "GOPAY");
        data = sd.ambilDataStok("HistoriDonasi");
        tvnama.setCellValueFactory(new PropertyValueFactory<Payment, String>("nama"));
        tvdonasi.setCellValueFactory(new PropertyValueFactory<Payment, String>("jenisDonasi"));
        tvjumlah.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("jumlah"));
        tvwaktu.setCellValueFactory(new PropertyValueFactory<Payment, String>("tanggal"));
        tvpembayaran.setCellValueFactory(new PropertyValueFactory<Payment, String>("metode"));
        
        tvUtama.setItems(data);
    }

}
