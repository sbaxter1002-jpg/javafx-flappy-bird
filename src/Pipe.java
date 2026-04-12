import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Group;
import java.util.Random;
public class Pipe {
    public Group pipe() {
        Group pipes = new Group();

        int topPipeLength = (int)(Math.random() * 500);

        Rectangle topPipe = new Rectangle();
        topPipe.setWidth(100);
        topPipe.setHeight(topPipeLength);
        topPipe.setFill(Color.GREEN);
        topPipe.setStrokeType(StrokeType.OUTSIDE);
        topPipe.setStroke(Color.DARKGREEN);
        topPipe.setStrokeWidth(10);

        Rectangle topPipeHead = new Rectangle();
        topPipeHead.setWidth(150);
        topPipeHead.setHeight(50);
        topPipeHead.setLayoutX(-25);
        topPipeHead.setLayoutY(topPipeLength-50);
        topPipeHead.setFill(Color.GREEN);
        topPipeHead.setStrokeType(StrokeType.OUTSIDE);
        topPipeHead.setStroke(Color.DARKGREEN);
        topPipeHead.setStrokeWidth(10);

        Rectangle bottomPipe = new Rectangle();
        bottomPipe.setLayoutY(topPipeLength+200);
        bottomPipe.setWidth(100);
        bottomPipe.setHeight(800-160-topPipeLength-200);
        bottomPipe.setFill(Color.GREEN);
        bottomPipe.setStrokeType(StrokeType.OUTSIDE);
        bottomPipe.setStroke(Color.DARKGREEN);
        bottomPipe.setStrokeWidth(10);

        Rectangle bottomPipeHead = new Rectangle();
        bottomPipeHead.setLayoutY(topPipeLength+200);
        bottomPipeHead.setLayoutX(-25);
        bottomPipeHead.setWidth(150);
        bottomPipeHead.setHeight(50);
        bottomPipeHead.setFill(Color.GREEN);
        bottomPipeHead.setStrokeType(StrokeType.OUTSIDE);
        bottomPipeHead.setStroke(Color.DARKGREEN);
        bottomPipeHead.setStrokeWidth(10);

        pipes.getChildren().addAll(topPipe, bottomPipe, topPipeHead, bottomPipeHead);

        return pipes;
    }
}
