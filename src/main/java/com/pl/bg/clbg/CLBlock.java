package com.pl.bg.clbg;

import com.pl.bg.Block;

class CLBlock extends Block {

    private BlockAction action;

    CLBlock(Integer position, BlockAction action) {
        this.position = position;
        this.action = action;
    }

    BlockAction getAction() {
        return action;
    }

}

