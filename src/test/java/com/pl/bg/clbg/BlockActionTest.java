package com.pl.bg.clbg;

import org.junit.Assert;
import org.junit.Test;

public class BlockActionTest {

    @Test
    public void assert_that_blockaction_type_is_noaction() {
        BlockAction blockAction = new BlockAction(10, BlockActionType.NOACTION);
        Assert.assertFalse("Block Action should be No Action Type", blockAction.isChuteOrLadder());
    }

    @Test
    public void assert_that_blockaction_type_is_chute() {
        BlockAction blockAction = new BlockAction(10, BlockActionType.CHUTE);
        Assert.assertEquals("Block Action should be Chute Type", "CHUTE", blockAction.type());
    }

    @Test
    public void assert_that_blockaction_type_is_ladder() {
        BlockAction blockAction = new BlockAction(10, BlockActionType.LADDER);
        Assert.assertEquals("Block Action should be Ladder Type", "LADDER", blockAction.type());
    }

    @Test
    public void assert_that_blockaction_advances_to_new_position_10() {
        BlockAction blockAction = new BlockAction(10, BlockActionType.LADDER);
        Assert.assertEquals("Block Action should advance to new position 10", new Integer(10), blockAction.advanceToPosition());
    }

}