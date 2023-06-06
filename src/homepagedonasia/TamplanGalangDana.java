package homepagedonasia;

import Login.DataUser;
import Login.dataParse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TamplanGalangDana implements Initializable { 
    ObservableList data = observableArrayList();
    SimpanData sd = new SimpanData();
    dataParse ss = new dataParse();
    DataGalangDana dg;
    
    @FXML
    private TableColumn tfJudul;
    @FXML
    private TableColumn tfTujuan;
    @FXML
    private TableColumn tfWaktu;
    @FXML
    private TableColumn tfPenggalang;
    @FXML
    private TableColumn tfCerita;
    @FXML
    private TableView tvUtama;
    @FXML
    private Label lblJudul;
    @FXML
    private Label lblPenggalang;
    @FXML
    private Label lblTujuan;
    @FXML
    private Label lblCerita;
    @FXML
    private Label lblWaktu;

    @FXML
    private void btnKembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHalamanGalangDana.fxml");
    }
    
    @FXML
    private void btnGalangDana(ActionEvent event) {
        lblJudul.setText("");
        lblPenggalang.setText("");
        lblTujuan.setText("");
        lblCerita.setText("");
        lblWaktu.setText("");
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vGalangDanaBerhasil.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = sd.ambilDataStok("DataDana");
        tfJudul.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Judul"));
        tfTujuan.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Tujuan"));
        tfWaktu.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Waktu"));
        tfPenggalang.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Penggalang"));
        tfCerita.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Cerita"));
        tvUtama.setItems(data);
        
        lblJudul.setText(tfJudul.getCellData(ss.getData()).toString());
        lblPenggalang.setText(tfPenggalang.getCellData(ss.getData()).toString());
        lblTujuan.setText(tfTujuan.getCellData(ss.getData()).toString());
        lblCerita.setText(tfCerita.getCellData(ss.getData()).toString());
        lblWaktu.setText(tfWaktu.getCellData(ss.getData()).toString());

    }

    
    
}
