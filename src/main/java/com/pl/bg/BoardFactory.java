package com.pl.bg;

public abstract class BoardFactory<C extends Config, T extends Block, B extends Board<C, T>> {

    protected C config;

    public BoardFactory(C config) {
        this.config = config;
    }

    public abstract B build();

}
