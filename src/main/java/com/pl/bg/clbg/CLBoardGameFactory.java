package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;

public class CLBoardGameFactory extends BoardGameFactory<CLBoardConfig, CLBlock, CLBoard, CLBoardFactory, CLPlayer> {

    public CLBoardGameFactory(CLBoardFactory boardFactory, int numberOfPlayers, String[] playerNames) {
        super(boardFactory, numberOfPlayers, playerNames);
    }

    @Override
    public CLBoardGame create() {
        return new CLBoardGame(boardFactory.create(), this.numberOfPlayers, this.playerNames);
    }

}
