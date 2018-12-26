package com.pl.bg.clbg;

import com.pl.bg.Board;

class CLBoard extends Board<CLBlock> {

    private CLConfig config;
    private Integer finalBlock;

    CLBoard(CLConfig config) {
        this.config = config;
        this.finalBlock = config.getNumOfBlocks();
    }

    void prepare() {
        this.blocks = new CLBlock[config.getNumOfBlocks()];
        this.config.getActions().forEach((a, b) -> blocks[a-1] = new CLBlock(a-1, b));
    }

    Action at(Integer position){
        return blocks[position].getAction();
    }

    boolean isFinalBlock(Integer blockPosition) {
        return finalBlock.equals(blockPosition);
    }

    boolean positionValid(Integer position){
        return finalBlock >= position;
    }

}
