package com.pl.bg.clbg;

import com.pl.bg.Config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CLConfig extends Config {

    private Map<Integer, Action> actions;

    public static CLConfig build(Integer numOfBlocks, Integer[] basicBlocksConfig, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig){
        return new CLConfig(numOfBlocks, basicBlocksConfig, chuteBlocksConfig, ladderBlocksConfig);
    }

    private CLConfig(Integer numOfBlocks, Integer[] basicBlocksConfig, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig) {
        super(numOfBlocks);
        this.actions = new HashMap<>();
        blockWithNoAction(basicBlocksConfig);
        chuteBlocks(chuteBlocksConfig);
        ladderBlocks(ladderBlocksConfig);
    }

    Map<Integer, Action> getActions() {
        return actions;
    }

    private void chuteBlocks(Integer[][] blockPositions) {
        addActionToBlock(blockPositions, ActionType.CHUTE);
    }

    private void ladderBlocks(Integer[][] blockPositions) {
        addActionToBlock(blockPositions, ActionType.LADDER);
    }

    private void blockWithNoAction(Integer[] blockPositions) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp + 1, new Action(bp, ActionType.NOACTION)));
    }

    private void addActionToBlock(Integer[][] blockPositions, ActionType actionType) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp[0] + 1, new Action(bp[1], actionType)));
    }

}
