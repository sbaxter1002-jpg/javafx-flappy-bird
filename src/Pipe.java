import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Group;
public class Pipe {
    private int topPipeLength = (int)(Math.random() * (400-75))+ 75;
    Group pipes = new Group();
    Rectangle topPipe = new Rectangle();
    Rectangle topPipeHead = new Rectangle();
    Rectangle bottomPipe = new Rectangle();
    Rectangle bottomPipeHead = new Rectangle();

    static final int PIPE_WIDTH = 100;
    static final int PIPE_HEAD_WIDTH = 150;
    static final int PIPE_HEAD_HEIGHT = 50;

    public Group pipe() {
        topPipe.setWidth(PIPE_WIDTH);
        topPipe.setHeight(topPipeLength);
        topPipe.setFill(Color.GREEN);
        topPipe.setStrokeType(StrokeType.OUTSIDE);
        topPipe.setStroke(Color.DARKGREEN);
        topPipe.setStrokeWidth(10);
        
                
           
        topPipeHead.setWidth(PIPE_HEAD_WIDTH);
        topPipeHead.setHeight(PIPE_HEAD_HEIGHT);
        topPipeHead.setLayoutX(-25);
        topPipeHead.setLayoutY(topPipeLength-50);
        topPipeHead.setFill(Color.GREEN);
        topPipeHead.setStrokeType(StrokeType.OUTSIDE);
        topPipeHead.setStroke(Color.DARKGREEN);
        topPipeHead.setStrokeWidth(10);
        
                
        bottomPipe.setLayoutY(topPipeLength+200);
        bottomPipe.setWidth(PIPE_WIDTH);
        bottomPipe.setHeight(800-160-topPipeLength-200);
        bottomPipe.setFill(Color.GREEN);
        bottomPipe.setStrokeType(StrokeType.OUTSIDE);
        bottomPipe.setStroke(Color.DARKGREEN);
        bottomPipe.setStrokeWidth(10);

        bottomPipeHead.setLayoutY(topPipeLength+200);
        bottomPipeHead.setLayoutX(-25);
        bottomPipeHead.setWidth(PIPE_HEAD_WIDTH);
        bottomPipeHead.setHeight(PIPE_HEAD_HEIGHT);
        bottomPipeHead.setFill(Color.GREEN);
        bottomPipeHead.setStrokeType(StrokeType.OUTSIDE);
        bottomPipeHead.setStroke(Color.DARKGREEN);
        bottomPipeHead.setStrokeWidth(10);

        pipes.getChildren().addAll(topPipe, bottomPipe, topPipeHead, bottomPipeHead);

        return pipes;
    }
    
    public void setTopPipeLength() {
        topPipeLength = (int)(Math.random() * (400-75)) + 75;
        System.out.println(topPipeLength);
        topPipe.setHeight(topPipeLength);
        topPipeHead.setLayoutY(topPipeLength-50);
        bottomPipe.setLayoutY(topPipeLength+200);
        bottomPipe.setHeight(800-160-topPipeLength-200);
        bottomPipeHead.setLayoutY(topPipeLength+200);
    }

    public int getTopPipeLength() {
        return topPipeLength;
    }


}