package models;

public class Jump {

    private final int start;
    private final int end;


    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Jump{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}