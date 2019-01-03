package com.pl.bg;

public class Game<G extends GamePlay> {

    G gamePlay;

    public Game(G gamePlay) {
        this.gamePlay = gamePlay;
    }

    public void begin() {
        this.gamePlay.play();
    }

}
