package com.pl.bg.clbg;

public class Action {

    private ActionType actionType;
    private Integer newPosition;

    public Action(Integer newPosition, ActionType actionType) {
        this.actionType = actionType;
        this.newPosition = newPosition;
    }

    Integer advanceTo() {
        return newPosition;
    }

    boolean isChuteOrLadder(){
        return actionType != ActionType.NOACTION;
    }

    public String type() {
        return actionType.name();
    }
}