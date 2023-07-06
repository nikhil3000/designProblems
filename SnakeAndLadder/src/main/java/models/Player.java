package models;

import java.util.UUID;

public class Player {
    private final UUID id;
    private int position;
    private boolean winner;


    public Player() {
        id = UUID.randomUUID();
        this.position = 0;
        this.winner = false;
    }


    public UUID getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
