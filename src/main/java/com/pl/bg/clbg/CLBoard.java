package com.pl.bg.clbg;

import com.pl.bg.Board;

class CLBoard extends Board<CLConfig, CLBlock> {

    private Integer finalBlock;

    public CLBoard(CLConfig config) {
        this.blocks = new CLBlock[config.getNumOfBlocks()+1];
        config.getActions().forEach((a, b) -> blocks[a] = new CLBlock(a, b));
        this.finalBlock = config.getNumOfBlocks();
    }

    Action at(Integer position) {
        return blocks[position].getAction();
    }

    boolean isFinalBlock(Integer blockPosition) {
        return finalBlock.equals(blockPosition);
    }

    boolean isValid(Integer position) {
        return finalBlock >= position;
    }

}
