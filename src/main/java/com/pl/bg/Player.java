package com.pl.bg;

public abstract class Player {

    protected String name;
    protected Integer currentPosition;
    protected boolean winner;

    public Player(String name, Integer currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
        this.winner = false;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public abstract void play(int turn);

}
