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


public class Main extends Application {

    GridPane gridPane;
    Grid grid;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TetrisAI");


        grid = new Grid(10,20);
        LPiece l = new LPiece();
        grid.insertBlock(l);

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        updateGridPane();

        Scene scene = new Scene(gridPane, 300, 450);

        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e->keyPressHandler(e));
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

    public static void main(String[] args) {
        launch(args);
    }
}
