package Blocks;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;

public class JPiece extends Block {

    public JPiece(){
        super();
        updateSquares();
    }

    @Override
    public void updateSquares() {
        Pair<Integer, Integer> sq1;
        Pair<Integer, Integer> sq2;
        Pair<Integer, Integer> sq3;
        Pair<Integer, Integer> sq4;
        switch(state){
            case 0:
                sq1 = new Pair<>(0,cc);
                sq2 = new Pair<>(1,cc);
                sq3 = new Pair<>(1,cc+1);
                sq4 = new Pair<>(1,cc+2);
                squares = new ArrayList<>(Arrays.asList(sq1,sq2,sq3,sq4));
                break;
            case 1:
                sq1 = new Pair<>(0,cc+1);
                sq2 = new Pair<>(1,cc+1);
                sq3 = new Pair<>(2,cc+1);
                sq4 = new Pair<>(0,cc+2);
                squares = new ArrayList<>(Arrays.asList(sq1,sq2,sq3,sq4));
                break;
            case 2:
                sq1 = new Pair<>(1,cc);
                sq2 = new Pair<>(1,cc+1);
                sq3 = new Pair<>(1,cc+2);
                sq4 = new Pair<>(2,cc+2);
                squares = new ArrayList<>(Arrays.asList(sq1,sq2,sq3,sq4));
                break;
            case 3:
                sq1 = new Pair<>(0,cc+1);
                sq2 = new Pair<>(1,cc+1);
                sq3 = new Pair<>(2,cc+1);
                sq4 = new Pair<>(2,cc);
                squares = new ArrayList<>(Arrays.asList(sq1,sq2,sq3,sq4));
                break;
        }
    }


}
