package services.GamePlayingStrategy;

import models.Board;
import models.Move;
import models.Player;

public interface GamePlayingStrategy {
    public Move makeMove(int diceResult, Board board, Player player);
}
