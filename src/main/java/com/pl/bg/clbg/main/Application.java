package com.pl.bg.clbg.main;

import com.pl.bg.BoardGameFactory;
import com.pl.bg.clbg.CLBoardGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        BoardGameFactory boardGame = new CLBoardGame(2);
        boardGame.play();
    }

}

