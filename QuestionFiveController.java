package main.loginpagewithstephen;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionFiveController implements Initializable {
    @FXML
    private JFXButton next_btn, prev_btn;

    @FXML
    private JFXButton question_1_btn;

    @FXML
    private JFXButton question_2_btn;

    @FXML
    private JFXButton question_3_btn;

    @FXML
    private JFXButton question_4_btn;

    @FXML
    private JFXRadioButton option_a;

    @FXML
    private JFXRadioButton option_b;

    @FXML
    private JFXRadioButton option_c;

    @FXML
    private JFXRadioButton option_d;

    @FXML
    private Label courseTitle_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup toggleGroup = new ToggleGroup();
        option_a.setToggleGroup(toggleGroup);
        option_b.setToggleGroup(toggleGroup);
        option_c.setToggleGroup(toggleGroup);
        option_d.setToggleGroup(toggleGroup);

//        question_1_btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                question_1_btn.getScene().getWindow();
//            }
//        });

        next_btn.setDisable(true);

        prev_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionFour.fxml", "4th page", null, null);
            }
        });

        question_1_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionOne.fxml", "1st page", null, null);
            }
        });

        question_2_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionTwo.fxml", "2nd page", null, null);
            }
        });

        question_3_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionThree.fxml", "3rd page", null, null);
            }
        });

        question_4_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionFour.fxml", "4th page", null, null);
            }
        });
    }

    public void setCourseTitle(String course) {
        courseTitle_id.setText(course); // Update the Label with the course name
    }
}
