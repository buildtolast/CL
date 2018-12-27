package com.pl.bg.clbg.main;

import com.pl.bg.BoardGame;
import com.pl.bg.BoardGameFactory;
import com.pl.bg.clbg.CLBoardFactory;
import com.pl.bg.clbg.CLBoardGameFactory;
import com.pl.bg.clbg.CLConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChutesAndLadders {

    public static void main(String[] args) {
        SpringApplication.run(ChutesAndLadders.class, args);

        Integer[][] chuteBlocksConfig = new Integer[][]{{98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60}, {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16, 6}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}};
        CLConfig clBoardConfig = CLConfig.build(100, chuteBlocksConfig, ladderBlocksConfig);

        play(clBoardConfig, 2, new String[]{"Eric", "Paul"});
    }

    static void play(CLConfig config, int numPlayers, String[] names) {
        BoardGameFactory factory = new CLBoardGameFactory(new CLBoardFactory(config), numPlayers, names);
        BoardGame boardGame = factory.build();
        boardGame.play();
    }

}
