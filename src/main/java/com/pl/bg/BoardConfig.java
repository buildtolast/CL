package com.pl.bg;

/**
 *  Board configuration - number of blocks
 */
public class BoardConfig {

    private final Integer numOfBlocks;

    protected BoardConfig(Integer numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public Integer getNumOfBlocks() {
        return numOfBlocks;
    }

}
