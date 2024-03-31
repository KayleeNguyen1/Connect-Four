import java.util.Scanner;

public class UI
{
    
    Scanner scanner;
    
    /**
     * Constructor for objects of class UI
     */
    public UI()
    {
        scanner = new Scanner(System.in);
    }

    public String getRedOrYellow(int whoseMove) {
        if (whoseMove == 0) return " ";
        return (whoseMove == -1) ? "R" : "Y";
    }
    
    public String getPlayerName(int whoseMove, String redName, String yellowName) {
        return (whoseMove == -1) ? redName : yellowName;
    }
    
    public boolean isLegalMove(State board, int col) {
        int row = Constants.BOARD_ROW_SIZE-1;
        while (row >= 0) {
            if (board.getBoardCell(row,col) == 0) {
                break;
            }
            row--;
        }
        return row >= 0 && board.getBoardCell(row, col) == Constants.BLANK;
    }
    
    public String promptForName(int player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }
    
    public int getMoveCol(int whoseMove, State board) {
        int col = -1;
        while (col <= 0 || col >= 8) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getRedOrYellow(whoseMove), getPlayerName(whoseMove, board.getRedName(), board.getYellowName()));
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COLUMN);
            }
        }
        return col;
    }
    
    public boolean startNewGame() {
        System.out.println("\n" + Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.contains("Y");
    }
    
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }
    
    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row <= Constants.BOARD_ROW_SIZE -1; row++) {
            for (int col = 0; col <= Constants.BOARD_COL_SIZE-1; col++) {
                System.out.printf(Constants.BOARD_STRING, getRedOrYellow(state.getBoardCell(row, col)));  
            }
            System.out.println("|");
            System.out.println(Constants.DIVIDER_STRING);
        }
    }
    
    public void printInvalidColumn(int col) {
        System.out.printf(Constants.INVALID_COLUMN, col);
    }
    
    public void printInvalidMove(int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, col);
    }
    
    public void printMove(State state, int col) {
        System.out.printf(Constants.PRINT_MOVE, getRedOrYellow(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getRedName(), state.getYellowName()), col);
    }
    
    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getRedOrYellow(state.getWhoseMove()),getPlayerName(state.getWhoseMove(), state.getRedName(), state.getYellowName()));
    }
}
