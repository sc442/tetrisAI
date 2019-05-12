package Blocks;

public abstract class Block {

    protected int piece[][];

    public void rotateCW(){
        int n = piece.length;
        int rotated[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotated[i][j] = piece[n-j-1][i];
            }
        }

        piece = rotated;
    }

    public void rotateCCW(){
        int n = piece.length;
        int rotated[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotated[i][j] = piece[j][n-i-1];
            }
        }

        piece = rotated;
    }

    public int[][] returnBlock() {
        return piece;
    }

    public void printBlock(){
        for(int i = 0; i < piece.length; i++){
            for(int j = 0; j < piece[i].length; j++){
                System.out.print(piece[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }
}
