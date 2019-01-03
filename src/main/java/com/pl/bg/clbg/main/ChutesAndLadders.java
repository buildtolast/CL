package com.pl.bg.clbg.main;

import com.pl.bg.BoardGameFactory;
import com.pl.bg.Game;
import com.pl.bg.clbg.CLBoardGameFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChutesAndLadders {

    public static void main(String[] args) {
        SpringApplication.run(ChutesAndLadders.class, args);
        play();
    }

    static void play() {
        BoardGameFactory boardGameFactory = new CLBoardGameFactory();
        Game game = boardGameFactory.createGame();
        game.begin();
    }

}

