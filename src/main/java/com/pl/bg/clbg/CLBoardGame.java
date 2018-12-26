package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CLBoardGame extends BoardGameFactory<CLPlayer, CLConfig, CLBoard> {

    public CLBoardGame(Integer numOfPlayers) {
        super(numOfPlayers);
        this.players = new CLPlayer[numOfPlayers];
    }

    @Override
    public void initialisePlayer(CLBoard board) {
        IntStream.range(0, this.numOfPlayers).forEach(p -> players[p] = new CLPlayer(String.valueOf(p), 0, board));
    }

    @Override
    public CLConfig boardConfig() {
        Integer[] basicBlocks = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Integer[][] chuteBlocks = new Integer[][]{{9, 1}, {8, 2}};
        Integer[][] ladderBlocks = new Integer[][]{{10, 15}};

        return CLConfig.ofBlocks(20)
                       .basicBlocks(basicBlocks)
                       .chuteBlocks(chuteBlocks)
                       .ladderBlocks(ladderBlocks);
    }

    @Override
    public CLBoard prepareBoard() {
        CLBoard clBoard = new CLBoard(boardConfig());
        clBoard.prepare();
        return clBoard;
    }

    public Collection<CLPlayer> playersByTurn() {
        return Arrays.stream(players).collect(Collectors.toList());
    }

}
