package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Board {
    private final int boardSize;
    private final Map<Integer, Jump> snakes = new HashMap<>();
    private final Map<Integer, Jump> ladders = new HashMap<>();

    public Map<Integer, Jump> getSnakes() {
        return snakes;
    }

    public Map<Integer, Jump> getLadders() {
        return ladders;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Board(int rowCount, int columnCount, List<Jump> snakes, List<Jump> ladders) {
        int squareCount = rowCount * columnCount;
        if(snakes.stream().anyMatch(snake -> snake.getEnd() > squareCount || snake.getStart() > squareCount)
                || ladders.stream().anyMatch(ladder -> ladder.getEnd() > squareCount || ladder.getStart() > squareCount)) {
            throw new RuntimeException("Snakes and ladders should be within the board");
        }
        this.boardSize = squareCount;
        snakes.forEach(snake -> this.snakes.put(snake.getStart(), snake));
        ladders.forEach(ladder -> this.ladders.put(ladder.getStart(), ladder));
        Logger.getLogger("Board").info(snakes.toString());
        Logger.getLogger("Board").info(ladders.toString());
    }
}
