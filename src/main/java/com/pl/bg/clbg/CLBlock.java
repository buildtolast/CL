package com.pl.bg.clbg;

import com.pl.bg.Block;

public class CLBlock extends Block {

    private BlockAction action;

    public CLBlock(Integer position, BlockAction action) {
        this.position = position;
        this.action = action;
    }

    public BlockAction getAction() {
        return action;
    }

}

