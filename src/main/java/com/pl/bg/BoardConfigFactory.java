package com.pl.bg;

public abstract class BoardConfigFactory {

    protected Integer numOfBlocks;

    public BoardConfigFactory(Integer numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public BoardConfig build() {
        return new BoardConfig(this.numOfBlocks);
    }

}
