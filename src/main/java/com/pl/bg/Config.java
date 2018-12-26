package com.pl.bg;

public abstract class Config {

    private final Integer numOfBlocks;

    protected Config(Integer numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public Integer getNumOfBlocks() {
        return numOfBlocks;
    }

}
