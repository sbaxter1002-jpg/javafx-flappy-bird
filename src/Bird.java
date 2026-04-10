import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Group;
public class Bird {
    public Group bird() {
        Group bird = new Group();

        Circle body = new Circle();
        body.setCenterX(0);
        body.setCenterY(0);
        body.setRadius(20.0f);
        body.setFill(Color.YELLOW);
        body.setStroke(Color.BLACK);
        body.setStrokeType(StrokeType.OUTSIDE);
        body.setStrokeWidth(4.0f);

        Polygon beak = new Polygon();
        beak.getPoints().addAll(new Double[]{
            18.0, 5.0,
            18.0, -5.0,
            35.0, 0.0,
        });
        beak.setFill(Color.ORANGE);
        beak.setStroke(Color.BLACK);
        beak.setStrokeType(StrokeType.OUTSIDE);
        beak.setStrokeWidth(2.0f);

        Circle eye = new Circle();
        eye.setCenterX(10.0f);
        eye.setCenterY(-10.0f);
        eye.setRadius(4.0f);
        eye.setFill(Color.WHITE);
        eye.setStroke(Color.BLACK);
        eye.setStrokeType(StrokeType.OUTSIDE);
        eye.setStrokeWidth(2.0f);

        Circle pupil = new Circle();
        pupil.setCenterX(12.0f);
        pupil.setCenterY(-10.0f);
        pupil.setRadius(2.0f);
        pupil.setFill(Color.BLACK);

        Arc wing = new Arc();
        wing.setCenterX(-2.0f);
        wing.setCenterY(-2.0f);
        wing.setRadiusX(15.0f);
        wing.setRadiusY(15.0f);
        wing.setStartAngle(200.0f);
        wing.setLength(35.0f);
        wing.setFill(Color.YELLOW);
        wing.setType(ArcType.ROUND);
        wing.setStroke(Color.BLACK);
        wing.setStrokeType(StrokeType.OUTSIDE);
        wing.setStrokeWidth(2.0f);

        bird.getChildren().addAll(body, beak, eye, pupil, wing);
        return bird;
    }
}
