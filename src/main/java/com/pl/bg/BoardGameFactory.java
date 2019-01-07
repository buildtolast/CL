package com.pl.bg;

/**
 *  Abstraction for Board Game (Factory), defines the
 *  operations to create Board Game.
 *
 *  Board Game requires -
 *      BoardConfig (@see {@link BoardConfig})
 *          configuration refers to number of blocks and if there are special blocks
 *          associated with a certain action/command
 *      Board @see {@link Board}
 *          board is a collection of blocks and uses a configuration
 *          to help the build
 *      Player @see {@link Player}
 *          board game player - have name and store their current board position
 *      GamePlay @see {@link GamePlay}
 *          defines/encapsulates the rules of the games (how the game is played)
 */
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

