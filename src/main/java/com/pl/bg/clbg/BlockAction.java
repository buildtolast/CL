package com.pl.bg.clbg;

public class BlockAction {

    private BlockActionType actionType;
    private Integer newPosition;

    public BlockAction(Integer newPosition, BlockActionType actionType) {
        this.actionType = actionType;
        this.newPosition = newPosition;
    }

    Integer advanceToPosition() {
        return newPosition;
    }

    boolean isChuteOrLadder(){
        return actionType != BlockActionType.NOACTION;
    }

    public String type() {
        return actionType.name();
    }

}