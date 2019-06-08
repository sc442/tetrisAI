import Blocks.Block;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

    private static final int BIGNUM = 99999;

    private int matrix[][];
    private Block activeBlock;


    public Grid(int r, int c){
        matrix = initializeMatrix(r,c);

    }

    private int[][] initializeMatrix(int r, int c){
        int returnmatrix[][] = new int[c][r];

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                returnmatrix[i][j] = 0;
            }
        }

        return returnmatrix;
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public void insertBlock(Block b){
        activeBlock = b;

        updateMatrix();

    }

    public void moveLeft(){
        clearBlockFromMatrix();
        activeBlock.moveLeft();
        updateMatrix();
    }

    public void moveRight(){
        clearBlockFromMatrix();
        activeBlock.moveRight();
        updateMatrix();
    }

    public void rotateCW(){
        clearBlockFromMatrix();
        activeBlock.rotateCW();
        updateMatrix();
    }

    public void rotateCCW(){
        clearBlockFromMatrix();
        activeBlock.rotateCCW();
        updateMatrix();
    }

    private void clearBlockFromMatrix(){
        ArrayList<Pair<Integer,Integer>> squares = (ArrayList)activeBlock.getSquares();
        for(Pair<Integer,Integer> p: squares){
            int x = p.getKey();
            int y = p.getValue();

            matrix[x][y] = 0;
        }
    }

    private void updateMatrix(){
        ArrayList<Pair<Integer,Integer>> squares = (ArrayList)activeBlock.getSquares();

        System.out.println("Grid before putting in squares");
        printGrid();

        System.out.println("Square count: " + squares.size());
        for(Pair<Integer,Integer> p: squares){
            int x = p.getKey();
            int y = p.getValue();

            matrix[x][y] = 1;
        }
        System.out.println("Grid after putting in squares");
        printGrid();
        List<Integer> filledRows = getFilledRows();
        if(filledRows.size() != 0) clearFilledRows(filledRows);
    }

    private List<Integer> getFilledRows(){
        ArrayList<Integer> rowsToClear = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            int squares = 0;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1) squares++;
            }
            if(squares == matrix[0].length) rowsToClear.add(i);
        }

        return rowsToClear;
    }

    private void clearFilledRows(List<Integer> rows){
        for(int r: rows){
            for(int i = r; i > 0; i--){
                matrix[i] = Arrays.copyOf(matrix[i-1], matrix[i-1].length);
            }
        }
    }

    public void hardDrop(){
        // For each column that block is in to column that it ends
        // Count the difference between the block and the lowest possible point
        // Shift block down by the lowest possible distance

        ArrayList<Pair<Integer, Integer>> squares = (ArrayList)activeBlock.getSquares();

        int shortestDistance = BIGNUM;

        for(Pair<Integer, Integer> b: squares){
            int r = b.getKey();
            int c = b.getValue();

            int distance = 0;

            for(int i = r+1; i < matrix.length; i++, distance++){
                if(matrix[i][c] == 1 && !squares.contains(new Pair<>(i,c))) break;
            }
            if(distance < shortestDistance) shortestDistance = distance;
        }
        clearBlockFromMatrix();
        activeBlock.drop(shortestDistance);
        updateMatrix();
    }

    public void printGrid(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.printf("\n");
        }

        System.out.println();
    }

}
