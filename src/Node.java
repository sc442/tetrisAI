public class Node{

    private int matrix[][];
    private int heuristic;
    private int countFromLeft;

    public Node(int[][] m, int f){
        matrix = m;
        countFromLeft = f;
        heuristic = evaluateHeuristic();
    }

    private int evaluateHeuristic(){
        // TODO: Run through the matrix and evaluate its heuristic score
        return 0;
    }

    public int getHeuristic(){
        return heuristic;
    }

    public int getCountFromLeft(){
        return countFromLeft;
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
