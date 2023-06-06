package Deskripsi_Pembayaran;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TabelDataController implements Initializable {

    @FXML
    private TableView<Payment> TablePayment;

    @FXML
    private TableColumn<Payment, String> nama;

    @FXML
    private TableColumn<Payment, String> jenisDonasi;

    @FXML
    private TableColumn<Payment, String> metode;

    @FXML
    private TableColumn<Payment, String> tanggal;

    @FXML
    private TableColumn<Payment, String> jumlah;

    ArrayList<Payment> listPay = new ArrayList<Payment>();

    ObservableList dataBayar = observableArrayList();
    XStream xstream = new XStream(new StaxDriver());

    @FXML
    public void kembali(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahHalaman(event, "vHomePage.fxml");
        
    }

    void OpenData() {

        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("ListPayment.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }

            listPay = (ArrayList<Payment>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }

    void simpanData() {
        String xml = xstream.toXML(listPay);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListPayment.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        jenisDonasi.setCellValueFactory(new PropertyValueFactory<>("jenisDonasi"));
        tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        metode.setCellValueFactory(new PropertyValueFactory<>("metode"));
        jumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        
        OpenData();
        simpanData();
        File f = new File("ListPayment.xml");
        if (f.exists() && !f.isDirectory()) {
            OpenData();
            for (int i = 0; i < listPay.size(); i++) {
                dataBayar.add(listPay.get(i));
            }
        }
        for (int i = 0; i < listPay.size(); i++) {
            System.out.println(listPay.toString());
        }
        TablePayment.setItems(dataBayar);
    }

}
