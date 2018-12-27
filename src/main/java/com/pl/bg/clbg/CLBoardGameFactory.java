package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;

public class CLBoardGameFactory extends BoardGameFactory<CLConfig, CLBlock, CLBoard, CLBoardFactory, CLPlayer> {

    public CLBoardGameFactory(CLBoardFactory boardFactory, int numberOfPlayers) {
        super(boardFactory, numberOfPlayers);
    }

    @Override
    public CLBoardGame build() {
        return new CLBoardGame(boardFactory.build(), this.numberOfPlayers);
    }

}
