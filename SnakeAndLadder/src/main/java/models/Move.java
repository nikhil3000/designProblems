package models;

public class Move {
    private final Jump move;
    private final Player player;

    public Move(Jump move, Player player) {
        this.move = move;
        this.player = player;
    }

    public Jump getMove() {
        return move;
    }

    public Player getPlayer() {
        return player;
    }
}
