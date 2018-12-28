package com.pl.bg;

import java.util.Collection;

public abstract class BoardGame<P extends Player, C extends BoardConfig, T extends Block, B extends Board<C, T>> {

    protected Integer numOfPlayers;
    protected String[] playerNames;
    protected P[] players;
    protected B board;

    public BoardGame(B board, Integer numOfPlayers, String[] playerNames) {
        this.numOfPlayers = numOfPlayers;
        this.playerNames = playerNames;
        this.board = board;
    }

    public void play() {
        initialisePlayer(board);
        Collection<P> playersOrdered = playersByTurn();
        gamePlay(playersOrdered);
    }

    public abstract void gamePlay(Collection<P> players);

    public abstract void initialisePlayer(B board);

    public abstract Collection<P> playersByTurn();

}
