/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homepagedonasia;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ModelHalaman {
    
    public void pindahAction(ActionEvent event, String tujuan){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        
        try{
            root = FXMLLoader.load(getClass().getResource(tujuan));
            stage.setScene(new Scene(root));
            stage.show();
            
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void pindahMouse(MouseEvent event, String tujuan){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        
        try{
            root = FXMLLoader.load(getClass().getResource(tujuan));
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        }
        catch(IOException e){
            System.out.println(e);
        }  
    }
}
