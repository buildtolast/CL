package com.pl.bg;

/**
 *  Board uses a  configuration to build the board containing blocks
 */
public abstract class Board<C extends BoardConfig, T extends Block> {

    protected T[] blocks;

    public Board(T[] blocks) {
        this.blocks = blocks;
    }

}
