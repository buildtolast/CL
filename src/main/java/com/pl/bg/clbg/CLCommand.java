package com.pl.bg.clbg;

import com.pl.bg.Command;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CLCommand implements Command {

    Integer sequence;
    CLBoard board;
    CLPlayer player;
    BlockAction blockAction;

    public CLCommand(Integer sequence, CLBoard board, CLPlayer player, BlockAction blockAction) {
        this.sequence = sequence;
        this.board = board;
        this.player = player;
        this.blockAction = blockAction;
    }

    @Override
    public void execute() {
        int initialPosition = this.player.getCurrentPosition();
        handleBlockAction();

        if(board.isFinalBlock(player.getCurrentPosition())) {
            log.debug("{}: {}: {} --> {}", sequence, player.getName(), initialPosition, player.getCurrentPosition());
            player.setWinner(true);
            log.debug("The winner is {}!", player.getName());
        } else {
            int nextPosition = this.player.getCurrentPosition();
            BlockAction nextBlockAction = board.at(nextPosition);
            if (nextBlockAction.isChuteOrLadder()) {
                this.player.setNewPosition(nextBlockAction.advanceToPosition());
                log.debug("{}: {}: {} --> {} --{}--> {}", sequence,
                                                          player.getName(),
                                                          initialPosition,
                                                          nextPosition,
                                                          nextBlockAction.type(),
                                                          player.getCurrentPosition());
                if(board.isFinalBlock(player.getCurrentPosition())) {
                    player.setWinner(true);
                    log.debug("The winner is {}!", player.getName());
                }
            } else {
                log.debug("{}: {}: {} --> {}", sequence, player.getName(), initialPosition, player.getCurrentPosition());
            }
        }
    }

    protected void handleBlockAction() {
        if (blockAction.isChuteOrLadder())
            this.player.setNewPosition(blockAction.advanceToPosition());
        else
            this.player.move(blockAction.advanceToPosition());
    }

}
