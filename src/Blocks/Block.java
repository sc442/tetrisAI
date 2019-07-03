package Blocks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {

    protected ArrayList<Pair<Integer,Integer>> squares;
    protected int state;
    protected int cc;   // Current Column
    protected int cr;   // Current row

    public static final int STARTING_COLUMN = 3;

    public static final int FIRST_COLUMN = 0;
    public static final int LAST_COLUMN = 9;

    public Block(){
        state = 0;
        cc = STARTING_COLUMN;
        cr = 0;
    }

    abstract void updateSquares();

    public boolean isLeftmost(){
        for(Pair<Integer,Integer> s: squares){
            if(s.getValue() == FIRST_COLUMN) return true;
        }
        return false;
    }

    public boolean isRightmost(){
        for(Pair<Integer,Integer> s: squares){
            if(s.getValue() == LAST_COLUMN) return true;
        }
        return false;
    }

    public void moveLeft(){
        if(!isLeftmost()) {
            cc--;
            updateSquares();
        }
    }

    public void moveRight(){
        if(!isRightmost()) {
            cc++;
            updateSquares();
        }
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

    public int getState(){
        return state;
    }

    public void drop(int i){
        cr = cr + i;

        updateSquares();
    }

    public List<Pair<Integer,Integer>> getSquares(){
        return squares;
    }
}
