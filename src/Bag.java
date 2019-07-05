import Blocks.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bag {
    List pieces;
    int currentLocation;

    public Bag(){
        currentLocation = 0;

        pieces = Arrays.asList(0,1,2,3,4,5,6);
        Collections.shuffle(pieces);
    }

    public Block getBlock(){
        int b = (int)pieces.get(currentLocation);

        currentLocation++;

        if(currentLocation > 6){
            currentLocation = 0;
            Collections.shuffle(pieces);
        }

        switch(b){
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
}
