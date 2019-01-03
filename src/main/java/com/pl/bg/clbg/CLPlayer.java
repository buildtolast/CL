package com.pl.bg.clbg;

import com.pl.bg.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class CLPlayer extends Player {

    public CLPlayer(String name) {
        super(name, 0);
    }

    @Override
    public void move(int steps) {
        currentPosition += steps;
    }

    @Override
    public void setNewPosition(int position) {
        this.currentPosition = position;
    }

    static class CLPlayerComparator implements Comparator<CLPlayer> {

        @Override
        public int compare(CLPlayer left, CLPlayer right) {
            return Integer.compare(left.playOrder, right.playOrder);
        }
    }

}

