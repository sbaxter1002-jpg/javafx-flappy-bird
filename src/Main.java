import javafx.application.*;
import javafx.collections.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

/**
 * 
 * @author Stuart Baxter
 */
public class Main extends Application {
    ObservableList<Node> list;
    Bird birdObject = new Bird();
    Group bird = birdObject.bird();
    Pipe pipeObject = new Pipe();
    Group pipe = pipeObject.pipe();
    double velocity = 0;
    static final double GRAVITY = 0.3;
    static final double JUMP_FORCE = -8;
    static final double GROUND_Y = 616;
    static final double PIPE_SPEED = 5;
    boolean scoreValid = true;
    int score = 0;
    Text scoreText = new Text();

    public void applyGravity() {
        if (bird.getTranslateY() <= GROUND_Y) {
            velocity += GRAVITY;
            bird.setTranslateY(bird.getTranslateY() + velocity);
        } else {
            velocity = 0;
        }
    }

    public void rotateBird() {
        // sets target angle but then maxes out target to -30 and 30 
        double targetAngle = velocity * 6;
        double clampedAngle = Math.max(-30, Math.min(30, targetAngle));
        bird.setRotate(clampedAngle);
    }

    public void movePipes() {
        if (pipe.getTranslateX() > -150) {
            pipe.setTranslateX(pipe.getTranslateX() - PIPE_SPEED);
        }
        else if (pipe.getTranslateX() == -150) {
            pipeObject.setTopPipeLength();
            pipe.setTranslateX(600);
            scoreValid = true;
        }
    }

    public void checkCollisions() {
        
    }

    public void checkScore() {
        if (bird.getTranslateX() > pipe.getTranslateX() && scoreValid == true) {
            score++;
            scoreValid = false;
            scoreText.setText(Integer.toString(score));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        bird.setTranslateX(150.0f);
        bird.setTranslateY(150.0f);

        pipe.setTranslateX(600);

        scoreText.setText(Integer.toString(score));
        scoreText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        scoreText.setFill(Color.WHITE);
        scoreText.setStroke(Color.BLACK);
        scoreText.setStrokeType(StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(5);
        scoreText.setX(280);
        scoreText.setY(50);

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

        root.getChildren().addAll(ground, bird, pipe, scoreText);

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
                velocity = JUMP_FORCE;
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                applyGravity();
                rotateBird();
                movePipes();
                //checkCollisions();
                checkScore();
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
