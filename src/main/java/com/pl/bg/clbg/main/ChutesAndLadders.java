package com.pl.bg.clbg.main;

import com.pl.bg.BoardGame;
import com.pl.bg.BoardGameFactory;
import com.pl.bg.clbg.CLBoardConfigFactory;
import com.pl.bg.clbg.CLBoardFactory;
import com.pl.bg.clbg.CLBoardGameFactory;
import com.pl.bg.clbg.CLBoardConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChutesAndLadders {

    public static void main(String[] args) {
        SpringApplication.run(ChutesAndLadders.class, args);

        log.info(" ------------------------------------- Game 1 ----------------------------------------------- ");
        play(boardConfig(), 2, new String[]{"Eric", "Paul"});

        log.info(" ------------------------------------- Game 2 ----------------------------------------------- ");
        play(boardConfig(), 3, new String[]{"Alex", "Eric", "Paul"});
    }

    static CLBoardConfig boardConfig() {
        Integer[][] chuteBlocksConfig = new Integer[][]{{98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60}, {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16, 6}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}};
        return new CLBoardConfigFactory(100, chuteBlocksConfig, ladderBlocksConfig).create();
    }

    static void play(CLBoardConfig config, int numPlayers, String[] names) {
        BoardGameFactory factory = new CLBoardGameFactory(new CLBoardFactory(config), numPlayers, names);
        BoardGame boardGame = factory.create();
        boardGame.play();
    }

}

