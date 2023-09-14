package com.example.uabcs420javafxassignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextArea duplicateMessageTextArea;
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

        // Create UI elements for the second screen (duplicate)
        duplicateMessageTextArea = new TextArea();
        duplicateMessageTextArea.setPrefWidth(200); // Adjust the width
        duplicateMessageTextArea.setPrefHeight(400); // Adjust the height

        dropdown = new ComboBox<>();
        Button selectButton = new Button("Select");
        Button deleteButton = new Button("Delete");

        // Populate the dropdown with options for the second screen (duplicate)
        dropdown.getItems().addAll("Option A", "Option B");

        // Event handling for the Select button on the second screen (duplicate)
        selectButton.setOnAction(e -> {
            String selectedOption = dropdown.getValue();
            if (selectedOption != null) {
                duplicateMessageTextArea.appendText(selectedOption + " selected\n");
            }
        });

        // Event handling for the Delete button on the second screen (duplicate)
        deleteButton.setOnAction(e -> {
            String selectedOption = dropdown.getValue();
            if (selectedOption != null) {
                duplicateMessageTextArea.appendText(selectedOption + " deleted\n");
            }
        });

        // Create labels for both screens
        Label label1 = new Label("Farm Items");
        Label label2 = new Label("Messages");

        // Create a VBox to hold the label and the first screen
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label1, messageTextArea);

        // Create a VBox for the second screen
        VBox duplicateVBox = new VBox(10);
        duplicateVBox.setAlignment(Pos.CENTER);
        duplicateVBox.getChildren().addAll(label2, duplicateMessageTextArea, dropdown, selectButton, deleteButton);

        // Create an HBox to hold both screens side by side
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox, duplicateVBox);

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
                // Change the background color of the button based on the selection
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
