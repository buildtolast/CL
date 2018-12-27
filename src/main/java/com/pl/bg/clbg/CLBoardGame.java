package com.pl.bg.clbg;

import com.pl.bg.BoardGame;
import com.pl.bg.Player;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CLBoardGame extends BoardGame<CLPlayer, CLConfig, CLBlock, CLBoard> {

    public CLBoardGame(CLBoard board, Integer numOfPlayers, String[] playerNames) {
        super(board, numOfPlayers, playerNames);
        this.players = new CLPlayer[numOfPlayers];
    }

    @Override
    public void gamePlay(Collection<CLPlayer> players) {
        boolean gameInProgress = true;
        int turn = 1;
        while (gameInProgress) {
            for (Player player : players) {
                player.play(turn++);
                if (player.isWinner()) {
                    gameInProgress = false;
                    break;
                }
            }
        }
    }

    @Override
    public Collection<CLPlayer> playersByTurn() {
        return Arrays.stream(players).collect(Collectors.toList());
    }

    @Override
    public void initialisePlayer(CLBoard board) {
        IntStream.range(0, this.numOfPlayers).forEach(p -> players[p] = new CLPlayer(playerNames[p], 0, board));
    }

}
