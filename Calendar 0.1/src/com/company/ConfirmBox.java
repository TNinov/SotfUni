package com.company;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String massage){
        //Window Options
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setHeight(150);
        Label label = new Label();
        label.setText(massage);
        //Buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e ->{
            answer = true;
            window.close();
        });
        noButton.setOnAction(e ->{
            answer = false;
            window.close();
        });
        //Scene
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, yesButton, noButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("MyCSS.css");
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }

}