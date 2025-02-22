package main.loginpagewithstephen;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DataBaseUtils {
    
    //method changes the window and it's contents
    public static void changeScene (ActionEvent event, String fxmlFile, String title, String username, String intern_status) {

        //Will contain the information of the scene that is being displayed
        Parent root = null;

        //Validation check
        if (username != null && intern_status != null) {
            try {
                //Fxml loads the scene from an fxml document
                FXMLLoader loader = new FXMLLoader(DataBaseUtils.class.getResource(fxmlFile));

                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username, intern_status);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {

            try {
                root = FXMLLoader.load(DataBaseUtils.class.getResource(fxmlFile));


            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("scene initialized");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 592, 600));
        stage.show();
    }

    public static void signUpUser (ActionEvent event, String username, String password, String intern_status) {
        //Connection to database
        Connection connection = null;
        PreparedStatement pInsert = null;
        PreparedStatement pCheckUserExist = null;
        ResultSet resultSet = null;

        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/login-schema", "root", "mysqlpsswd");
            pCheckUserExist = connection.prepareStatement("SELECT password, intern_status FROM users WHERE username = ?");
            pCheckUserExist.setString(1, username);
            resultSet = pCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username already taken");
                alert.show();
            } else {
                pInsert = connection.prepareStatement("INSERT INTO users (username, password, intern_status) VALUES (?, ?, ?)");
                pInsert.setString(1, username);
                pInsert.setString(2, password);
                pInsert.setString(3, intern_status);
                pInsert.executeUpdate();

                changeScene(event, "logged-in.fxml", "Welcome", username, intern_status);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pCheckUserExist != null) {
                try {
                pCheckUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pInsert != null) {
                try {
                    pInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void loginUser (ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login-schema", "root", "mysqlpsswd");
            preparedStatement = connection.prepareStatement("SELECT password, intern_status FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Oops! User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided info no dey correct!");
                alert.show();
            }else {
                while (resultSet.next()) {

                    //Here i retrieve the password and radiobtn selection from the database
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedInternStatus = resultSet.getString("intern_status");

                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "logged-in.fxml", "Welcome", username, retrievedInternStatus);
                    }else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided info no dey correct!");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
