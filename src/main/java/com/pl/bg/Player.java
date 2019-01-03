package com.pl.bg;

public abstract class Player {

    protected String name;
    protected Integer currentPosition;
    protected int playOrder;
    protected boolean isWinner;

    public Player(String name, Integer currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public void setPlayOrder(int playOrder) {
        this.playOrder = playOrder;
    }

    public String getName() {
        return name;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public abstract void move(int steps);

    public abstract void setNewPosition(int position);

}
