package models;


public class Dice {

    private final int faceCount;

    public Dice(int faceCount) {
        this.faceCount = faceCount;
    }

    public int rollDice() {
        return (int)(Math.random() * faceCount + 1);
    }
}
