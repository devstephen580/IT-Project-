package main.loginpagewithstephen;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Main_LoginPageController implements Initializable {

    @FXML
    private JFXButton cancel_btn;

    @FXML
    private PasswordField tf_password;
//
    @FXML
    private TextField tf_username;

    @FXML
    private JFXButton login_btn;
//
//    @FXML
//    private JFXRadioButton rb_new;
//
//    @FXML
//    private JFXRadioButton rb_return;
//
    @FXML
    private JFXButton signup_btn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cancel_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cancel_btn.getScene().getWindow().hide();
            }
        });


        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.loginUser(event, tf_username.getText(), tf_password.getText());
            }
        });

        //We assign changeScene to the Signup btn to call it up
        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "sign-up.fxml", "Sign up", null, null);
            }
        });

    }
}