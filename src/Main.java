import javafx.application.*;
import javafx.collections.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.event.*;

/**
 * 
 * @author Stuart Baxter
 */
public class Main extends Application {
    ObservableList<Node> list;
    Bird birdObject = new Bird();
    Group bird = birdObject.bird();

    public void applyGravity() {
        bird.setTranslateY(bird.getTranslateY()+1);
    }

    @Override
    public void start(Stage stage) throws Exception {
        bird.setTranslateX(150.0f);
        bird.setTranslateY(150.0f);

        Rectangle ground = new Rectangle();
        ground.setX(0);
        ground.setY(650);
        ground.setWidth(600);
        ground.setHeight(150);
        ground.setFill(Color.BURLYWOOD);
        ground.setStroke(Color.GREEN);
        ground.setStrokeType(StrokeType.OUTSIDE);
        ground.setStrokeWidth(10);

        Group root = new Group();

        root.getChildren().addAll(ground, bird);

        list = root.getChildren();
        System.out.println(list);

        Scene scene = new Scene(root, 600, 800);

        scene.setFill(Color.AQUA);

        stage.setTitle("Flappy Bird");
        stage.setScene(scene);
        stage.setMaxHeight(800);
        stage.setMaxWidth(600);
        stage.setMinHeight(800);
        stage.setMinWidth(600);
        stage.show();

        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                System.out.println("Space Pressed");

                TranslateTransition jump = new TranslateTransition(Duration.millis(200), bird);
                jump.setByY(-50);
                jump.play();
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                applyGravity();
                //movePipes();
                //checkCollisions();
                //checkScore();
            }
        };
        gameLoop.start();
    }

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
