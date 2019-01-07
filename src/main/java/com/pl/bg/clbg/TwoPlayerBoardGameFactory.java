package com.pl.bg.clbg;

public class TwoPlayerBoardGameFactory extends CLBoardGameFactory {

    @Override
    protected int numberOfPlayers() {
        return 2;
    }

    @Override
    protected String[] playerNames() {
        return new String[]{"Eric", "Paul"};
    }

}
