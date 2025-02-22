package main.loginpagewithstephen;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    @FXML
    private Label label_welcome;

    @FXML
    private Label label_intern_status;

    @FXML
    private Button Login_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button takeExam_btn;

    @FXML
    private Label course_id;

    @FXML
    private JFXComboBox<String> courseComboBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseComboBox.getItems().addAll("Java Fundamentals", "Web Development");


        logout_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            DataBaseUtils.changeScene(event, "loginPage.fxml", "Log in", null, null);
            }
        });



 /*       takeExam_btn.setOnAction(event -> {
            if (courseComboBox.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Please select a course!");
                alert.show();
            } else {
                try {
                    // Load the exam FXML file
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamQuestionOne.fxml"));
                    Parent root = loader.load();

                    // Get the exam controller and pass the course name
                    QuestionOneController examController = loader.getController();
                    QuestionTwoController examController2 = loader.getController();
                    QuestionThreeController examController3 = loader.getController();
                    QuestionFourController examController4 = loader.getController();
                    QuestionFiveController examController5 = loader.getController();


                    examController.setCourseTitle(courseComboBox.getValue()); // Set the course
                    examController2.setCourseTitle(courseComboBox.getValue());
                    examController3.setCourseTitle(courseComboBox.getValue());
                    examController4.setCourseTitle(courseComboBox.getValue());
                    examController5.setCourseTitle(courseComboBox.getValue());


                    // Switch scenes
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("1st page");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        */

       takeExam_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (courseComboBox.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Please select a course!");
                    alert.show();
                }else  {
                    DataBaseUtils.changeScene(event, "ExamQuestionOne.fxml", "1st page", null, null);
                }
            }
       });

    }


    public void setUserInformation(String username, String intern_status) {
            label_welcome.setText("Welcome " + username +"," + " to MeenahCode!");
            label_intern_status.setText("Hi there, " + intern_status.toLowerCase() + ". Please select course to take exam.");
    }
}
