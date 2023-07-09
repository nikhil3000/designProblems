package models;

import java.util.UUID;

public class Player {
    private final UUID id;
    private int position;


    public Player() {
        id = UUID.randomUUID();
        this.position = 0;
    }

    public int rollDice(Dice dice, int diceCount) {
        int i = 0;
        int totalSteps = 0;
        while (i++ < diceCount) {
            totalSteps += dice.rollDice();
        }
        return totalSteps;
    }

    public UUID getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
