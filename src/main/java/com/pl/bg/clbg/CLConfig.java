package com.pl.bg.clbg;

import com.pl.bg.Config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CLConfig extends Config {

    private Map<Integer, Action> actions;

    private CLConfig(Integer numOfBlocks) {
        super(numOfBlocks);
        this.actions = new HashMap<>();
    }

    Map<Integer, Action> getActions() {
        return actions;
    }

    CLConfig basicBlocks(Integer[] blockPositions) {
        return blockWithNoAction(blockPositions);
    }

    CLConfig chuteBlocks(Integer[][] blockPositions) {
        return addActionToBlock(blockPositions, ActionType.CHUTE);
    }

    CLConfig ladderBlocks(Integer[][] blockPositions) {
        return addActionToBlock(blockPositions, ActionType.LADDER);
    }

    private CLConfig blockWithNoAction(Integer[] blockPositions) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp+1, new Action(bp, ActionType.NOACTION)));
        return this;
    }

    private CLConfig addActionToBlock(Integer[][] blockPositions, ActionType actionType) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp[0]+1, new Action(bp[1], actionType)));
        return this;
    }

    static CLConfig ofBlocks(Integer numberOfBlocks) {
        return new CLConfig(numberOfBlocks);
    }

}
