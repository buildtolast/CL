package com.pl.bg.clbg;

import com.pl.bg.BoardConfigFactory;

public class CLBoardConfigFactory extends BoardConfigFactory {

    private final Integer[][] chuteBlocksConfig;
    private final Integer[][] ladderBlocksConfig;

    public CLBoardConfigFactory(Integer numberOfBlocks, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig) {
        super(numberOfBlocks);
        this.chuteBlocksConfig = chuteBlocksConfig;
        this.ladderBlocksConfig = ladderBlocksConfig;
    }

    public CLBoardConfig create() {
        return new CLBoardConfig(numberOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
    }

}
