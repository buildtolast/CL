package com.pl.bg;

public abstract class BoardGameFactory<C extends BoardConfig,
                                       T extends Block,
                                       B extends Board<C, T>,
                                       P extends Player,
                                       G extends GamePlay> {

    public abstract C createBoardConfig();

    public abstract B createBoard();

    protected abstract P[] createPlayers();

    protected abstract G createGamePlay();

    public abstract Game<G> createGame();

}

