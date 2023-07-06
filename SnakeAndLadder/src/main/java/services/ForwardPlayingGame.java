package services;

import models.Jump;
import models.Player;

import java.util.Objects;

public class ForwardPlayingGame extends Game{

    public ForwardPlayingGame(int diceCount, int snakeCount, int ladderCount, int playerCount) {
        super(diceCount, snakeCount, ladderCount, playerCount);
    }

    @Override
    public Player makeMove(Player player) {
        int i = 0;
        int totalSteps = 0;
        while (i++ < getDiceCount()) {
            totalSteps += getDice().rollDice();
        }
        int newPlayerPosition = player.getPosition() + totalSteps;
        Jump snake = getBoard().getSnakes().get(newPlayerPosition);
        if(Objects.nonNull(snake)) {
            logger.info(String.format("*** Snake bite ***"));
            newPlayerPosition = snake.getEnd();
        }
        Jump ladder = getBoard().getLadders().get(newPlayerPosition);
        if(Objects.nonNull(ladder)) {
            logger.info(String.format("*** Ladder jump ***"));
            newPlayerPosition = ladder.getEnd();
        }
        logger.info(String.format("Player id %s rolled %d moved to new postion %d from old position %d", player.getId(), totalSteps, newPlayerPosition, player.getPosition()));
        player.setPosition(newPlayerPosition);
        return player;
    }
}
