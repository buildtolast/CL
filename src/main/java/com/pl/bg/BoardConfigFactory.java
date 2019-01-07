package com.pl.bg;

/**
 *  Board Configuration Factory - helps create different board configurations.
 *
 *  The configurations is used to create Board Game using BoardGameFactory
 */
public abstract class BoardConfigFactory {

    protected Integer numberOfBlocks;

    protected BoardConfigFactory(Integer numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
    }

    public BoardConfig create() {
        return new BoardConfig(this.numberOfBlocks);
    }

}
