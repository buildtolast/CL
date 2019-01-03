package com.pl.bg.clbg;

import com.pl.bg.BoardConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CLBoardConfig extends BoardConfig {

    private Map<Integer, BlockAction> actions;

    public CLBoardConfig(Integer numOfBlocks, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig) {
        super(numOfBlocks);
        this.actions = new HashMap<>();
        chuteBlocks(chuteBlocksConfig);
        ladderBlocks(ladderBlocksConfig);
        blockWithNoAction();
    }

    Map<Integer, BlockAction> getActions() {
        return actions;
    }

    private void chuteBlocks(Integer[][] blockPositions) {
        addActionToBlock(blockPositions, BlockActionType.CHUTE);
    }

    private void ladderBlocks(Integer[][] blockPositions) {
        addActionToBlock(blockPositions, BlockActionType.LADDER);
    }

    private void blockWithNoAction() {
        IntStream.rangeClosed(1, getNumOfBlocks()).filter(bp -> !this.actions.containsKey(bp)).forEach(bp -> this.actions.put(bp, new BlockAction(bp, BlockActionType.NOACTION)));
    }

    private void addActionToBlock(Integer[][] blockPositions, BlockActionType actionType) {
        Arrays.stream(blockPositions).forEach(bp -> this.actions.put(bp[0], new BlockAction(bp[1], actionType)));
    }

}
