package services;

import models.Board;
import models.Dice;
import models.Move;
import models.Player;
import services.GamePlayingStrategy.GamePlayingStrategy;

import java.util.*;

public class Game {


    private final UUID id;
    private final Dice dice;
    private final Board board;
    private final int diceCount;
    private final Queue<Player> players = new LinkedList<>();
    private final Stack<Move> moves = new Stack<>();
    private Player winner;
    private final GamePlayingStrategy gamePlayingStrategy;

    public UUID getId() {
        return id;
    }

    public Dice getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public Player getWinner() {
        return winner;
    }


    public Game(int diceCount, int snakeCount, int ladderCount, int playerCount, GamePlayingStrategy gamePlayingStrategy) {
        // We can parameterize the row and column count if needed.
        int rowCount = 10;
        int columnCount = 10;

        while (players.size() < playerCount) {
            players.add(new Player());
        }
        this.id = UUID.randomUUID();
        this.dice = new Dice(6);
        this.board = new Board(rowCount, columnCount, snakeCount, ladderCount);
        this.diceCount = diceCount;
        this.gamePlayingStrategy = gamePlayingStrategy;
    }


    public Player playGame() {
        while(true) {
            Player player = players.poll();
            Move move =  gamePlayingStrategy.makeMove(player.rollDice(dice, getDiceCount()), board, player);
            players.add(player);
            moves.add(move);

            if(player.getPosition() >= board.getBoardSize()){
                this.winner = player;
                break;
            }

        }
        return this.winner;
    }
}
