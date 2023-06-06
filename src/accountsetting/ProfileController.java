/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package accountsetting;

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
import javafx.scene.input.MouseEvent;

/**
 *
 * @author apras
 */
public class ProfileController implements Initializable {
    ObservableList data = observableArrayList();
    SimpanData sd = new SimpanData();
    dataParse dp = new dataParse();
    DataUser du;
    
    @FXML
    private Label lNoTelp;
    @FXML
    private Label lBirthDay; 
    @FXML
    private Label lNama;
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private Button button11;
    @FXML
    private Label lemail;
    @FXML
    private Label lpassword;
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
    private Label lUsername;
    @FXML
    private Label ltUsername;
    @FXML
    private Label ltemail;
    
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
        // TODO
        data = sd.ambilDataStok("DataUser");
        tvFullname.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Fullname"));
        tvUsername.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Username"));
        tvPhoneNumber.setCellValueFactory(new PropertyValueFactory<DataUser, String>("PhoneNumber"));
        tvDateOfBirth.setCellValueFactory(new PropertyValueFactory<DataUser, String>("DateOfBirth"));     
        tvEmail.setCellValueFactory(new PropertyValueFactory<DataUser, String>("EmailUser"));
        tvPassword.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Password"));
        tvUtama.setItems(data);
        
        ltUsername.setText(tvUsername.getCellData(dp.getData()).toString());
        ltemail.setText(tvEmail.getCellData(dp.getData()).toString());
        lNama.setText(tvFullname.getCellData(dp.getData()).toString());
        lUsername.setText(tvUsername.getCellData(dp.getData()).toString());
        lNoTelp.setText(tvPhoneNumber.getCellData(dp.getData()).toString());
        lBirthDay.setText(tvDateOfBirth.getCellData(dp.getData()).toString());  
        lemail.setText(tvEmail.getCellData(dp.getData()).toString()); 
        lpassword.setText(tvPassword.getCellData(dp.getData()).toString()); 
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

    @FXML
    private void btnGantiPassword(ActionEvent event) {
                homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vResetPassword.fxml");
    }
    
}
