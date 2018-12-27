package com.pl.bg;

public abstract class BoardGameFactory<C extends Config,
                                       BL extends Block,
                                       B extends Board<C, BL>,
                                       BF extends BoardFactory<C, BL, B>,
                                       P extends Player> {

    protected final int numberOfPlayers;
    protected final BF boardFactory;

    public BoardGameFactory(BF boardFactory, int numberOfPlayers) {
        this.boardFactory = boardFactory;
        this.numberOfPlayers = numberOfPlayers;
    }

    public abstract BoardGame<P, C, BL, B> build();

}
