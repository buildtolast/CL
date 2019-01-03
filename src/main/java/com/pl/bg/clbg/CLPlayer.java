package com.pl.bg.clbg;

import com.pl.bg.Player;
import lombok.extern.slf4j.Slf4j;

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

}

