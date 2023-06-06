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
import javafx.scene.control.Label;
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
public class Register implements Initializable {

    AdminParent admin1 = new Admin1();
    AdminParent admin2 = new Admin2();
    ObservableList data = observableArrayList();
    String admin1Username = admin1.getUsername();
    String admin2Username = admin2.getUsername();

    String admin1Password = admin1.getPassword();
    String admin2Password = admin2.getPassword();

    public void addDatabase(String Fullname, String Username, String PhoneNumber, String DateOfBirth, String EmailUser, String Password) {
        data.add(new DataUser(Fullname, Username, PhoneNumber, DateOfBirth, EmailUser, Password));
    }
    @FXML
    private TextField tfFullName;
    @FXML
    private Button bBackToLogin;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfDateOfBirth;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private Label lDateAlert;
    @FXML
    private Label lPasswordAlert;
    @FXML
    private TableView tvUtama;
    @FXML
    private TableColumn tvFullname;
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
        SimpanData sd = new SimpanData();
        data = sd.ambilDataStok("DataUser");
        tvFullname.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Fullname"));
        tvUsername.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Username"));
        tvPhoneNumber.setCellValueFactory(new PropertyValueFactory<DataUser, String>("PhoneNumber"));
        tvDateOfBirth.setCellValueFactory(new PropertyValueFactory<DataUser, String>("DateOfBirth"));     
        tvEmail.setCellValueFactory(new PropertyValueFactory<DataUser, String>("EmailUser"));
        tvPassword.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Password"));
        tvUtama.setItems(data);
    }

    @FXML
    private void handlebBackToLogin(ActionEvent event) {
        ArrayList<String> UsernameList = new ArrayList<String>();

        for (int i = 0; i < tvUtama.getItems().size(); i++) {
            UsernameList.add(tvUsername.getCellData(i).toString());
        }

        if (tfUsername.getText().isEmpty() || tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty() || tfPhoneNumber.getText().isEmpty()|| tfFullName.getText().isEmpty()|| tfDateOfBirth.getText().isEmpty()) {
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Mohon masukan semua data yang dibutuhkan!");
            art.show();
        } 
        else if (UsernameList.contains(tfUsername.getText())) {
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Username Sudah Ada!");
            art.show();
        } 
        else if (tfPassword.getText().length() != 8) {
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Password Harus 8 Karakter!");
            art.show();
        }else if (tfDateOfBirth.getText().length() != 8) {
            Alert art = new Alert(Alert.AlertType.ERROR);
            art.setHeaderText(null);
            art.setContentText("Masukan tanggal lahir dengan benar!");
            art.show();
        } else {
            addDatabase(tfFullName.getText(), tfUsername.getText(), tfPhoneNumber.getText(), tfDateOfBirth.getText(), tfEmail.getText(), tfPassword.getText());
            SimpanData sd = new SimpanData();
            sd.simpanDataStok(data, "DataUser");
            tfUsername.setText("");
            tfFullName.setText("");
            tfEmail.setText(""); 
            tfDateOfBirth.setText(""); 
            tfPassword.setText("");
            tfPhoneNumber.setText("");
            ModelHalaman h = new ModelHalaman();
            h.pindahAction(event, "/Login/vLogin.fxml");
        }

    }

    @FXML
    private void btnGalangDana(ActionEvent event) {
    }

    @FXML
    private void btnSetting(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vLogin.fxml");
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
