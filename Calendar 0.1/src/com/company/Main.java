package com.company;

import javafx.scene.control.TextArea;
import java.awt.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Main extends Application {

    Stage window;
    Button signIn, signUp, signInButton, signUpButton, signtOut, save, back, viewTasks, newTask;
    Scene sceneA, sceneB, sceneC, sceneD, sceneE, sceneF, sceneG;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Window Options
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("TaskManager 0.4");
        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });
        //Text
        Text text = new Text("Welcome!");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,30));
        AnchorPane.setLeftAnchor(text, 130.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Buttons
        signIn = new Button("Sign In");
        signUp = new Button("Sign Up");
        signIn.setOnAction(e -> SigninScene());
        signUp.setOnAction(e -> SignupScene());
        signIn.setMaxWidth(60);
        signUp.setMaxWidth(60);
        //Scene
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(signIn , signUp);
        AnchorPane.setLeftAnchor(vBox, 170.0);
        AnchorPane.setTopAnchor(vBox, 110.0);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(vBox, text);
        sceneA = new Scene(anchorPane , 400 ,400);
        window.setScene(sceneA);
        window.show();

    }

    public void SigninScene(){

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
        signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> Choice());
        GridPane.setConstraints(signInButton, 1, 2);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, signInButton);
        sceneB = new Scene(grid, 400 , 400);
        window.setScene(sceneB);
        window.show();

    }

    public void SignupScene(){

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
        signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> SigninScene());
        GridPane.setConstraints(signUpButton, 1, 3);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, emailLabel, emailInput, passwordLabel, passwordInput, signUpButton);
        sceneC = new Scene(grid, 400 , 400);
        window.setScene(sceneC);
        window.show();

    }

    public void Choice(){

        //Text
        Text text = new Text("Home");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,25));
        AnchorPane.setLeftAnchor(text, 170.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Buttons
        VBox vBox = new VBox(10);
        newTask = new Button("New Task");
        newTask.setOnAction(e -> Description());
        newTask.setMaxWidth(90);
        viewTasks = new Button("View Tasks");
        viewTasks.setMaxWidth(90);
        signtOut = new Button("Sign Out");
        signtOut.setOnAction(e ->window.setScene(sceneA));
        signtOut.setMaxWidth(90);
        vBox.getChildren().addAll(newTask, viewTasks, signtOut);
        AnchorPane.setLeftAnchor(vBox, 170.0);
        AnchorPane.setTopAnchor(vBox, 80.0);
        //Scene
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(vBox, text);
        sceneD = new Scene(anchorPane,400,400);
        window.setScene(sceneD);
        window.show();

    }

    public void Description(){
        //Text
        Text text = new Text("Description");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,18));
        AnchorPane.setLeftAnchor(text, 150.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Title Label
        Label titleLabel = new Label("Title:");
        AnchorPane.setLeftAnchor(titleLabel, 20.0);
        AnchorPane.setTopAnchor(titleLabel,135.0);
        //Title Input
        TextField titleInput = new TextField();
        titleInput.setPromptText("Title");
        titleInput.setMaxWidth(125.0);
        AnchorPane.setLeftAnchor(titleInput, 55.0);
        AnchorPane.setTopAnchor(titleInput,130.0);
        //Date Label
        Label dateLabel = new Label("Date:");
        AnchorPane.setLeftAnchor(dateLabel, 20.0);
        AnchorPane.setTopAnchor(dateLabel,185.0);
        //Date
        DatePicker datePicker = new DatePicker();
        datePicker.setMaxWidth(125.0);
        AnchorPane.setLeftAnchor(datePicker, 55.0);
        AnchorPane.setTopAnchor(datePicker,180.0);
        //Note Label
        Label noteLabel = new Label("Note:");
        AnchorPane.setRightAnchor(noteLabel, 100.0);
        AnchorPane.setTopAnchor(noteLabel,75.0);
        //Note-Text Area
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setMaxWidth(150);
        textArea.setMaxHeight(200);
        AnchorPane.setRightAnchor(textArea,40.0);
        AnchorPane.setBottomAnchor(textArea, 100.0);
        //Buttons
        save = new Button("Save");
        save.setOnAction(e -> System.out.println("test"));
        AnchorPane.setLeftAnchor(save, 100.0);
        AnchorPane.setBottomAnchor(save, 35.0);
        back = new Button("Back");
        back.setOnAction(e ->Choice());
        AnchorPane.setRightAnchor(back, 100.0);
        AnchorPane.setBottomAnchor(back,35.0);
        //Scene
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(text, titleLabel, titleInput, dateLabel, datePicker, noteLabel, save, back, textArea);
        sceneE = new Scene(anchorPane,400,400);
        window.setScene(sceneE);
        window.show();

    }

    private void closeProgram(){

        Boolean answer = ConfirmBox.display("Exit Program","Are you sure you want to exit?");
        if (answer){
            window.close();
        }

    }

}