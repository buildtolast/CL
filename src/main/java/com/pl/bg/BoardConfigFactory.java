package com.pl.bg;

public abstract class BoardConfigFactory {

    protected Integer numberOfBlocks;

    protected BoardConfigFactory(Integer numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
    }

    public BoardConfig create() {
        return new BoardConfig(this.numberOfBlocks);
    }

}
