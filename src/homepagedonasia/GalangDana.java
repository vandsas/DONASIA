package homepagedonasia;
import Login.DataUser;
import Login.dataParse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GalangDana implements Initializable {
    ObservableList data = observableArrayList();
    SimpanData sd = new SimpanData();
    dataParse ss = new dataParse();
    DataGalangDana dg;
    private int counter;
    
    void addData(String judul, String tujuan, String penggalang, String waktu, String cerita){
        data.set(0,new DataGalangDana(judul, tujuan, penggalang, waktu, cerita));
    }

    @FXML
    private TextField tfJudul;
    
    @FXML
    private TextField tfTujuan;
    
    @FXML
    private TextField tfPenggalang;
    
    @FXML
    private TextField tfWaktu;
    
    @FXML
    private TextField tfKategori;
    
    @FXML
    private TextArea tfCerita;
    @FXML
    private TableView tvUtama;
    @FXML
    private TableColumn tvJudul;
    @FXML
    private TableColumn tvTujuan;
    @FXML
    private TableColumn tvWaktu;
    @FXML
    private TableColumn tvPenggalang;
    @FXML
    private TableColumn tvCerita;
    
    @FXML
    private void btnBerhasil(ActionEvent event) {
        if(tfJudul.getText().isEmpty() ||tfTujuan.getText().isEmpty() ||tfPenggalang.getText().isEmpty() ||tfWaktu.getText().isEmpty() ||tfCerita.getText().isEmpty()){
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Mohon masukan semua data yang dibutuhkan!");
            art.show();
        }else{
            addData(tfJudul.getText(),tfTujuan.getText(),tfPenggalang.getText(),tfWaktu.getText(),tfCerita.getText());
            sd.simpanDataStok(data, "DataDana");
            tfJudul.setText("");
            tfTujuan.setText("");
            tfPenggalang.setText("");
            tfWaktu.setText("");
            tfCerita.setText("");
            
            Alert art = new Alert(Alert.AlertType.INFORMATION);
            art.setHeaderText(null);
            art.setTitle("PEMBERITAHUAN");
            art.setContentText("Galang Dana Berhasil!");
            art.show();
            
             dataParse.dataparse = counter;
            ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vTampilanGalangDana.fxml");
        }
       
    }

    
    
    @FXML
    private void btnKembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHomePage2.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = sd.ambilDataStok("DataDana");
        tvJudul.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Judul"));
        tvTujuan.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Tujuan"));
        tvWaktu.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Waktu"));
        tvPenggalang.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Penggalang"));
        tvCerita.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Cerita"));
        tvUtama.setItems(data);
    }    
    
}
