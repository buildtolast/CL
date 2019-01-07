package com.pl.bg.clbg;

import org.junit.Assert;
import org.junit.Test;

public class CLBoardConfigFactoryTest {

    @Test
    public void assert_that_board_config_initialised_with_2_chute_and_1_ladder_block_has_7_no_action_blocks() {
        Integer[][] chuteBlocksConfig = new Integer[][]{{4, 1}, {2, 1}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{1, 3}};
        int numberOfBlocks = 10;
        CLBoardConfigFactory clBoardConfigFactory = new CLBoardConfigFactory(numberOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
        CLBoardConfig clBoardConfig = clBoardConfigFactory.create();

        Assert.assertEquals("Mismatch in number of blocks", new Integer(10), clBoardConfig.getNumOfBlocks());
        Assert.assertEquals("Mismatch in number of No Action Blocks", 7, clBoardConfig.getActions().values().stream().filter(a -> !a.isChuteOrLadder()).count());
        Assert.assertEquals("Mismatch in number of Chute Action Blocks", 2, clBoardConfig.getActions().values().stream().filter(a -> a.type().equalsIgnoreCase("chute")).count());
        Assert.assertEquals("Mismatch in number of Ladder Action Blocks", 1, clBoardConfig.getActions().values().stream().filter(a -> a.type().equalsIgnoreCase("ladder")).count());
    }

}
