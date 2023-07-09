package services.GamePlayingStrategy;

import models.Board;
import models.Jump;
import models.Move;
import models.Player;

import java.util.Objects;
import java.util.logging.Logger;

public class ForwardPlayingGameStrategy implements GamePlayingStrategy{

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Move makeMove(int diceResult, Board board, Player player) {
        int newPlayerPosition = player.getPosition() + diceResult;
        Jump snake = board.getSnakes().get(newPlayerPosition);
        if(Objects.nonNull(snake)) {
            logger.info(String.format("*** Snake bite ***"));
            newPlayerPosition = snake.getEnd();
        }
        Jump ladder = board.getLadders().get(newPlayerPosition);
        if(Objects.nonNull(ladder)) {
            logger.info(String.format("*** Ladder jump ***"));
            newPlayerPosition = ladder.getEnd();
        }
        logger.info(String.format("Player id %s rolled %d moved to new postion %d from old position %d", player.getId(), diceResult, newPlayerPosition, player.getPosition()));
        Move move = new Move(new Jump(player.getPosition(), newPlayerPosition), player);
        player.setPosition(newPlayerPosition);
        return move;
    }
}
