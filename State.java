
/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.RED;
    private String redName = "";
    private int count;
    private String yellowName = "";
    private int[][] board = new int[Constants.BOARD_ROW_SIZE][Constants.BOARD_COL_SIZE];

    public boolean isWinner(int color) {
        if (checkHorizontal(color) || checkVertical(color) || checkDiagonal(color)) {
            return true;
        }
        return false;
    }

    public boolean checkHorizontal(int color) {
        for (int row = Constants.BOARD_ROW_SIZE - 1; row >= 0; row--) {
            count = 0;
            for (int col = 0; col <= Constants.BOARD_COL_SIZE -1; col++) {
                if (board[row][col] == color) count++;
                else if (board[row][col] == Constants.BLANK) ;
                else count = 0;
            }
            if (count == 4) return true;
        }
        return false;
    }

    public boolean checkVertical(int color) {
        for (int col = 0; col <= Constants.BOARD_COL_SIZE -1; col++) {
            count = 0;
            for (int row = Constants.BOARD_ROW_SIZE - 1; row >= 0; row--) {
                if (board[row][col] == color) count++;
                else if (board[row][col] == Constants.BLANK);
                else count = 0;
            }
            if (count == 4) return true;
        }
        return false;
    }

    public boolean checkDiagonal (int color) {
        for (int row = Constants.BOARD_ROW_SIZE - 1; row >= 0; row--) {
            for (int col = 0; col <= Constants.BOARD_COL_SIZE - 1; col++ ) {
                //left
                count = 0;
                int checkRow = row;
                int checkCol = col;
                while (checkRow >= 0 && checkCol >= 0) {
                    if (board[checkRow][checkCol] == color) {
                        count++;
                    } else {
                        count = 0;
                    }
                    checkRow--;
                    checkCol--;
                    if (count == 4) return true;
                }
                //right
                count = 0;
                checkRow = row;
                checkCol = col;
                while (checkRow >= 0 && checkCol <= Constants.BOARD_COL_SIZE - 1) {
                    if (board[checkRow][checkCol] == color) {
                        count++;
                    }else {
                        count = 0;
                    }
                    checkRow--;
                    checkCol++;
                    if (count == 4) return true;
                }
            }
        }
        return false;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getRedName() {
        return redName;
    }

    public void setRedName(String redName) {
        this.redName = redName;
    }

    public String getYellowName() {
        return yellowName;
    }

    public void setYellowName(String yellowName) {
        this.yellowName = yellowName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public void dropDisk (int value, int col) {
        for (int row = Constants.BOARD_ROW_SIZE-1; row >= 0; row--) {
            if (board[row][col] == Constants.BLANK) {
                setBoardCell(row, col, value);
                break;
            }
        }
    }

}
