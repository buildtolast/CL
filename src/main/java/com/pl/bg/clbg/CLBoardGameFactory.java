package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;

public class CLBoardGameFactory extends BoardGameFactory<CLBoardConfig, CLBlock, CLBoard, CLPlayer, CLBoardGame> {

    int numberOfPlayers;
    String[] names;
    int numberOfBlocks;
    Integer[][] chuteBlocks;
    Integer[][] ladderBlocks;

    public CLBoardGameFactory(int numberOfPlayers, String[] names, int numberOfBlocks, Integer[][] chuteBlocks, Integer[][] ladderBlocks) {
        this.numberOfPlayers = numberOfPlayers;
        this.names = names;
        this.numberOfBlocks = numberOfBlocks;
        this.chuteBlocks = chuteBlocks;
        this.ladderBlocks = ladderBlocks;
    }

    @Override
    public CLBoardConfig createBoardConfig() {
        return new CLBoardConfig(numberOfBlocks, chuteBlocks, ladderBlocks);
    }

    @Override
    public CLBoard createBoard() {
        return new CLBoard(createBoardConfig());
    }

    @Override
    public CLBoardGame createBoardGame() {
        CLBoard clBoard = createBoard();
        return new CLBoardGame(clBoard, numberOfPlayers, names);
    }

}
