package com.pl.bg.clbg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CLBoardFactoryTest {

    @Mock
    private CLBoardConfig mockedCLBoardConfig;

    @Before
    public void beforeEachUnitTestMethodInvocation() {
        Map<Integer, BlockAction> map = new HashMap<>();
        map.put(0, new BlockAction(0, BlockActionType.NOACTION));
        map.put(1, new BlockAction(5, BlockActionType.LADDER));
        map.put(2, new BlockAction(0, BlockActionType.NOACTION));
        map.put(3, new BlockAction(0, BlockActionType.NOACTION));
        map.put(4, new BlockAction(1, BlockActionType.CHUTE));
        when(mockedCLBoardConfig.getActions()).thenReturn(map);
        when(mockedCLBoardConfig.getNumOfBlocks()).thenReturn(5);
    }

    @Test
    public void assert_that_final_block_position_is_5() {
        CLBoardFactory clBoardFactory = new CLBoardFactory(mockedCLBoardConfig);
        CLBoard board = clBoardFactory.create();

        Assert.assertTrue(board.isFinalBlock(5));
    }

    @Test
    public void assert_that_board_position_6_is_invalid() {
        CLBoardFactory clBoardFactory = new CLBoardFactory(mockedCLBoardConfig);
        CLBoard board = clBoardFactory.create();

        Assert.assertFalse(board.positionIsValid(6));
    }

    @Test
    public void assert_that_board_initialised_using_config_of_3_noaction_and_1_chute_action_and_1_ladder_action_is_valid() {
        CLBoardFactory clBoardFactory = new CLBoardFactory(mockedCLBoardConfig);
        CLBoard board = clBoardFactory.create();

        Assert.assertEquals(new Integer(5), mockedCLBoardConfig.getNumOfBlocks());

        Assert.assertEquals("NOACTION", board.at(0).type());
        Assert.assertEquals(new Integer(0), board.at(0).advanceToPosition());

        Assert.assertEquals("LADDER", board.at(1).type());
        Assert.assertEquals(new Integer(5), board.at(1).advanceToPosition());

        Assert.assertEquals("NOACTION", board.at(2).type());
        Assert.assertEquals(new Integer(0), board.at(2).advanceToPosition());

        Assert.assertEquals("NOACTION", board.at(3).type());
        Assert.assertEquals(new Integer(0), board.at(3).advanceToPosition());

        Assert.assertEquals("CHUTE", board.at(4).type());
        Assert.assertEquals(new Integer(1), board.at(4).advanceToPosition());
    }

}