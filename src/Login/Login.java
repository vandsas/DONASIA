/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Login;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author bagas
 */
public class Login implements Initializable {
    AdminParent admin1 = new Admin1();
    AdminParent admin2 = new Admin2();
    ObservableList data = observableArrayList();
    String admin1Username = admin1.getUsername();
    String admin2Username = admin2.getUsername();

    String admin1Password = admin1.getPassword();
    String admin2Password = admin2.getPassword();
    dataParse dp = new dataParse();
    private int counter;
    @FXML
    private Button button;
    @FXML
    private Label label11;
    @FXML
    private Button bSignUp;
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
    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        String Username = tfUsername.getText();
        String Password = tfPassword.getText();
        
        ArrayList<String> UsernameList = new ArrayList<String>();
        ArrayList<String> PasswordList = new ArrayList<String>();
        
        boolean cond1 = false, cond2 = false;

        for (int i = 0; i < tvUtama.getItems().size(); i++) {
            UsernameList.add(tvUsername.getCellData(i).toString());
            PasswordList.add(tvPassword.getCellData(i).toString());
        }
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        
        for (counter = 0; counter < tvUtama.getItems().size(); counter++) {
            dataParse.dataparse = counter;
            if (UsernameList.get(counter).equals(Username) && PasswordList.get(counter).equals(Password)) {         
                h.pindahAction(event, "/homepagedonasia/vHomePage2.fxml");  
                break;
                
            } else if (Username.isEmpty() || Password.isEmpty()){
                Alert art = new Alert(Alert.AlertType.ERROR);
                art.setHeaderText(null);
                art.setContentText("Mohon masukan semua data!");
                art.show();
                break;
                
            } else if (Username.equals(admin1Username) && Password.equals(admin1Password)){
                h.pindahAction(event, "/AdminPage/vAdminMainPage.fxml"); 
                break;
                
            } else if (Username.equals(admin2Username) && Password.equals(admin2Password)){
                h.pindahAction(event, "/AdminPage/vAdminMainPage.fxml"); 
                break;
                
            }
            else if (!UsernameList.contains(Username) || !PasswordList.contains(Password)) {
                Alert art = new Alert(Alert.AlertType.ERROR);
                art.setHeaderText(null);
                art.setContentText("Username atau Password salah!");
                art.show();
                break;
            }
            else if (!UsernameList.contains(Username) && !PasswordList.contains(Password)) {
                Alert art = new Alert(Alert.AlertType.ERROR);
                art.setHeaderText(null);
                art.setContentText("Akun belum terdaftar!");
                art.show();
                break;
            }
            if (UsernameList.get(dp.getData()).equals(Username) && !PasswordList.get(dp.getData()).equals(Password)){
                cond1 = true;
            } else {
                cond2 = true;
            }
            if(cond1 == true && cond2 == true){
                Alert art = new Alert(Alert.AlertType.ERROR);
                art.setHeaderText(null);
                art.setContentText("Username atau password salah!");
                art.show();
                break;
            }
            
        }
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            SimpanData sd = new SimpanData();
        data = sd.ambilDataStok("DataUser");
        tvFullName.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Fullname"));
        tvUsername.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Username"));
        tvDateOfBirth.setCellValueFactory(new PropertyValueFactory<DataUser, String>("DateOfBirth"));
        tvEmail.setCellValueFactory(new PropertyValueFactory<DataUser, String>("EmailUser"));
        tvPassword.setCellValueFactory(new PropertyValueFactory<DataUser, String>("Password"));
        tvPhoneNumber.setCellValueFactory(new PropertyValueFactory<DataUser, String>("PhoneNumber"));
        tvUtama.setItems(data);
        }catch(Exception e){
            System.out.println("Database akun belum ada!");
        } 
    }    

    private void handlebResetPassword(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vResetPassword.fxml");
    }

    @FXML
    private void handlebSignUp(ActionEvent event) {
        homepagedonasia.ModelHalaman h = new homepagedonasia.ModelHalaman();
        h.pindahAction(event, "/Login/vRegister.fxml");
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
