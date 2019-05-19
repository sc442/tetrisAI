import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        int array[][] = grid.getMatrix();

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                Rectangle rec;
                if(array[i][j] == 1) rec = new Rectangle(20,20,Color.GREEN);
                else rec = new Rectangle(20,20,Color.LIGHTGRAY);
                gridPane.add(rec, j, i);
            }
        }

        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
