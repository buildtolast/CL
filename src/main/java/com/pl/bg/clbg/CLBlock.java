package com.pl.bg.clbg;

import com.pl.bg.Block;

public class CLBlock extends Block {

    private Action action;

    public CLBlock(Integer position, Action action) {
        super(position);
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

}

