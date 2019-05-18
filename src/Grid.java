import Blocks.Block;

public class Grid {

    private static final int BIGNUM = 99999;

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

    // TODO: Fix edge cases for when it reaches the end

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

    public void hardDrop(){
        // For each column that block is in to column that it ends
        // Count the difference between the block and the lowest point
        // Shift block down by the lowest possible distance

        int blockarray[][] = activeBlock.returnBlockArray();

        int shortestDistance = BIGNUM;         // Arbitrary large number

        for(int j = blockColumn; j < blockColumn + blockarray[0].length; j++){
            int tempDist = BIGNUM;
            int startcounting = 0;

            //start counting if one
            for(int i = 0; i < matrix.length; i++){
                if(startcounting == 0 && matrix[i][j] == 1) startcounting = 1;    // Dont count 0's til it sees a block
                if(startcounting == 1 && matrix[i][j] == 0) {
                    startcounting = 2;    // Start counting when it sees 0's again
                    tempDist = 0;
                }

                if(startcounting == 2 && matrix[i][j] == 0) tempDist++;

                if(startcounting == 2 && matrix[i][j] == 1) startcounting = 3;
                // Stop counting entirely when it sees a 1 again after counting 0's

            }
            if(tempDist < shortestDistance) shortestDistance = tempDist;
        }

        System.out.println(shortestDistance);
        // Take this shortestdistance and shift all the 1's down that many times.

        for(int j = blockColumn; j < blockColumn + blockarray[0].length; j++){
            for(int i = 0; i < blockarray.length; i++){
                if(matrix[i][j] == 1){
                    matrix[i + shortestDistance][j] = 1;
                    matrix[i][j] = 0;
                }
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

        System.out.println();
    }
}
