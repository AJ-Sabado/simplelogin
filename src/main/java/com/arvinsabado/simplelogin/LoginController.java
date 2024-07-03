/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arvinsabado.simplelogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Arvin
 */
public class LoginController {
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private JDBCConnect jDBCConnect = new JDBCConnect();
    private Connection connection = null;
    private Statement statement = null;
    
    public void createNewAccount(ActionEvent event) throws IOException{
        System.out.println("username: " + usernameField.getText() + " password: " + passwordField.getText());
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void login(ActionEvent event) throws IOException {

        if (usernameField.getText().isBlank() || passwordField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("username or password is blank!");
            alert.show();
            return;
        }
        
        connection = jDBCConnect.getConnection();
        
        String query = "select * from users WHERE username = " + usernameField.getText() + ";";
        
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
