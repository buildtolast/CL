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
    public void play(int turn) {
        int value = nextValue();
        int lastKnownPosition = currentPosition;
        if (!clBoard.isValid(currentPosition + value))
            return;

        currentPosition += value;
        if (clBoard.isFinalBlock(currentPosition)) {
            log.debug("{}: {}: {} --> {} ", turn, name, lastKnownPosition, (lastKnownPosition + value));
            this.winner = true;
            log.info("The Winner is {}! ", name);
        } else {
            Action action = clBoard.at(currentPosition);
            if (!clBoard.isValid(action.advanceTo()))
                throw new RuntimeException("Board Configuration Invalid, Terminating Game, Current Position : " + currentPosition + ", AdvanceTo : " + action.advanceTo());

            currentPosition = action.advanceTo();
            if(action.isChuteOrLadder())
                log.debug("{}: {}: {} --> {} --{}--> {}", turn, name, lastKnownPosition, (lastKnownPosition + value), action.type(), currentPosition);
            else
                log.debug("{}: {}: {} --> {} ", turn, name, lastKnownPosition, (lastKnownPosition + value));

            if (clBoard.isFinalBlock(currentPosition)) {
                this.winner = true;
                log.info("The Winner is {}! ", name);
            }
        }
    }

    private int nextValue() {
        int nextValue = random.nextInt(6);
        while(nextValue == 0)
            nextValue = random.nextInt(6);
        return nextValue;
    }

}
