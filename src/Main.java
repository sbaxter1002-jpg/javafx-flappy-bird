import javafx.application.*;
import javafx.collections.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;

/**
 * 
 * @author Stuart Baxter
 */
public class Main extends Application {

    public Group bird() {
        Group bird = new Group();

        Circle body = new Circle();
        body.setCenterX(150.0f);
        body.setCenterY(150.0f);
        body.setRadius(20.0f);
        body.setFill(Color.YELLOW);
        body.setStroke(Color.BLACK);
        body.setStrokeType(StrokeType.OUTSIDE);
        body.setStrokeWidth(4.0f);

        Polygon beak = new Polygon();
        beak.getPoints().addAll(new Double[]{
            168.0, 155.0,
            168.0, 145.0,
            185.0, 150.0,
        });
        beak.setFill(Color.ORANGE);
        beak.setStroke(Color.BLACK);
        beak.setStrokeType(StrokeType.OUTSIDE);
        beak.setStrokeWidth(2.0f);

        Circle eye = new Circle();
        eye.setCenterX(160.0f);
        eye.setCenterY(140.0f);
        eye.setRadius(4.0f);
        eye.setFill(Color.WHITE);
        eye.setStroke(Color.BLACK);
        eye.setStrokeType(StrokeType.OUTSIDE);
        eye.setStrokeWidth(2.0f);

        bird.getChildren().addAll(body, beak, eye);
        return bird;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Node> list;

        Group bird = bird();

        Group root = new Group();

        root.getChildren().addAll(bird);

        list = root.getChildren();
        System.out.println(list);

        Scene scene = new Scene(root, 600, 300);

        scene.setFill(Color.AQUA);

        stage.setTitle("Flappy Bird");
        stage.setScene(scene);
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
