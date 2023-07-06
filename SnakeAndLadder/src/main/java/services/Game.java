package services;

import models.Board;
import models.Dice;
import models.Jump;
import models.Player;

import java.util.*;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomUtils;


public abstract class Game {
    public UUID getId() {
        return id;
    }

    private final UUID id;
    private final Dice dice;

    public Dice getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }

    public int getDiceCount() {
        return diceCount;
    }

    private final Board board;
    private final int diceCount;
    private final Queue<Player> players = new LinkedList<>();
    Logger logger = Logger.getLogger("Game");


    public Game(int diceCount, int snakeCount, int ladderCount, int playerCount) {
        // We can parameterize the row and column count if needed.
        int rowCount = 10;
        int columnCount = 10;
        Set<Integer> visitedSquares = new HashSet<>();
        List<Jump> snakes = new ArrayList<>();
        List<Jump> ladders = new ArrayList<>();

        while(snakes.size() < snakeCount){
            int end = RandomUtils.nextInt(1, rowCount * columnCount - 1);
            int start = RandomUtils.nextInt(end + 1, rowCount * columnCount);

            if(visitedSquares.contains(start) || visitedSquares.contains(end)) {
                continue;
            }
            visitedSquares.add(start);
            visitedSquares.add(end);
            snakes.add(new Jump(start, end));
        }

        while(ladders.size() < ladderCount){
            int start = RandomUtils.nextInt(1, rowCount * columnCount - 1);
            int end = RandomUtils.nextInt(start + 1, rowCount * columnCount);
            if(visitedSquares.contains(start) || visitedSquares.contains(end)) {
                continue;
            }
            visitedSquares.add(start);
            visitedSquares.add(end);
            ladders.add(new Jump(start, end));
        }

       Board board = new Board(rowCount, columnCount, snakes, ladders);
        while (players.size() < playerCount) {
            players.add(new Player());
        }
        this.id = UUID.randomUUID();
        this.dice = new Dice(6);
        this.board = board;
        this.diceCount = diceCount;
    }

    public abstract Player makeMove(Player player);

    public Player playGame() {
        Player winner = null;
        while(true) {
            Player player = makeMove(players.poll());
            players.add(player);

            if(player.getPosition() >= board.getBoardSize()){
                player.setWinner(true);
                winner = player;
                break;
            }

        }
        return winner;
    }
}
