package com.pl.bg.clbg.main;

import com.pl.bg.BoardGame;
import com.pl.bg.BoardGameFactory;
import com.pl.bg.clbg.CLBoardFactory;
import com.pl.bg.clbg.CLBoardGameFactory;
import com.pl.bg.clbg.CLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Integer[] basicBlocksConfig = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Integer[][] chuteBlocksConfig = new Integer[][]{{9, 1}, {8, 2}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{10, 15}};

        CLConfig clBoardConfig = CLConfig.build(20, basicBlocksConfig, chuteBlocksConfig, ladderBlocksConfig);

        BoardGameFactory factory = new CLBoardGameFactory(new CLBoardFactory(clBoardConfig), 2);
        BoardGame boardGame = factory.build();
        boardGame.play();
    }

}

