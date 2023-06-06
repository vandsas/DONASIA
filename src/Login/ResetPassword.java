/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import homepagedonasia.ModelHalaman;
import homepagedonasia.SimpanData;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bagas
 */
public class ResetPassword implements Initializable {
SimpanData sd = new SimpanData();
    ObservableList data = observableArrayList();

    DataUser du;
    dataParse dp = new dataParse();
    @FXML
    private Button backToLogin;
    @FXML
    private TextField TFBirthday;
    @FXML
    private TextField TfnewPassword;
    @FXML
    private TableView tvUtama;
    @FXML
    private TableColumn tvFullName;
    @FXML
    private TableColumn tvUsername;
    @FXML
    private TableColumn tvDateOfBirth;
    @FXML
    private TableColumn tvEmail;
    @FXML
    private TableColumn tvPassword;
    @FXML
    private TableColumn tvPhoneNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = sd.ambilDataStok("DataUser");
        tvFullName.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Fullname"));
        tvUsername.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Username"));
        tvPhoneNumber.setCellValueFactory(new PropertyValueFactory<DataUser, String>("PhoneNumber"));
        tvDateOfBirth.setCellValueFactory(new PropertyValueFactory<DataUser, String>("DateOfBirth"));     
        tvEmail.setCellValueFactory(new PropertyValueFactory<DataUser, String>("EmailUser"));
        tvPassword.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Password"));
        tvUtama.setItems(data);
    }

    @FXML
    private void HandlebackTologin(ActionEvent event) {
        String fullname = tvFullName.getCellData(dp.getData()).toString();
        String username = tvUsername.getCellData(dp.getData()).toString();
        String phoneNumber = tvPhoneNumber.getCellData(dp.getData()).toString();
        String dateOfBirth = tvDateOfBirth.getCellData(dp.getData()).toString();
        String email = tvEmail.getCellData(dp.getData()).toString();
        ArrayList<String> passlist = new ArrayList<String>();
        for(int i = 0; i<tvUtama.getItems().size();i++){
        passlist.add(tvPhoneNumber.getCellData(i).toString());
    }
        if(TFBirthday.getText().equals(tvPhoneNumber.getCellData(dp.getData()).toString())){
            data = sd.ambilDataStok("DataUser");  
                    data.set(dp.getData(), new DataUser(fullname, username, phoneNumber, dateOfBirth, email,TfnewPassword.getText()));
                    tvUtama.setItems(data); 
                    sd.simpanDataStok(data, "DataUser");
                    homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vLogin.fxml");
        }else{
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Phone Number Salah!");
            art.show();
        }
    }

    @FXML
    private void btnGalangDana(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("tidak bisa galang dana!");
            art.show();
    }

    @FXML
    private void btnSetting(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("tidak bisa setting!");
            art.show();
    }

    @FXML
    private void btnAboutUs(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vaboutUs.fxml");
    }

    @FXML
    private void btnHome(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/homepagedonasia/vHomePage.fxml");
    }

}
