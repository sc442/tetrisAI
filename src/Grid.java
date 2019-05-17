import Blocks.Block;

public class Grid {

    private int matrix[][];
    private int blockColumn = 0;
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

    public void insertBlock(Block b){
        activeBlock = b;
        blockColumn = 0;

        int blockarray[][] = b.returnBlockArray();

        for(int i = 0; i < blockarray.length; i++){
            for(int j = 0; j < blockarray[0].length; j++){
                matrix[i][j] = blockarray[i][j];
            }
        }
    }

    public void moveLeft(){
        int blockarray[][] = activeBlock.returnBlockArray();

        for(int i = 0; i < blockarray.length; i++){
            for(int j = 0; j < blockarray[0].length; j++){
                matrix[i][j + blockColumn] = 0;
            }
        }

        blockColumn--;

        for(int i = 0; i < blockarray.length; i++){
            for(int j = 0; j < blockarray[0].length; j++){
                matrix[i][j + blockColumn] = blockarray[i][j];
            }
        }
    }

    public void moveRight(){
        int blockarray[][] = activeBlock.returnBlockArray();

        for(int i = 0; i < blockarray.length; i++){
            for(int j = 0; j < blockarray[0].length; j++){
                matrix[i][j + blockColumn] = 0;
            }
        }

        blockColumn++;

        for(int i = 0; i < blockarray.length; i++){
            for(int j = 0; j < blockarray[0].length; j++){
                matrix[i][j + blockColumn] = blockarray[i][j];
            }
        }
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
