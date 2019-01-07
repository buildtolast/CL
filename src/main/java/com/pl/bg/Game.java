package com.pl.bg;

/**
 *  Board Game Factory creates Game using a
 *  pre-defined or given Game Play.
 */
public class Game<G extends GamePlay> {

    G gamePlay;

    public Game(G gamePlay) {
        this.gamePlay = gamePlay;
    }

    public void begin() {
        this.gamePlay.play();
    }

}
