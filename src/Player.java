import Blocks.*;

public class Player {

    public static void main(String[] args) {
        Grid grid = new Grid(10,20);

        SPiece s = new SPiece();
        LPiece l = new LPiece();

        s.rotateCW();

        grid.insertBlock(s);

        grid.printGrid();

        grid.hardDrop();
        grid.printGrid();

        l.rotateCCW();
        grid.insertBlock(l);
        grid.printGrid();

        grid.moveRight();
        grid.printGrid();

        grid.moveRight();
        grid.printGrid();

        grid.hardDrop();
        grid.printGrid();

//        l.printBlock();
//
//        l.rotateCW();
//        System.out.println();
//        l.printBlock();
//
//        l.rotateCW();
//        System.out.println();
//        l.printBlock();
//
//        l.rotateCW();
//        System.out.println();
//        l.printBlock();
    }
}
