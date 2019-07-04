public class Node{

    private int matrix[][];
    private int heuristic;
    private int countFromLeft;
    private int rotationState;

    public Node(int[][] m, int f, int state){
        matrix = m;
        countFromLeft = f;
        rotationState = state;
        heuristic = evaluateHeuristic();
    }

    private int evaluateHeuristic(){
        int heuristicScore =
                evaluateHeight()+
                evaluateGaps()+
                evaluateBumpiness();     // Lower the heuristic, the better!

        return heuristicScore;
    }

    private int evaluateHeight(){

        int maxheight = 0;

        for(int col = 0; col < matrix[0].length; col++){

            int height = matrix.length;

            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] == 1) break;
                height--;
            }
            maxheight = (height>maxheight)?height:maxheight;

        }
        //TODO: Adjust points
        return maxheight;
    }

    private int evaluateGaps(){
        int gaps = 0;

        for(int col = 0; col < matrix[0].length; col++){
            boolean encountered = false;
            for(int row = 0; row < matrix.length; row++){
                if(matrix[row][col] == 1) encountered = true;
                if(encountered && matrix[row][col] == 0) gaps++;
            }
        }
        //TODO: Evaluate gaps
        return gaps;
    }

    private int evaluateBumpiness(){
        int bumpiness = 0;
        //TODO: Evaluate bumpiness
        return bumpiness;
    }

    public int getHeuristic(){
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
