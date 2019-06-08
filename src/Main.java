import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Blocks.*;

import java.util.Random;


public class Main extends Application {

    GridPane gridPane;
    Grid grid;

    @Override
    public void start(Stage primaryStage) throws Exception{
        setUp(primaryStage);
        playGame();
    }

    private void setUp(Stage primaryStage){
        primaryStage.setTitle("TetrisAI");


        grid = new Grid(10,20);

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        Scene scene = new Scene(gridPane, 300, 450);

        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e->keyPressHandler(e));
    }

    private void playGame(){                // For now, gets a random piece and inserts it into grid
        Block block = getRandomPiece();
        grid.insertBlock(block);
        updateGridPane();
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
            playGame();
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
                if(array[i][j] == 1) rec = new Rectangle(20,20, Color.GREEN);
                else rec = new Rectangle(20,20,Color.LIGHTGRAY);
                gridPane.add(rec, j, i);
            }
        }
    }

    private Block getRandomPiece(){
        Random rand = new Random();
        int randomNum = rand.nextInt(7);

        switch(randomNum){
            case 0:
                return new IPiece();
            case 1:
                return new JPiece();
            case 2:
                return new LPiece();
            case 3:
                return new OPiece();
            case 4:
                return new SPiece();
            case 5:
                return new TPiece();
            case 6:
                return new ZPiece();
            default:
                return new TPiece();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
