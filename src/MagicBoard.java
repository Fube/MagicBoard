public class MagicBoard {

    private int[][] board;
    private int[][][] beenHere;

    private int currX, currY;
    private int dim;

    MagicBoard(int dimension, int startX, int startY){
        board = new int[dimension][dimension];
        currX = startX;
        currY = startY;
        dim = dimension;
        beenHere = new int [dim][dim][4];
        populate();
    }

    boolean move(int len, int dir){

        int tempX = currX, tempY = currY;

        if(beenHere[currY][currX][dir] != -1)
            return false;

        beenHere[currY][currX][dir] = dir;

        switch(dir){
            case 0:
                tempY += len;
                break;
            case 1:
                tempX += len;
                break;
            case 2:
                tempY -= len;
                break;
            case 3:
                tempX -= len;
                break;
            default:break;
        }

        if(tempX >= dim || tempY >= dim || tempX < 0 || tempY < 0){
            return false;
        }
        currY = tempY;
        currX = tempX;
        return true;
    }

    private int rng(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    private void populate(){

        int zeroX = rng(0, dim-1);
        int zeroY = rng(0, dim-1);
        board[zeroY][zeroX] = 0;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {

                if(i == zeroY && j == zeroX) continue;

                final int CURR_NUM = rng(1, dim-1);
                board[i][j] = CURR_NUM;

                for (int k = 0; k < 4; k++) {
                    beenHere[i][j][k] = -1;
                }
            }
        }
    }

    int pos(int x, int y){
        return board[y][x];
    }

    @Override
    public String toString(){

        StringBuilder toRet = new StringBuilder();

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {

                toRet.append("\t").append(board[i][j]);
            }
            toRet.append("\n");
        }
        return toRet.toString();
    }

    public int getCurrX() {
        return currX;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public int getCurrY() {
        return currY;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }
}
