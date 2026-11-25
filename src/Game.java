import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game {

    private Group root = new Group();
    private Scene scene = new Scene(root, 600, 800);

    private Bird birdObject = new Bird();
    private Group bird = birdObject.bird();

    private Pipe pipeObject = new Pipe();
    private Group pipe = pipeObject.pipe();

    private double velocity = 0;

    private static final double GRAVITY = 0.3;
    private static final double JUMP_FORCE = -8;
    private static final double GROUND_Y = 616;
    private static final double PIPE_SPEED = 5;

    private boolean scoreValid = true;
    private int score = 0;

    private Text scoreText = new Text();
    private Rectangle ground = new Rectangle();

    public Game(Stage stage) {

        bird.setTranslateX(150);
        bird.setTranslateY(150);

        pipe.setTranslateX(600);

        scoreText.setText("0");
        scoreText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        scoreText.setFill(Color.WHITE);
        scoreText.setStroke(Color.BLACK);
        scoreText.setStrokeType(StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(5);
        scoreText.setX(280);
        scoreText.setY(50);

        ground.setX(0);
        ground.setY(650);
        ground.setWidth(600);
        ground.setHeight(150);
        ground.setFill(Color.BURLYWOOD);
        ground.setStroke(Color.GREEN);
        ground.setStrokeWidth(10);

        root.getChildren().addAll(bird, pipe, ground, scoreText);

        scene.setFill(Color.AQUA);

        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                velocity = JUMP_FORCE;
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                applyGravity();
                rotateBird();
                movePipes();
                checkCollisions();
                checkScore();
            }
        };
        gameLoop.start();
    }

    public Scene getScene() {
        return scene;
    }

    private void applyGravity() {
        if (bird.getTranslateY() <= GROUND_Y) {
            velocity += GRAVITY;
            bird.setTranslateY(bird.getTranslateY() + velocity);
        } else {
            velocity = 0;
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    private void rotateBird() {
        double targetAngle = velocity * 6;
        double clampedAngle = Math.max(-30, Math.min(30, targetAngle));
        bird.setRotate(clampedAngle);
    }

    private void movePipes() {
        if (pipe.getTranslateX() > -150) {
            pipe.setTranslateX(pipe.getTranslateX() - PIPE_SPEED);
        } else {
            pipeObject.setTopPipeLength();
            pipe.setTranslateX(600);
            scoreValid = true;
        }
    }

    private void checkCollisions() {
        if (pipe.getTranslateX() >= 118 && pipe.getTranslateX() <= 182) {
            if (bird.getTranslateY() < pipeObject.getTopPipeLength() ||
                bird.getTranslateY() > pipeObject.getTopPipeLength() + 200) {

                System.out.println("Game Over");
                System.exit(0);
            }
        }
    }

    private void checkScore() {
        if (bird.getTranslateX() > pipe.getTranslateX() && scoreValid) {
            score++;
            scoreValid = false;
            scoreText.setText(Integer.toString(score));
        }
    }
}