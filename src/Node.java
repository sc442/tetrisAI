
/*******
 * Represents a possible next state that the AI considers for a particular Grid
 * When generated, contains a matrix of the possible move, the move's position from the leftmost column,
 * and the block's rotation before dropping.
 *
 * @Author Seung-Woo Choi
 */

public class Node{

    private int matrix[][];
    private double heuristic;
    private int countFromLeft;
    private int rotationState;

    public Node(int[][] m, int f, int state){
        matrix = m;
        countFromLeft = f;
        rotationState = state;
        heuristic = evaluateHeuristic();
    }

    private double evaluateHeuristic(){
        double heuristicScore =
                evaluateMaxHeight()
                +(10)*evaluateGaps()
                +evaluateBumpiness()
                -evaluateFullRows();     // Lower the heuristic, the better!

        return heuristicScore;
    }

    private int evaluateMaxHeight(){

        int maxheight = 0;

        for(int col = 0; col < matrix[0].length; col++){

            int height = matrix.length;

            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] != 0) break;
                height--;
            }
            maxheight = (height>maxheight)?height:maxheight;

        }
        return maxheight;
    }

    private int evaluateMinHeight(){
        int minheight = Integer.MAX_VALUE;

        for(int col = 0; col < matrix[0].length; col++){

            int height = matrix.length;

            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] != 0) break;
                height--;
            }
            minheight = (height<minheight)?height:minheight;

        }
        return minheight;
    }

    private int evaluateGaps(){
        int gaps = 0;

        for(int col = 0; col < matrix[0].length; col++){
            boolean encountered = false;
            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] != 0) encountered = true;
                if(encountered && matrix[row][col] == 0) gaps++;
            }
        }
        return gaps;
    }

    private int evaluateFullRows(){
        int fullrows = 0;

        for(int row = 0; row < matrix.length; row++){
            if(isFullRow(matrix[row])) {
                fullrows++;
            }
        }

        return fullrows;
    }

    private boolean isFullRow(int row[]){
        for(int i = 0; i < row.length; i++){
            if(row[i] == 0) return false;
        }

        return true;
    }

    private int evaluateBumpiness(){
        int height = matrix.length;
        int h[] = {height, height, height, height, height,
                height, height, height ,height, height};
        for(int col = 0; col < matrix[0].length; col++){
            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] != 0) break;
                h[col]--;
            }
        }

        int bumpiness = Math.abs(h[0] - h[1])+
                Math.abs(h[1] - h[2]) +
                Math.abs(h[2] - h[3]) +
                Math.abs(h[3] - h[4]) +
                Math.abs(h[4] - h[5]) +
                Math.abs(h[5] - h[6]) +
                Math.abs(h[6] - h[7]) +
                Math.abs(h[7] - h[8]) +
                Math.abs(h[8] - h[9]);

        //TODO: Implement bumpiness
        return bumpiness;
    }

    public double getHeuristic(){
        return heuristic;
    }

    public int getCountFromLeft(){
        return countFromLeft;
    }

    public int getRotationState(){
        return rotationState;
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
