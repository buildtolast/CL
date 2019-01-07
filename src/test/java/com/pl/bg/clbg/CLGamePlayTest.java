package com.pl.bg.clbg;

import com.pl.bg.GamePlay;
import org.junit.Assert;
import org.junit.Test;

public class CLGamePlayTest {

    @Test
    public void assert_that_a_board_game_with_10_blocks_and_played_by_2_players_has_a_winner() {
        Integer numberOfBlocks = 10;
        Integer[][] chutes = new Integer[][]{{3, 1}};
        Integer[][] ladders = new Integer[][]{{2, 7}};

        CLBoardConfig boardConfig = new CLBoardConfig(numberOfBlocks, chutes, ladders);
        CLBoardFactory boardFactory = new CLBoardFactory(boardConfig);

        CLPlayer[] clPlayers = {new CLPlayer("Eric"), new CLPlayer("Tom")};
        CLGamePlay gamePlay = new CLGamePlay<>(boardFactory.create(), clPlayers);

        gamePlay.play();

        Assert.assertTrue(clPlayers[0].isWinner() || clPlayers[1].isWinner());
    }

}