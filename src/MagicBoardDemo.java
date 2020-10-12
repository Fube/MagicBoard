public class MagicBoardDemo {

    static boolean recurSolve(MagicBoard board, int currX, int currY){

        final int LEN = board.pos(currX, currY);

        if(LEN == 0)
            return true;

        for (int i = 0; i < 4; i++) {

            boolean isValidMove = board.move(LEN, i);

            if(isValidMove){
                if(recurSolve(board, board.getCurrX(), board.getCurrY()))
                    return true;
            }
        }

        board.setCurrX(currX);
        board.setCurrY(currY);
        return false;
    }

    public static void main(String ...args){


        for (int i = 0; i < 20; i++) {
            MagicBoard board = new MagicBoard(10, 0, 0);
            System.out.println(board);
            System.out.println(recurSolve(board, 0, 0));
        }
    }
}
