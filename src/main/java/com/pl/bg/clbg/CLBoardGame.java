//package com.pl.bg.clbg;
//
//import com.pl.bg.BoardGame;
//import com.pl.bg.Player;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * Concrete implementation of Chute and Ladders board game with the intention of
// * showcasing the game move.
// *
// * The class extends BoardGame and expects a concrete implementation of CLBoard,
// * number of players and names of player @see initialisePlayer.
// *
// * Implements @see playerByTurn - to make a random selection of player
// * who plays first.
// *
// * Implements @see gamePlay - define the Chutes and Ladders game move
// *
// * TODO Player Validations - limit the number of players and names
// */
//public class CLBoardGame extends BoardGame<CLPlayer, CLBoardConfig, CLBlock, CLBoard> {
//
//    CLBoardGame(CLBoard board, Integer numOfPlayers, String[] playerNames) {
//        super(board, numOfPlayers, playerNames);
//        this.players = new CLPlayer[numOfPlayers];
//    }
//
//    @Override
//    public void gamePlay(Collection<CLPlayer> players) {
//        boolean gameInProgress = true;
//        int turn = 1;
//        while (gameInProgress) {
//            for (Player player : players) {
//                player.move(turn++);
//                if (player.isWinner()) {
//                    gameInProgress = false;
//                    break;
//                }
//            }
//        }
//    }
//
//    @Override
//    public Collection<CLPlayer> playersByTurn() {
//        return Arrays.stream(players).collect(Collectors.toList());
//    }
//
//    @Override
//    public void initialisePlayer(CLBoard board) {
//        IntStream.range(0, this.numOfPlayers).forEach(p -> players[p] = new CLPlayer(playerNames[p]));
//    }
//
//}
