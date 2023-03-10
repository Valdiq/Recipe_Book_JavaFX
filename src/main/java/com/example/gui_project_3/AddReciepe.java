package com.example.gui_project_3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AddReciepe {
    public static void show() {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        VBox vBox = new VBox();
        HBox titleBox = new HBox();
        HBox ingredientsBox = new HBox();
        HBox tastesBox = new HBox();
        Text titleText = new Text("Title");
        Text ingredientsText = new Text("Ingredients");
        Text tasteText = new Text("Tastes");
        TextField tasteField = new TextField();
        TextField titleField = new TextField();
        TextArea ingredientsArea = new TextArea();
        Button addButton = new Button("Add");

        titleBox.getChildren().addAll(titleText, titleField);
        ingredientsBox.getChildren().addAll(ingredientsText, ingredientsArea);
        tastesBox.getChildren().addAll(tasteText, tasteField);
        vBox.getChildren().addAll(titleBox, ingredientsBox, tastesBox, addButton);
        titleBox.setSpacing(110);
        ingredientsBox.setSpacing(50);
        tastesBox.setSpacing(95);
        vBox.setSpacing(40);
        titleText.setFont(new Font(null, 20));
        tasteText.setFont(new Font(null, 20));
        ingredientsText.setFont(new Font(null, 20));
        addButton.setFont(new Font(null, 15));

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String[] strings = ingredientsArea.getText().split(", ");
                String[] strtastes = tasteField.getText().split(", ");
                Ingredient[] ingredients = new Ingredient[strings.length];
                for (int i = 0; i < ingredients.length; i++) {
                    ingredients[i] = new Ingredient(strings[i], strtastes[i]);
                }
                Reciepe reciepe = new Reciepe(titleField.getText(), ingredients);
                Reciepe.reciepes.add(reciepe);
            }
        });


        root.setCenter(vBox);
        root.setPadding(new Insets(20));
        stage.setTitle("Add reciepe");
        stage.setScene(scene);
        stage.setWidth(350);
        stage.setHeight(310);
        stage.setResizable(false);
        stage.show();
    }

}
