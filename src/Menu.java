import javafx.application.*;
import javafx.collections.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

public class Menu extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Text title = new Text();
        title.setText("Flappy Bird");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        title.setFill(Color.WHITE);
        title.setStroke(Color.BLACK);
        title.setStrokeType(StrokeType.OUTSIDE);
        title.setStrokeWidth(5);
        title.setX(190);
        title.setY(50);

        Button startButton = new Button("Start");
        startButton.setLayoutX(280);
        startButton.setLayoutY(250);
        startButton.setScaleX(3);
        startButton.setScaleY(3);
        startButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        Group root = new Group();
        root.getChildren().addAll(title, startButton);

        Scene scene = new Scene(root, 600, 800);
        scene.setFill(Color.AQUA);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                System.out.println("YA");
                Game game = new Game(stage);
                stage.setScene(game.getScene()) ;
            }
        };

        startButton.setOnAction(event);

        stage.setTitle("Flappy Bird");
        stage.setScene(scene);
        stage.setMaxHeight(800);
        stage.setMaxWidth(600);
        stage.setMinHeight(800);
        stage.setMinWidth(600);
        stage.show();
    }
    
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
