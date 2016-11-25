package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Main extends Application {


    Stage window;
    Button logIn, signIn, loginButton, signinButton;
    Scene scene1, scene2, scene3, scene4;

    private static final double CENTER = 170;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Window Options
        window = primaryStage;
        window.setTitle("Calendar 001");
        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });
        //Buttons scene 1
        logIn = new Button("Log In");
        signIn = new Button("Sign In");
        logIn.setOnAction(e -> LoginScene());
        signIn.setOnAction(e -> SigninScene());
        logIn.setMaxWidth(Double.MAX_VALUE);
        signIn.setMaxWidth(Double.MAX_VALUE);
        //Scene 1
        VBox vBox = new VBox();
        vBox.getChildren().addAll(logIn , signIn);
        vBox.setPadding(new Insets(CENTER));
        scene1 = new Scene(vBox , 400 ,400);
        window.setScene(scene1);
        window.show();
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Exit Program","Are you sure you want to exit?");
        if (answer){
            window.close();
        }
    }

    public void LoginScene(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        //Name Label
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);
        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);
        //Password Label
        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 1);
        //Password Input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        //Buttons scene
        loginButton = new Button("Log In");
        loginButton.setOnAction(e -> window.setScene(scene4));
        //button2.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(loginButton, 1, 2);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton);
        StackPane layout2 = new StackPane();
        //layout2.getChildren().add(button2);
        scene2 = new Scene(grid, 400 , 400);
        window.setScene(scene2);
        window.show();
    }

    public void SigninScene(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        //Name Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);
        //E-mail Label
        Label emailLabel = new Label("E-mail:");
        GridPane.setConstraints(emailLabel, 0, 1);
        //E-mail Input
        TextField emailInput = new TextField();
        emailInput.setPromptText("E-mail");
        GridPane.setConstraints(emailInput, 1, 1);
        //Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 2);
        //Password Input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 2);
        //Buttons scene
        signinButton = new Button("Sign In");
        signinButton.setOnAction(e -> LoginScene());
        //button2.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(signinButton, 1, 3);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, emailLabel, emailInput, passwordLabel, passwordInput, signinButton);
        StackPane layout2 = new StackPane();
        //layout2.getChildren().add(button2);
        scene3 = new Scene(grid, 400 , 400);
        window.setScene(scene3);
        window.show();
    }

    /*public void CalendarScene(){

        StackPane layout2 = new StackPane();
        scene4 = new Scene(layout2,400 , 400);
        window.setScene(scene4);
        window.show();
    }*/
}