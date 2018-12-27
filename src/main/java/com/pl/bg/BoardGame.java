package com.pl.bg;

import java.util.Collection;

public abstract class BoardGame<P extends Player, C extends Config, T extends Block, B extends Board<C, T>> {

    protected Integer numOfPlayers;
    protected String[] playerNames;
    protected P[] players;
    protected B board;

    public BoardGame(B board, Integer numOfPlayers, String[] playerNames) {
        this.numOfPlayers = numOfPlayers;
        this.playerNames = playerNames;
        this.board = board;
    }

    public abstract Collection<P> playersByTurn();

    public abstract void initialisePlayer(B board);

    public void play() {
        initialisePlayer(board);
        Collection<P> playersOrdered = playersByTurn();
        boolean gameInProgress = true;
        int turn = 1;
        while (gameInProgress) {
            for (Player player : playersOrdered) {
                player.play(turn++);
                if (player.isWinner()) {
                    gameInProgress = false;
                    break;
                }
            }
        }
    }

}
