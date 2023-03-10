package com.example.gui_project_3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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

public class AddIngredient {


    public static void show() {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        VBox vBox = new VBox();
        HBox titleBox = new HBox();
        HBox ingredientsBox = new HBox();
        Text titleText = new Text("Name");
        Text tasteText = new Text("Taste");
        TextField titleField = new TextField();
        TextField tasteField = new TextField();
        Button addButton = new Button("Add");

        titleBox.getChildren().addAll(titleText, titleField);
        ingredientsBox.getChildren().addAll(tasteText, tasteField);
        vBox.getChildren().addAll(titleBox, ingredientsBox, addButton);
        titleBox.setSpacing(50);
        ingredientsBox.setSpacing(57);
        vBox.setSpacing(70);
        titleText.setFont(new Font(null, 20));
        tasteText.setFont(new Font(null, 20));
        addButton.setFont(new Font(null, 15));
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Ingredient ing = new Ingredient(titleField.getText(), tasteField.getText());
                //add to reciepe
                for (Reciepe rs : Reciepe.reciepes) {
                    if (rs.getName().equals(Main.rTitle)) {
                        rs.ingredient[rs.ingredient.length - 1] = ing;
                    }
                }
            }
        });

        root.setCenter(vBox);
        root.setPadding(new Insets(20));
        stage.setTitle("Add ingredients");
        stage.setScene(scene);
        stage.setWidth(350);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
    }

}
