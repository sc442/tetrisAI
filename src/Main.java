import Blocks.*;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(10,20);

        SPiece l = new SPiece();

        l.printBlock();
        l.rotateCW();
        System.out.println();
        l.printBlock();

        l.rotateCCW();
        System.out.println();
        l.printBlock();

    }
}
