package com.pl.bg.clbg;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CLCommandTest {

    @Mock
    CLBoard clBoard;

    @Mock
    CLPlayer clPlayer;

    @Mock
    BlockAction blockAction;

    @Test
    public void assert_that_when_player_reaches_a_block_of_no_action_player_stays_in_current_position() {
        when(clBoard.at(4)).thenReturn(new BlockAction(4, BlockActionType.NOACTION));
        when(clBoard.isFinalBlock(4)).thenReturn(false);

        when(clPlayer.getCurrentPosition()).thenReturn(4);
        when(clPlayer.getName()).thenReturn("Eric");

        when(blockAction.isChuteOrLadder()).thenReturn(false);

        CLCommand clCommand = new CLCommand(1, clBoard, clPlayer, blockAction);
        clCommand.execute();

        Assert.assertEquals(new Integer(4), clPlayer.getCurrentPosition());
    }

    @Test
    public void assert_that_when_player_reaches_a_block_of_chute_action_player_advances_to_new_position() {
        when(clBoard.at(4)).thenReturn(new BlockAction(8, BlockActionType.CHUTE));
        when(clBoard.isFinalBlock(8)).thenReturn(false);

        CLPlayer clPlayer = new CLPlayer("Eric");

        when(blockAction.advanceToPosition()).thenReturn(4);
        when(blockAction.isChuteOrLadder()).thenReturn(true);

        CLCommand clCommand = new CLCommand(1, clBoard, clPlayer, blockAction);
        clCommand.execute();

        Assert.assertEquals(new Integer(8), clPlayer.getCurrentPosition());
    }

    @Test
    public void assert_that_when_player_reaches_the_winning_block_player_is_winner() {
        when(clBoard.at(4)).thenReturn(new BlockAction(8, BlockActionType.CHUTE));
        when(clBoard.isFinalBlock(8)).thenReturn(true);

        CLPlayer clPlayer = new CLPlayer("Eric");

        when(blockAction.advanceToPosition()).thenReturn(4);
        when(blockAction.isChuteOrLadder()).thenReturn(false);

        CLCommand clCommand = new CLCommand(1, clBoard, clPlayer, blockAction);
        clCommand.execute();

        Assert.assertTrue(clPlayer.isWinner());
    }

    @Test
    public void assert_that_when_player_is_at_the_winning_block_player_is_winner() {
        when(clBoard.isFinalBlock(5)).thenReturn(true);

        CLPlayer clPlayer = new CLPlayer("Eric");

        when(blockAction.advanceToPosition()).thenReturn(5);
        when(blockAction.isChuteOrLadder()).thenReturn(false);

        CLCommand clCommand = new CLCommand(1, clBoard, clPlayer, blockAction);
        clCommand.execute();

        Assert.assertTrue(clPlayer.isWinner());
    }


}