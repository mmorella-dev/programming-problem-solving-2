package module3.gui.buttonapp;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * ButtonApp
 */
public class ButtonApp extends Application {
    public static String[] buttonNames = {
        "Button #1", 
        "Button #2", 
        "Button #3", 
        "Button #4",
        "Button #5",
        "Button #6"
    };
    public static String[] messages = { 
            "Blam! You pressed %s!", 
            "Wowie! %s was pressed!",
            "Bazinga! You pressed the heck out of %s!", 
            "Wowie! You just pressed %s!", 
            "Outstanding! That was %s!",
            "Kapow! Nice work on pressing %s!", 
            "Whoa mama! Did you just press %s?", 
            "Hachi machi, you pressed %s.",
            "Press %s again. See what happens.", 
            "Huh. Somebody just pushed %s.",
            "何!? %s が押されました!" 
    };

    private TextField textField;
    private Pane buttonList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        primaryStage.setScene(new Scene(root, 400, 100));

        // Create display window
        textField = new TextField("Welcome! Press any button.");
        textField.editableProperty().set(false);
        root.getChildren().add(textField);

        // Create panel of Buttons
        buttonList = new FlowPane(5,5);
        for (String btnName : buttonNames) {
            // Create Button
            Button btn = new Button(btnName);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    handleButtonClick(btnName);
                }});
            buttonList.getChildren().add(btn);
        }
        root.getChildren().add(buttonList);
        primaryStage.show();
    }

    /**  */
    public void handleButtonClick(String buttonName) {
        int index = (int)(Math.random() * messages.length);
        String format = messages[index];
        String message = String.format(format, buttonName); // Insert button name ("You pressed Button #3")
        showText(message); // Display message
    }

    public void showText(String message) {
        textField.setText(message);
    }
}