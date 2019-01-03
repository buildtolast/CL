package com.pl.bg;

public abstract class Board<C extends BoardConfig, T extends Block> {

    protected T[] blocks;

    public Board(T[] blocks) {
        this.blocks = blocks;
    }

}
