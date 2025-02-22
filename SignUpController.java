package main.loginpagewithstephen;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private JFXButton signup_btn;

    @FXML JFXButton cancel_btn;

    @FXML
    private JFXButton login_btn;

    @FXML
    private JFXRadioButton rb_new;

//    @FXML
//    private ImageView username_image;
//
//    @FXML
//    private ImageView password_image;

    @FXML
    private JFXRadioButton rb_return;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rb_new.setToggleGroup(toggleGroup);
        rb_return.setToggleGroup(toggleGroup);

        //Would make the returning intern automatically selected on launching
        rb_return.setSelected(true);


        cancel_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cancel_btn.getScene().getWindow().hide();
            }
        });



        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();


                    //I used .trim() here so users are not allowed to use spaces in their username and passwords
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()) {

                    DataBaseUtils.signUpUser(event, tf_username.getText().trim(), tf_password.getText().trim(), toggleName);
                }else {
                    System.out.println("Abeg fill in ur information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Spaces are not allowed!");
                    alert.show();
//
                }
            }
        });

        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "loginPage.fxml", "Log in", null, null);
            }
        });

    }

}
