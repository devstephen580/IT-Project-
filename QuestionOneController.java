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
import java.util.Timer;

public class QuestionOneController implements Initializable {


    @FXML
    private Label courseTitle_id;

    @FXML
    private JFXRadioButton option_a;

    @FXML
    private JFXRadioButton option_b;

    @FXML
    private JFXRadioButton option_c;

    @FXML
    private JFXRadioButton option_d;

    @FXML
    private JFXButton next_btn, prev_btn;

    @FXML
    private Label question_label;

    @FXML
    private JFXButton question_1_btn;

    @FXML
    private JFXButton question_2_btn;

    @FXML
    private JFXButton question_3_btn;

    @FXML
    private JFXButton question_4_btn;

    @FXML
    private JFXButton question_5_btn;

    @FXML
    private JFXButton submit_btn;

    @FXML
    private Label timer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Timer timer1 = new Timer();
//        timer1.schedule();

        ToggleGroup toggleGroup = new ToggleGroup();
        option_a.setToggleGroup(toggleGroup);
        option_b.setToggleGroup(toggleGroup);
        option_c.setToggleGroup(toggleGroup);
        option_d.setToggleGroup(toggleGroup);

        // Add to initialize() method
        next_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionTwo.fxml", "2nd page", null, null);
            }
        });

        prev_btn.setDisable(true); // Disable prev on first question

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

        question_5_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "ExamQuestionFive.fxml", "5th page", null, null);
            }
        });
    }

    public void setCourseTitle(String course) {
        courseTitle_id.setText(course); // Update the Label with the course name
    }
}
