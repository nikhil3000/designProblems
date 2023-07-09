package models;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;
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

    public Board(int rowCount, int columnCount, int snakeCount, int ladderCount) {
        this.boardSize = rowCount * columnCount;
        Set<Integer> visitedSquares = new HashSet<>();

        while(this.snakes.size() < snakeCount){
            int end = RandomUtils.nextInt(1, rowCount * columnCount - 1);
            int start = RandomUtils.nextInt(end + 1, rowCount * columnCount);

            if(visitedSquares.contains(start) || visitedSquares.contains(end)) {
                continue;
            }
            visitedSquares.add(start);
            visitedSquares.add(end);
            this.snakes.put(start, new Jump(start, end));
        }

        while(this.ladders.size() < ladderCount){
            int start = RandomUtils.nextInt(1, rowCount * columnCount - 1);
            int end = RandomUtils.nextInt(start + 1, rowCount * columnCount);
            if(visitedSquares.contains(start) || visitedSquares.contains(end)) {
                continue;
            }
            visitedSquares.add(start);
            visitedSquares.add(end);
            this.ladders.put(start, new Jump(start, end));
        }

        Logger.getLogger("Board").info(snakes.toString());
        Logger.getLogger("Board").info(ladders.toString());
    }
}
