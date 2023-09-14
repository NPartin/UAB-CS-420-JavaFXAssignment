package com.example.uabcs420javafxassignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextArea messageTextArea2;
    private ComboBox<String> dropdown;
    private ComboBox<String> colorDropdown;
    private Button changeColorButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Dashboard");

        // Create UI elements for the first screen
        TextArea messageTextArea = new TextArea();
        messageTextArea.setPrefWidth(200); // Adjust the width
        messageTextArea.setPrefHeight(350); // Adjust the height (slightly shorter)

        // Create UI elements for the second screen
        messageTextArea2 = new TextArea();
        messageTextArea2.setPrefWidth(200); // Adjust the width
        messageTextArea2.setPrefHeight(400); // Adjust the height

        dropdown = new ComboBox<>();
        Button selectButton = new Button("Select");
        Button deleteButton = new Button("Delete");

        // Populate the dropdown with options
        dropdown.getItems().addAll("Option 1", "Option 2");

        // Event handling for the Select button
        selectButton.setOnAction(e -> {
            String selectedOption = dropdown.getValue();
            if (selectedOption != null) {
                messageTextArea2.appendText(selectedOption + " selected\n");
            }
        });

        // Event handling for the Delete button
        deleteButton.setOnAction(e -> {
            String selectedOption = dropdown.getValue();
            if (selectedOption != null) {
                messageTextArea2.appendText(selectedOption + " deleted\n");
            }
        });

        // Create labels
        Label label1 = new Label("Farm Items");
        Label label2 = new Label("Messages");

        // Create a VBox to hold the label
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label1, messageTextArea);

        // Create a VBox for the second screen
        VBox vbox2 = new VBox(10);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(label2, messageTextArea2, dropdown, selectButton, deleteButton);

        // Create an HBox to hold both screens side by side
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox, vbox2);

        // Create a VBox for the color change section
        VBox colorChangeVBox = new VBox(10);
        colorChangeVBox.setAlignment(Pos.CENTER);

        // Create a color dropdown
        colorDropdown = new ComboBox<>();
        colorDropdown.getItems().addAll("Red", "Green", "Blue");
        colorDropdown.setValue("Red"); // Set default selection

        // Create a "Change Color" button
        changeColorButton = new Button("Change Color");
        changeColorButton.setOnAction(e -> {
            String selectedColor = colorDropdown.getValue();
            if (selectedColor != null) {
                // Change the color of the button based on the selection
                switch (selectedColor) {
                    case "Red" -> changeColorButton.setStyle("-fx-background-color: red;");
                    case "Green" -> changeColorButton.setStyle("-fx-background-color: green;");
                    case "Blue" -> changeColorButton.setStyle("-fx-background-color: blue;");
                }
            }
        });

        colorChangeVBox.getChildren().addAll(colorDropdown, changeColorButton);

        // Create a VBox to hold everything at the bottom center
        VBox bottomVBox = new VBox(10);
        bottomVBox.setAlignment(Pos.CENTER);
        bottomVBox.setPadding(new Insets(10));
        bottomVBox.getChildren().addAll(colorChangeVBox);

        // Create a BorderPane to arrange the content
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hbox);
        borderPane.setBottom(bottomVBox);

        // Create the scene and set it in the stage
        Scene scene = new Scene(borderPane, 900, 400); // Adjust the width as needed
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}
