/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package homepagedonasia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


/**
 *
 * @author Alvanditya
 */
public class HomePage implements Initializable {
    
    @FXML
    private AnchorPane pane2;
    
    @FXML
    private AnchorPane pane3;
    @FXML
    private AnchorPane pane1;
    
    @FXML
    private void btnAboutUs(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vaboutUs.fxml");
    }
    
    @FXML
    private void btnHome(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHomePage.fxml");
    }
    
    @FXML
    private void btnBencanaAlam(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vBencanaAlam.fxml");
    }
    
    @FXML
    private void btnMedis(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vHalamanMedis.fxml");
    }
    
    @FXML
    private void btnGalangDana(ActionEvent event) {
    }
    
    @FXML
    private void btnZakat(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vZakat.fxml");
    }
    
    void btnNext(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "vaboutUs.fxml");
    }
    
    public void animation(double duration, Node node,double width){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(duration),node);
        translate.setByX(width);
        translate.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animation(0.5,pane2,829);
        animation(0.5,pane3,829);
    }    
    
    int show = 0;
    @FXML
    void next(ActionEvent event){
        if(show == 0){
            animation(0.5,pane2,-829);
            show++;
        } 
        else if(show==1){
            animation(0.5,pane3,-829);
            show++;
        }
    }
    
    @FXML
    void back(ActionEvent event){
        if(show == 1){
            animation(0.5,pane2,829);
            show--;
        } 
        else if(show==2){
            animation(0.5,pane3,829);
            show--;
        }
    }

    @FXML
    private void btnSetting(ActionEvent event) {
        ModelHalaman h = new ModelHalaman();
        h.pindahAction(event, "/Login/vLogin.fxml");
    }
    
}
