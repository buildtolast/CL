package com.pl.bg;

public abstract class BoardGameFactory<C extends BoardConfig,
                                       BL extends Block,
                                       B extends Board<C, BL>,
                                       P extends Player,
                                       BG extends BoardGame<P, C, BL, B>> {

    public abstract C createBoardConfig();

    public abstract B createBoard();

    public abstract BG createBoardGame();

}

