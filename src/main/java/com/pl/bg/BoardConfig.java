package com.pl.bg;

public class BoardConfig {

    private final Integer numOfBlocks;

    protected BoardConfig(Integer numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public Integer getNumOfBlocks() {
        return numOfBlocks;
    }

}
