package com.pl.bg.clbg;

import com.pl.bg.Board;

class CLBoard extends Board<CLBoardConfig, CLBlock> {

    private Integer finalBlock;

    public CLBoard(CLBoardConfig config) {
        super(new CLBlock[config.getNumOfBlocks()+1]);
        config.getActions().forEach((a, b) -> blocks[a] = new CLBlock(a, b));
        this.finalBlock = config.getNumOfBlocks();
    }

    BlockAction at(Integer position) {
        return blocks[position].getAction();
    }

    boolean isFinalBlock(Integer blockPosition) {
        return finalBlock.equals(blockPosition);
    }

    boolean positionIsValid(Integer position) {
        return finalBlock >= position;
    }

}
