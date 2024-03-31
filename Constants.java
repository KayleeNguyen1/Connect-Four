public class Constants {
    public static final int BOARD_COL_SIZE = 7;
    public static final int BOARD_ROW_SIZE = 6;
    
    public static final int RED = -1;
    public static final int YELLOW = 1;
    public static final int BLANK = 0;
    
    public static final int STANDBY = 0;
    public static final int GET_RED_NAME = 1;
    public static final int GET_YELLOW_NAME = 2;
    public static final int GET_RED_MOVE = 3;
    public static final int GET_YELLOW_MOVE = 4;
    public static final int MAKE_MOVE = 5;
    public static final int CHECK_IF_WINNER = 6;
    public static final int CHECK_IF_TIE = 7;
    public static final int RED_WINS = 8;
    public static final int YELLOW_WINS = 9;
    public static final int GAME_OVER = 10;
    public static final int QUIT_PROGRAM = 11;
    
    public static final String DIVIDER_STRING = "|---|---|---|---|---|---|---|";
    public static final String BOARD_STRING = "| %s ";
    public static final String GET_PLAYER_NAME = "Player %s: What is your name? ";
    public static final String TITLE = "Thanks for playing Connect Four!";
    public static final String GET_COL_MOVE = "Player %s (%s): Enter the column you want to drop the disk in.";
    public static final String INVALID_COLUMN = "Your column must be 1, 2, 3, 4, 5, 6, or 7.";
    public static final String INVALID_MOVE_ERROR = "Column %d is not a valid move. Please try again.";
    public static final String PRINT_MOVE = "Player %s(%s) dropped a disk at %d";
    public static final String WINNER = "%s - %s is the winner!";
    public static final String START_NEW_GAME = "Start a new game (Y or N)?";
}