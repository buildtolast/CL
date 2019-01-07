package com.pl.bg.clbg.main;

import com.pl.bg.BoardGameFactory;
import com.pl.bg.Game;
import com.pl.bg.clbg.FourPlayerBoardGameFactory;
import com.pl.bg.clbg.TwoPlayerBoardGameFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChutesAndLadders {

    public static void main(String[] args) {
        SpringApplication.run(ChutesAndLadders.class, args);

        if(args.length == 0) {
            log.error("No input - Enter 2 or 4 to play!");
            System.exit(-1);
        }

        int simulateNumberOfPlayers = Integer.parseInt(args[0]);
        play(simulateNumberOfPlayers);
    }

    static void play(int players) {
        BoardGameFactory boardGameFactory = null;

        switch (players) {
            case 2:
                boardGameFactory = new TwoPlayerBoardGameFactory();
                break;
            case 4:
                boardGameFactory = new FourPlayerBoardGameFactory();
                break;
            default:
                log.error("Enter 2 or 4 - Not a valid input : {}", players);
                System.exit(-1);
        }

        Game game = boardGameFactory.createGame();
        game.begin();
    }

}

