package com.pl.bg.clbg;

import com.pl.bg.BoardGameFactory;
import com.pl.bg.Game;

import java.util.stream.IntStream;

public class CLBoardGameFactory extends BoardGameFactory<CLBoardConfig, CLBlock, CLBoard, CLPlayer, CLGamePlay> {

    @Override
    public CLBoardConfig createBoardConfig() {
        Integer[][] chuteBlocksConfig = new Integer[][]{{98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60}, {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16, 6}};
        Integer[][] ladderBlocksConfig = new Integer[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}};
        int numberOfBlocks = 100;

        return new CLBoardConfig(numberOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
    }

    @Override
    public CLBoard createBoard() {
        return new CLBoardFactory(createBoardConfig()).create();
    }

    @Override
    protected CLPlayer[] createPlayers() {
        int numberOfPlayers = 2;
        String[] names = new String[]{"Eric", "Paul"};
        CLPlayer[] players = new CLPlayer[numberOfPlayers];
        IntStream.range(0, numberOfPlayers).forEach(index -> players[index] = new CLPlayer(names[index]));
        return players;
    }

    @Override
    protected CLGamePlay<CLBoard, CLPlayer> createGamePlay() {
        return new CLGamePlay<>(createBoard(), createPlayers());
    }

    @Override
    public Game<CLGamePlay> createGame() {
        return new Game<>(createGamePlay());
    }

}
