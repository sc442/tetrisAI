public class Grid {

    private char matrix[][];

    public Grid(int r, int c){
        matrix = initializeMatrix(r,c);

    }

    private char[][] initializeMatrix(int r, int c){
        char returnmatrix[][] = new char[c][r];

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                returnmatrix[i][j] = '-';
            }
        }

        return returnmatrix;
    }

    public void printGrid(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }
}
