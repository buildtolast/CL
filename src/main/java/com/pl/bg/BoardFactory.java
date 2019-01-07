package com.pl.bg;

/**
 *  Create Board for a given board configuration.
 */
public abstract class BoardFactory<C extends BoardConfig, T extends Block, B extends Board<C, T>> {

    protected C config;

    public BoardFactory(C config) {
        this.config = config;
    }

    public abstract B create();

}
