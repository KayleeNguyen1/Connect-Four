
public class EventLoop
{
    State state = new State();
    UI ui = new UI();
    int row = 0;
    int col = 0;

    public void eventLoop() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                state.setGameState(Constants.GET_RED_NAME);

            } else if (gameState == Constants.GET_RED_NAME) {
                state.setRedName(ui.promptForName(Constants.RED)); // remember to ask Vernon abt how to do this
                state.setGameState(Constants.GET_YELLOW_NAME);

            } else if (gameState == Constants.GET_YELLOW_NAME) {
                state.setYellowName(ui.promptForName(Constants.YELLOW));
                state.setGameState(Constants.GET_RED_MOVE);
                ui.printBoard(state);
            } else if (gameState == Constants.GET_RED_MOVE) {
                col = ui.getMoveCol(state.getWhoseMove(), state) - 1;

                if (ui.isLegalMove(state, col)) {
                    state.setGameState(Constants.MAKE_MOVE);
                }
            } else if (gameState == Constants.GET_YELLOW_MOVE) {
                col = ui.getMoveCol(state.getWhoseMove(), state) - 1;
                if (ui.isLegalMove(state, col)) {
                    state.setGameState(Constants.MAKE_MOVE);
                }
            } else if (gameState == Constants.MAKE_MOVE) {
                ui.printMove(state, col+1);
                System.out.println("");
                state.dropDisk(state.getWhoseMove(), col);
                ui.printBoard(state);
                state.setGameState(Constants.CHECK_IF_WINNER);

            } else if (gameState == Constants.CHECK_IF_WINNER) {
                if (state.isWinner(state.getWhoseMove())) {
                    if (state.getWhoseMove() == Constants.RED) {
                        state.setGameState(Constants.RED_WINS);
                    } else {
                        state.setGameState(Constants.YELLOW_WINS);
                    }
                } else {
                    state.setWhoseMove(state.getWhoseMove() * -1);
                    if (state.getWhoseMove() == Constants.RED) {
                        state.setGameState(Constants.GET_RED_MOVE);
                    } else {
                        state.setGameState(Constants.GET_YELLOW_MOVE);
                    }
                }
            } else if (gameState == Constants.RED_WINS) {
                ui.printWinner(state);
                state.setGameState(Constants.GAME_OVER);

            } else if (gameState == Constants.YELLOW_WINS) {
                ui.printWinner(state);
                state.setGameState(Constants.GAME_OVER);
            } else if (gameState == Constants.GAME_OVER) {
                if (ui.startNewGame()) {
                    state.setGameState(Constants.STANDBY);
                    state = new State();
                } else {
                    state.setGameState(Constants.QUIT_PROGRAM);
                }
            }
        }
    }

    public static void main(String[] args) {
        EventLoop run = new EventLoop();
        run.eventLoop();
    }
}
