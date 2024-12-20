package com.joevno.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleJavaFxUI extends Application {
    private Label label;
    private Button button;

    @Override
    public void start(Stage primaryStage) {
        label = new Label("Hello, World!");
        button = new Button("Click Me");

        button.setOnAction(e -> label.setText("Button Clicked"));

        VBox vbox = new VBox(label, button);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple JavaFX UI");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

