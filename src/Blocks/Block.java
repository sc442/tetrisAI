package Blocks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {

    protected ArrayList<Pair<Integer,Integer>> squares;
    protected int state;
    protected int cc;   // Current Column

    public static final int STARTING_COLUMN = 4;

    public Block(){
        state = 0;
        cc = STARTING_COLUMN;
    }

    abstract void updateSquares();

    public void moveLeft(){
        cc--;
        updateSquares();
    }

    public void moveRight(){
        cc++;
        updateSquares();
    }

    public void rotateCW(){
        if(state == 3) state = 0;
        else state++;

        updateSquares();
    }

    public void rotateCCW(){
        if(state == 0) state = 3;
        else state--;

        updateSquares();
    }

    public List<Pair<Integer,Integer>> getSquares(){
        return squares;
    }
}
