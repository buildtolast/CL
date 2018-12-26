package com.pl.bg;

import java.util.Collection;
import java.util.Iterator;

public abstract class BoardGameFactory<P extends Player, C extends Config, B extends Board> {

    protected Integer numOfPlayers;
    protected P[] players;

    public BoardGameFactory(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public abstract void initialisePlayer(B board);

    public abstract C boardConfig();

    public abstract B prepareBoard();

    public abstract Collection<P> playersByTurn();

    public void play() {
        B board = prepareBoard();
        initialisePlayer(board);
        Collection<P> playersOrdered = playersByTurn();
        while (!playersOrdered.isEmpty()) {
            Iterator<P> currentPlayer = playersOrdered.iterator();
            while(currentPlayer.hasNext()) {
                Player player = currentPlayer.next();
                player.play();
                if(player.isWinner())
                    currentPlayer.remove();
            }
        }
    }

}
