package com.pl.bg.clbg;

import com.pl.bg.BoardGame;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CLBoardGame extends BoardGame<CLPlayer, CLConfig, CLBlock, CLBoard> {

    public CLBoardGame(CLBoard board, Integer numOfPlayers) {
        super(board, numOfPlayers);
        this.players = new CLPlayer[numOfPlayers];
    }

    @Override
    public Collection<CLPlayer> playersByTurn() {
        return Arrays.stream(players).collect(Collectors.toList());
    }

    @Override
    public void initialisePlayer(CLBoard board) {
        IntStream.range(0, this.numOfPlayers).forEach(p -> players[p] = new CLPlayer(String.valueOf(p), 0, board));
    }

}
