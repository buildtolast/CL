package com.pl.bg.clbg;

import com.pl.bg.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CLBoardGameFactoryTest {

    @Test
    public void verify_player_names_as_eric_and_paul() {
        CLBoardGameFactory clBoardGameFactory = new CLBoardGameFactory();
        CLPlayer[] players = clBoardGameFactory.createPlayers();

        Assert.assertEquals(2, players.length);
        String[] actual = Arrays.stream(players).map(Player::getName).sorted().toArray(String[]::new);
        Assert.assertArrayEquals(new String[]{"Eric", "Paul"}, actual);
    }

    @Test
    public void verify_10_chute_blocks_and_9_ladder_blocks_and_81_noaction_blocks() {
        CLBoardGameFactory clBoardGameFactory = new CLBoardGameFactory();
        CLBoardConfig boardConfig = clBoardGameFactory.createBoardConfig();

        Assert.assertEquals(19, boardConfig.getActions().values().stream().filter(BlockAction::isChuteOrLadder).count());
        Assert.assertEquals(9, boardConfig.getActions().values().stream().filter(v -> v.type().equalsIgnoreCase("ladder")).count());
        Assert.assertEquals(10, boardConfig.getActions().values().stream().filter(v -> v.type().equalsIgnoreCase("chute")).count());
        Assert.assertEquals(81, boardConfig.getActions().values().stream().filter(v -> !v.isChuteOrLadder()).count());
    }

}