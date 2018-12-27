package com.pl.bg;

public abstract class BoardGameFactory<C extends Config,
                                       BL extends Block,
                                       B extends Board<C, BL>,
                                       BF extends BoardFactory<C, BL, B>,
                                       P extends Player> {

    protected final BF boardFactory;
    protected final int numberOfPlayers;
    protected final String[] playerNames;

    public BoardGameFactory(BF boardFactory, int numberOfPlayers, String[] playerNames) {
        this.boardFactory = boardFactory;
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
    }

    public abstract BoardGame<P, C, BL, B> build();

}
