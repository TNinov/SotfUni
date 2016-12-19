package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import java.sql.*;
import javafx.scene.image.Image;

import java.sql.Date;

public class Main extends Application {

    Stage window;
    Button signIn, signUp, signInButton, signUpButton, signtOut, save, delete, back, viewTasks, newTask;
    TableView<Tasks> tableView;
    TextField titleInput;
    TextArea noteInput;
    DatePicker dateInput;
    Scene sceneA, sceneB, sceneC, sceneD, sceneE, sceneF;

    public static void main(String[] args) {


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Window Options
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("TaskManager 0.5");
        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });
        AnchorPane anchorPane = new AnchorPane();
        //Text
        Text text = new Text("Welcome!");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,30));
        AnchorPane.setLeftAnchor(text, 130.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Buttons
        signIn = new Button("Sign In");
        signUp = new Button("Sign Up");
        signIn.setOnAction(e -> signinScene());
        signUp.setOnAction(e -> signupScene());
        //Scene
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(signIn , signUp);
        AnchorPane.setLeftAnchor(vBox, 170.0);
        AnchorPane.setTopAnchor(vBox, 110.0);
        anchorPane.getChildren().addAll(vBox, text);
        sceneA = new Scene(anchorPane , 400 ,400);
        sceneA.getStylesheets().add("MyCSS.css");
        window.setScene(sceneA);
        window.show();

    }

    public void signinScene(){

        AnchorPane anchorPane = new AnchorPane();
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
        //Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        //Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        //Buttons
        back = new Button("Back");
        back.setOnAction(e ->window.setScene(sceneA));
        GridPane.setConstraints(back, 1, 3);
        signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> home());
        GridPane.setConstraints(signInButton, 1, 2);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, signInButton, back);
        anchorPane.getChildren().addAll(grid);
        AnchorPane.setLeftAnchor(grid, 70.0);
        AnchorPane.setTopAnchor(grid, 110.0);
        sceneB = new Scene(anchorPane, 400 , 400);
        sceneB.getStylesheets().add("MyCSS.css");
        window.setScene(sceneB);
        window.show();

    }

    public void signupScene(){

        AnchorPane anchorPane = new AnchorPane();
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
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 2);
        //Buttons
        back = new Button("Back");
        back.setOnAction(e ->window.setScene(sceneA));
        GridPane.setConstraints(back, 1, 4);
        signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> signinScene());
        GridPane.setConstraints(signUpButton, 1, 3);
        //Scene
        grid.getChildren().addAll(nameLabel, nameInput, emailLabel, emailInput, passwordLabel, passwordInput, signUpButton,back);
        anchorPane.getChildren().addAll(grid);
        AnchorPane.setLeftAnchor(grid, 70.0);
        AnchorPane.setTopAnchor(grid, 110.0);
        sceneC = new Scene(anchorPane, 400 , 400);
        sceneC.getStylesheets().add("MyCSS.css");
        window.setScene(sceneC);
        window.show();

    }

    public void home(){

        VBox vBox = new VBox(10);
        //Text
        Text text = new Text("Home");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,25));
        AnchorPane.setLeftAnchor(text, 170.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Buttons
        newTask = new Button("New Task");
        newTask.setOnAction(e -> newTask());
        newTask.setMaxWidth(90);
        viewTasks = new Button("View Tasks");
        viewTasks.setOnAction(e -> viewTask());
        viewTasks.setMaxWidth(90);
        signtOut = new Button("Sign Out");
        signtOut.setOnAction(e ->window.setScene(sceneA));
        signtOut.setMaxWidth(90);
        //Scene
        vBox.getChildren().addAll(newTask, viewTasks, signtOut);
        AnchorPane.setLeftAnchor(vBox, 170.0);
        AnchorPane.setTopAnchor(vBox, 80.0);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(vBox, text);
        sceneD = new Scene(anchorPane,400,400);
        sceneD.getStylesheets().add("MyCSS.css");
        window.setScene(sceneD);
        window.show();

    }

    public void newTask(){

        AnchorPane anchorPane = new AnchorPane();
        //Text
        Text text = new Text("Description:");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,18));
        AnchorPane.setLeftAnchor(text, 150.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Title Label
        Label titleLabel = new Label("Title:");
        AnchorPane.setLeftAnchor(titleLabel, 20.0);
        AnchorPane.setTopAnchor(titleLabel,135.0);
        //Title Input
        titleInput = new TextField();
        titleInput.setPromptText("Title");
        titleInput.setMaxWidth(125.0);
        AnchorPane.setLeftAnchor(titleInput, 55.0);
        AnchorPane.setTopAnchor(titleInput,130.0);
        //Date Label
        Label dateLabel = new Label("Date:");
        AnchorPane.setLeftAnchor(dateLabel, 20.0);
        AnchorPane.setTopAnchor(dateLabel,185.0);
        //Date
        dateInput = new DatePicker();
        dateInput.setMaxWidth(125.0);
        AnchorPane.setLeftAnchor(dateInput, 55.0);
        AnchorPane.setTopAnchor(dateInput,180.0);
        //Note Label
        Label noteLabel = new Label("Note:");
        AnchorPane.setRightAnchor(noteLabel, 100.0);
        AnchorPane.setTopAnchor(noteLabel,75.0);
        //Note-Text Area
        noteInput = new TextArea();
        noteInput.setWrapText(true);
        noteInput.setMaxWidth(150);
        noteInput.setMaxHeight(200);
        AnchorPane.setRightAnchor(noteInput,40.0);
        AnchorPane.setBottomAnchor(noteInput, 100.0);
        //Buttons
        save = new Button("Save");
        save.setOnAction(e -> saveButton());
        AnchorPane.setLeftAnchor(save, 100.0);
        AnchorPane.setBottomAnchor(save, 35.0);
        back = new Button("Back");
        back.setOnAction(e ->home());
        AnchorPane.setRightAnchor(back, 100.0);
        AnchorPane.setBottomAnchor(back,35.0);
        //Scene
        anchorPane.getChildren().addAll(text, titleLabel, titleInput, dateLabel, dateInput, noteLabel, save, back, noteInput);
        sceneE = new Scene(anchorPane,400,400);
        sceneE.getStylesheets().add("MyCSS.css");
        window.setScene(sceneE);
        window.show();

    }
    //Save Button
    public void saveButton(){
        Tasks tasks = new Tasks();
        tasks.setTitle(titleInput.getText());
        tasks.setDate(dateInput.getAccessibleText());             //////?????????????
        tasks.setNote(noteInput.getText());
        tableView.getItems().add(tasks);
        titleInput.clear();
        noteInput.clear();

    }

    public void viewTask(){

        AnchorPane anchorPane = new AnchorPane();
        //Text
        Text text = new Text("Tasks:");
        text.setFont(Font.font("",FontWeight.NORMAL, FontPosture.ITALIC,18));
        AnchorPane.setLeftAnchor(text, 150.0);
        AnchorPane.setTopAnchor(text, 30.0);
        //Title Column
        TableColumn<Tasks, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setResizable(false);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        //Date Column
        TableColumn<Tasks, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setResizable(false);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        //Note Column
        TableColumn<Tasks, String> noteColumn = new TableColumn<>("Note");
        noteColumn.setResizable(false);
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        //TableView
        tableView = new TableView<>();
        tableView.setItems(getTasks());
        tableView.getColumns().addAll(titleColumn,dateColumn,noteColumn);
        tableView.setMaxHeight(260);
        AnchorPane.setRightAnchor(tableView, 80.0);
        AnchorPane.setLeftAnchor(tableView,80.0);
        AnchorPane.setTopAnchor(tableView, 60.0);
        //Buttons
        delete = new Button("Delete");
        delete.setOnAction(e -> deleteButton());
        AnchorPane.setLeftAnchor(delete, 100.0);
        AnchorPane.setBottomAnchor(delete, 35.0);
        back = new Button("Back");
        back.setOnAction(e ->home());
        AnchorPane.setRightAnchor(back, 100.0);
        AnchorPane.setBottomAnchor(back,35.0);
        //Scene
        anchorPane.getChildren().addAll(text, tableView, back, delete);
        sceneF = new Scene(anchorPane,400,400);
        sceneF.getStylesheets().add("MyCSS.css");
        window.setScene(sceneF);
        window.show();
    }
    //Delete Button
    public void deleteButton(){
        ObservableList<Tasks> tasksSelected, allTasks;
        allTasks = tableView.getItems();
        tasksSelected = tableView.getSelectionModel().getSelectedItems();
        tasksSelected.forEach(allTasks::remove);
    }

    //Tasks
    public ObservableList<Tasks> getTasks(){
        ObservableList<Tasks> tasks = FXCollections.observableArrayList();
        //testing
        tasks.add(new Tasks("asd","asd","asd"));
        return tasks;
    }

    //Exit
    private void closeProgram(){

        Boolean answer = ConfirmBox.display("Exit Program","Are you sure you want to exit?");
        if (answer){
            window.close();
        }

    }

}