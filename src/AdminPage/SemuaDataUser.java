/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AdminPage;

import Login.DataUser;
import homepagedonasia.SimpanData;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author bagas
 */
public class SemuaDataUser implements Initializable {
    ObservableList data = observableArrayList();

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
        SimpanData sd = new SimpanData();
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

    @FXML
    private void btnHapus(ActionEvent event) {
        for (int i = 0; i < tvUtama.getItems().size(); i++) {
            if (tvUtama.getSelectionModel().isSelected(i)) {
                    int selectedID = tvUtama.getSelectionModel().getSelectedIndex();
                    tvUtama.getItems().remove(selectedID);
                    SimpanData sd = new SimpanData();
            sd.simpanDataStok(data, "DataUser");
            }
        }
    }
    
}
