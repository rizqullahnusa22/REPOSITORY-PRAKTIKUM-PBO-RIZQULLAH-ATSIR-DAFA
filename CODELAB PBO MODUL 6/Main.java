package org.example.codelabmodul6;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private final String USERNAME = "Rizqullah Atsir Dafa";
    private final String PASSWORD = "119";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        Label userLabel = new Label("Username:");
        TextField userTextField = new TextField();
        Label pwLabel = new Label("Password:");
        PasswordField pwBox = new PasswordField();
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(pwLabel, 0, 1);
        grid.add(pwBox, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 1, 3);

        // Membuat scene untuk login
        Scene loginScene = new Scene(grid, 300, 200);


        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = pwBox.getText();

            if (authenticate(username, password)) {

                primaryStage.setScene(createWelcomeScene(primaryStage, loginScene));
            } else {

                messageLabel.setText("Username / Password salah");
            }
        });

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    private boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private Scene createWelcomeScene(Stage primaryStage, Scene loginScene) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        Label welcomeLabel = new Label("Selamat Datang!");
        Button backButton = new Button("Kembali");

        backButton.setOnAction(e -> {
            primaryStage.setScene(loginScene);
        });

        vbox.getChildren().addAll(welcomeLabel, backButton);
        return new Scene(vbox, 300, 200);
    }

    public static void main(String[] args) {
        launch(args);
    }
}