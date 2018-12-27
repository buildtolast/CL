package com.pl.bg.clbg;

import com.pl.bg.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class CLPlayer extends Player {

    private Random random;
    private CLBoard clBoard;

    public CLPlayer(String name, Integer currentPosition, CLBoard clBoard) {
        super(name, currentPosition);
        this.random = new Random(System.nanoTime());
        this.clBoard = clBoard;
    }

    @Override
    public void play() {
        int value = random.nextInt(6);
        log.debug("Player " + name + " <Turn> ** " + value);
        if (!clBoard.isValid(currentPosition + value))
            return;

        currentPosition += value;
        log.debug("Player " + name + " <Advanced To> ** " + currentPosition);
        if (clBoard.isFinalBlock(currentPosition)) {
            this.winner = true;
            log.info("$$ Player " + name + " wins!!!");
        } else {
            Action action = clBoard.at(currentPosition);
            if (!clBoard.isValid(action.advanceTo()))
                throw new RuntimeException("Board Configuration Invalid, Terminating Game, Current Position : " + currentPosition + ", AdvanceTo : " + action.advanceTo());

            currentPosition = action.advanceTo();
            if(action.isChuteOrLadder())
                log.debug(action.type() + " For Player " + name + " <Advanced To> ** " + currentPosition);

            if (clBoard.isFinalBlock(currentPosition)) {
                this.winner = true;
                log.info("$$ Player " + name + " wins!!!");
            }
        }
    }

}
