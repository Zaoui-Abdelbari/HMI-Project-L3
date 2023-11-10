/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author pc
 */
public class printMessage {
    
    private Alert print;
    
    public void errorMessage(String message){
        print = new Alert(AlertType.ERROR);
        print.setTitle("Error Message");
        print.setHeaderText(null);
        print.setContentText(message);
        print.showAndWait();
        
    }
    
    public void successMessage(String message){
        print = new Alert(AlertType.INFORMATION);
        print.setTitle("Information Message");
        print.setHeaderText(null);
        print.setContentText(message);
        print.showAndWait();
    }
}
