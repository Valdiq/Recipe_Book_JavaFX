package com.example.gui_project_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;
public class Main extends Application {
    private BorderPane root = new BorderPane();
    private BorderPane borderPane = new BorderPane();
    private HBox titlebox = new HBox();
    private Scene scene = new Scene(root);
    private Menu menu = new Menu("Menu");
    private MenuBar menuBar = new MenuBar();
    private MenuItem addReciepe = new MenuItem("Add reciepe");
    private MenuItem addIngredient = new MenuItem("Add ingredient");
    private BorderPane listOfReciepes = new BorderPane();
    private ScrollBar scrollBarV = new ScrollBar();
    private ScrollBar scrollBarH = new ScrollBar();
    private Text title = new Text("Reciepes");
    private VBox reciepes = new VBox(); //main box of reciepes

    static String rTitle;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Reciepe reciepe1 = new Reciepe("Charlotte", new Ingredient("Apple", "Sweet"), new Ingredient("Cynamon", "Bitter"));
        Reciepe reciepe2 = new Reciepe("Cheese Cake", new Ingredient("Carrot", "Sweet"), new Ingredient("Cheese", "Salty"), new Ingredient("Sugar", "Sweet"));
        Reciepe reciepe3 = new Reciepe("Pumpkin Fresh", new Ingredient("Pumpkin", "Neutral"), new Ingredient("Milk", "Neutral"), new Ingredient("Sugar", "Sweet"));
        Reciepe reciepe4 = new Reciepe("Fish in Oven", new Ingredient("Fish", "Salty"), new Ingredient("Tomato", "Sweet"), new Ingredient("Paper", "Neutral"));
        Reciepe reciepe5 = new Reciepe("Tiramisu", new Ingredient("Coffee", "Bitter"), new Ingredient("Milk", "Neutral"), new Ingredient("Bisquite", "Neutral"));
        Reciepe reciepe6 = new Reciepe("Burger", new Ingredient("Meet", "Salty"), new Ingredient("Ketchup", "Sour"), new Ingredient("Cucumber", "Neutral"), new Ingredient("Tomato", "Neutral"), new Ingredient("Bread", "Sweet"));
        Reciepe reciepe7 = new Reciepe("Kebab", new Ingredient("Meet", "Salty"), new Ingredient("Souse", "Sour"), new Ingredient("Cucumber", "Neutral"), new Ingredient("Tomato", "Neutral"), new Ingredient("Bread", "Neutral"));
        Reciepe reciepe8 = new Reciepe("Banana Milkshake", new Ingredient("Banana", "Sweet"), new Ingredient("Milk", "Neutral"), new Ingredient("Icecream", "Sweet"));
        Reciepe reciepe9 = new Reciepe("Chocolate Cookies", new Ingredient("Chocolate", "Bitter"), new Ingredient("Souse", "Sweet"), new Ingredient("Milk", "Neutral"));

        Reciepe.reciepes.add(reciepe1);
        Reciepe.reciepes.add(reciepe2);
        Reciepe.reciepes.add(reciepe3);
        Reciepe.reciepes.add(reciepe4);
        Reciepe.reciepes.add(reciepe5);
        Reciepe.reciepes.add(reciepe6);
        Reciepe.reciepes.add(reciepe7);
        Reciepe.reciepes.add(reciepe8);
        Reciepe.reciepes.add(reciepe9);


        menu.getItems().addAll(addReciepe, addIngredient);
        menuBar.getMenus().addAll(menu);


        title.setFont(Font.font(null, 40));
        title.setFill(Color.SADDLEBROWN);
        scrollBarV.setOrientation(Orientation.VERTICAL);


        title.setTextAlignment(TextAlignment.CENTER);
        titlebox.getChildren().add(title);
        titlebox.setAlignment(Pos.TOP_CENTER);
        titlebox.setPadding(new Insets(0, 0, 0, -25));
        root.setTop(menuBar);
        root.setRight(scrollBarV);
        root.layoutYProperty().bind(scrollBarV.valueProperty().multiply(-5));
        root.setCenter(listOfReciepes);

        listOfReciepes();

        addReciepe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddReciepe.show();
            }
        });

        addIngredient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Add ingredient clicked!");
                for (Reciepe rs : Reciepe.reciepes) {
                    if (rs.getName().equals(rTitle)) {
                        AddIngredient.show();
                    }
                }

            }
        });

        reciepes.setSpacing(30);
        reciepes.setAlignment(Pos.CENTER);
        reciepes.setPadding(new Insets(40, 0, 40, 60));
        root.setBackground(new Background(new BackgroundFill(Color.OLDLACE, CornerRadii.EMPTY, Insets.EMPTY)));
        scene.setFill(Color.OLDLACE);
        root.getChildren().addAll(borderPane);
        stage.setTitle("Przepisy");
        stage.setScene(scene);
        stage.setWidth(550);
        stage.setHeight(650);
        stage.show();
    }

    public void listOfReciepes() {
        ArrayList<HBox> hBoxes = new ArrayList<HBox>();
        for (int i = 0; i < Reciepe.reciepes.size(); i++) {
            VBox textBox = new VBox();
            HBox reciepesBox = new HBox();
            StackPane stackPane = new StackPane();
            Circle circle = new Circle(20, Color.SADDLEBROWN);
            Line line = new Line();
            Text number = new Text();
            Text reciepeText = new Text();
            listOfReciepes.setCenter(reciepes);
            listOfReciepes.setTop(titlebox);

            number.setText(String.valueOf(i + 1));
            reciepeText.setText(Reciepe.reciepes.get(i).getName());
            rTitle = reciepeText.getText();
            line.startXProperty().bind(root.widthProperty());
            line.endXProperty().bind(root.heightProperty().divide(4));
            textBox.setSpacing(5);
            reciepesBox.setSpacing(20);
            stackPane.getChildren().addAll(circle, number);
            textBox.getChildren().addAll(reciepeText, line);
            reciepesBox.getChildren().addAll(stackPane, textBox);
            reciepeText.setFont(new Font(null, 20));
            number.setFont(new Font(null, 18));
            number.setFill(Color.BISQUE);

            reciepesBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (Reciepe rs : Reciepe.reciepes) {
                        if (rs.getName().equals(reciepeText.getText())) {
                            reciepes.setVisible(false);
                            title.setText(rs.getName());
                            BorderPane infoPane = new BorderPane();
                            VBox reciepeInfo = new VBox();
                            HBox ingretientsHbox = new HBox();
                            HBox pointHbox = new HBox();
                            VBox ingredients = new VBox();
                            VBox point = new VBox();
                            Text rsTitle = new Text(rs.getName());

                            Text ingredientsList = new Text();
                            String ings = " ";

                            for (int i = 0; i < rs.getIngredient().length; i++) {
                                if (i == rs.getIngredient().length - 1) {
                                    ings += rs.ingredient[i].getName();
                                } else {
                                    ings += rs.ingredient[i].getName() + ", ";
                                }
                            }
                            ingredientsList.setText(ings);

                            Text reciepePoint = new Text(rs.point(rs));
                            Line ingredLine = new Line();
                            Line pointLine = new Line();
                            Text ingredText = new Text("Ingredients");
                            Text pointText = new Text("Point");
                            ingredLine.startXProperty().bind(root.widthProperty());
                            ingredLine.endXProperty().bind(root.heightProperty().divide(4).add(25));
                            pointLine.startXProperty().bind(root.widthProperty());
                            pointLine.endXProperty().bind(root.heightProperty().divide(4));
                            ingredients.getChildren().addAll(ingredientsList, ingredLine);
                            point.getChildren().addAll(reciepePoint, pointLine);
                            ingretientsHbox.getChildren().addAll(ingredText, ingredients);
                            pointHbox.getChildren().addAll(pointText, point);
                            ingretientsHbox.setSpacing(20);
                            pointHbox.setSpacing(50);
                            reciepeInfo.setSpacing(150);
                            ingredients.setPadding(new Insets(5, 0, 0, 0));
                            point.setPadding(new Insets(5, 0, 0, 0));
                            ingredientsList.setFont(new Font(null, 15));
                            reciepePoint.setFont(new Font(null, 15));
                            ingredText.setFont(new Font(null, 20));
                            pointText.setFont(new Font(null, 20));
                            ingredText.setFill(Color.SADDLEBROWN);
                            pointText.setFill(Color.SADDLEBROWN);
                            infoPane.setPadding(new Insets(70, 50, 50, 50));
                            reciepeInfo.getChildren().addAll(ingretientsHbox, pointHbox);
                            infoPane.setCenter(reciepeInfo);
                            listOfReciepes.setCenter(infoPane);

                        }
                    }
                }
            });

            hBoxes.add(reciepesBox);
            reciepes.getChildren().addAll(hBoxes.get(i));
        }
    }
}