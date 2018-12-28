package com.pl.bg.clbg;

import com.pl.bg.BoardConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CLBoardConfig extends BoardConfig {

    private Map<Integer, Action> actions;

    public static CLBoardConfig build(Integer numOfBlocks, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig) {
        return new CLBoardConfig(numOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
    }

    private CLBoardConfig(Integer numOfBlocks, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig) {
        super(numOfBlocks);
        this.actions = new HashMap<>();
        chuteBlocks(chuteBlocksConfig);
        ladderBlocks(ladderBlocksConfig);
        blockWithNoAction();
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

    private void blockWithNoAction() {
        IntStream.rangeClosed(1, getNumOfBlocks()).filter(bp -> !this.actions.containsKey(bp)).forEach(bp -> this.actions.put(bp, new Action(bp, ActionType.NOACTION)));
    }

    private void addActionToBlock(Integer[][] blockPositions, ActionType actionType) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp[0], new Action(bp[1], actionType)));
    }

}
