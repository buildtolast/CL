package com.pl.bg.clbg;

public class FourPlayerBoardGameFactory extends CLBoardGameFactory {

    @Override
    protected int numberOfPlayers() {
        return 4;
    }

    @Override
    protected String[] playerNames() {
        return new String[]{"Eric", "Paul", "John", "Tim"};
    }

}
