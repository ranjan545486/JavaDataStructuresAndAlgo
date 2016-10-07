package tryingsomething.Games;

/**
 * Created by rmukherj on 10/1/16.
 */
class GameBoard {
    char[][] board;

    GameBoard(char[][] board){
        this.board = board;
    }

    int getNumRows(){
        return board.length;
    }

    int getNumCols(){
        return board[0].length;
    }
}
