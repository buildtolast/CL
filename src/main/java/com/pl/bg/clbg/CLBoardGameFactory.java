package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;

public class CLBoardGameFactory extends BoardGameFactory<CLConfig, CLBlock, CLBoard, CLBoardFactory, CLPlayer> {

    public CLBoardGameFactory(CLBoardFactory boardFactory, int numberOfPlayers, String[] playerNames) {
        super(boardFactory, numberOfPlayers, playerNames);
    }

    @Override
    public CLBoardGame build() {
        return new CLBoardGame(boardFactory.build(), this.numberOfPlayers, this.playerNames);
    }

}
