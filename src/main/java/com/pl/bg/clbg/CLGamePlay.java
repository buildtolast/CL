package com.pl.bg.clbg;

import com.pl.bg.GamePlay;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class CLGamePlay<B extends CLBoard, P extends CLPlayer> implements GamePlay {

    Random random;
    B board;
    P[] players;

    public CLGamePlay(B board, P[] players) {
        this.random = new Random(System.nanoTime());
        this.board = board;
        this.players = players;
    }

    @Override
    public void play() {
        arrangePlayersInTheOrderOfTurn();
        boolean thereIsNoWinner = true;
        int turns = 0;
        while (thereIsNoWinner) {
            for (CLPlayer player : players) {
                int newPosition = playNextTurn();
                if(!board.positionIsValid(player.getCurrentPosition()+newPosition))
                    continue;

                new CLCommand(turns++, board, player, new BlockAction(newPosition, BlockActionType.NOACTION)).execute();
                if (player.isWinner()) {
                    thereIsNoWinner = false;
                    break;
                }
            }
        }

    }

    void arrangePlayersInTheOrderOfTurn() {
        for (P eachPlayer : players)
            eachPlayer.setPlayOrder(playNextTurn());
        Arrays.stream(players).sorted(new CLPlayer.CLPlayerComparator()).collect(Collectors.toList()).toArray(players);
        log.debug("{} to play first! ", players[0].getName());
    }

    protected int playNextTurn() {
        int nextValue = random.nextInt(6);
        while (nextValue == 0)
            nextValue = random.nextInt(6);

        return nextValue;
    }

}
