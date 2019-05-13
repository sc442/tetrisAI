import Blocks.*;

public class Player {

    public static void main(String[] args) {
        Grid grid = new Grid(10,20);

        OPiece l = new OPiece();

        l.printBlock();

        l.rotateCW();
        System.out.println();
        l.printBlock();

        l.rotateCW();
        System.out.println();
        l.printBlock();

        l.rotateCW();
        System.out.println();
        l.printBlock();
    }
}
