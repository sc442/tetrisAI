import Blocks.*;

public class Player {

    public static void main(String[] args) {
        Grid grid = new Grid(10,20);

        LPiece l = new LPiece();

        grid.insertBlock(l);

        grid.printGrid();

        grid.moveRight();

        System.out.println();

        grid.printGrid();

        grid.moveLeft();

        System.out.println();

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
