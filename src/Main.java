import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Blocks.*;
import javafx.util.Duration;

import java.util.*;

/*******************
 * Game player and front end display
 *
 * @Author Seung-Woo Choi 2019
 */

public class Main extends Application {

    private static final int MILLISECOND_DELAY = 200;

    private static final int COLUMN_COUNT = 10;
    private static final int ROW_COUNT = 20;


    GridPane gridPane;
    Grid grid;
    Bag bag;

    @Override
    public void start(Stage primaryStage) throws Exception{
        setUp(primaryStage);
        initiateGame();
        autoplayGame();
    }

    private void autoplayGame() {
        var frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step());
        var animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void setUp(Stage primaryStage){
        primaryStage.setTitle("TetrisAI");


        grid = new Grid(ROW_COUNT,COLUMN_COUNT);

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        bag = new Bag();

        Scene scene = new Scene(gridPane, 300, 450);

        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e->keyPressHandler(e));
    }

    private void initiateGame(){                // For now, gets a random piece and inserts it into grid
        Block block = getRandomPiece();
        grid.insertBlock(block);
        updateGridPane();
    }

    private void step(){

        if(!grid.isDead()) {
            List<Node> nodes = grid.generateNodes();            /* TODO: Clean up gameplay code process
                                                                    it looks awful rn */

            grid.playBestMove(nodes);
            updateGridPane();
            Block b = getRandomPiece();
            grid.insertBlock(b);
            updateGridPane();
        }
    }

    private void keyPressHandler(KeyEvent e) {
        if(e.getCode() == KeyCode.RIGHT){
            grid.moveRight();
            updateGridPane();
        }
        if(e.getCode() == KeyCode.LEFT){
            grid.moveLeft();
            updateGridPane();
        }
        if(e.getCode() == KeyCode.SPACE){
            grid.hardDrop();
            updateGridPane();
            initiateGame();
        }
        if(e.getCode() == KeyCode.Z){
            grid.rotateCCW();
            updateGridPane();
        }
        if(e.getCode() == KeyCode.X){
            grid.rotateCW();
            updateGridPane();
        }

    }

    private void updateGridPane() {
        int array[][] = grid.getMatrix();

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                Rectangle rec;

                switch(array[i][j]){
                    case 1:
                        // IPiece
                        rec = new Rectangle(20,20, Color.DEEPSKYBLUE);
                        break;
                    case 2:
                        // JPiece
                        rec = new Rectangle(20,20, Color.ROYALBLUE);
                        break;
                    case 3:
                        // LPiece
                        rec = new Rectangle(20,20, Color.DARKORANGE);
                        break;
                    case 4:
                        // OPiece
                        rec = new Rectangle(20,20, Color.YELLOW);
                        break;
                    case 5:
                        // SPiece
                        rec = new Rectangle(20,20, Color.LIMEGREEN);
                        break;
                    case 6:
                        // TPiece
                        rec = new Rectangle(20,20, Color.VIOLET);
                        break;
                    case 7:
                        // ZPiece
                        rec = new Rectangle(20,20, Color.RED);
                        break;
                    default:
                        // Empty
                        rec = new Rectangle(20,20,Color.LIGHTGREY);
                        break;
                }

                gridPane.add(rec, j, i);
            }
        }
    }

    private Block getRandomPiece(){
        return bag.getBlock();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
