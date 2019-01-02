package com.pl.bg.clbg.main;

import com.pl.bg.BoardGame;
import com.pl.bg.BoardGameFactory;
import com.pl.bg.clbg.CLBoardGameFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChutesAndLadders {

    public static void main(String[] args) {
        SpringApplication.run(ChutesAndLadders.class, args);
        play(2, new String[]{"Eric", "Paul"});
    }

    static void play(int numPlayers, String[] names) {
        Integer[][] chuteBlocksConfig = new Integer[][]{{98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60}, {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16, 6}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}};
        int numberOfBlocks = 100;
        BoardGameFactory factory = new CLBoardGameFactory(numPlayers, names, numberOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
        BoardGame boardGame = factory.createBoardGame();
        boardGame.play();
    }

}

