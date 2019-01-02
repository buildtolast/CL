package com.pl.bg.clbg;

import com.pl.bg.BoardConfigFactory;

public class CLBoardConfigFactory extends BoardConfigFactory {

    private final Integer[][] chuteBlocksConfig;
    private final Integer[][] ladderBlocksConfig;

    public CLBoardConfigFactory(Integer numOfBlocks, Integer[][] chuteBlocksConfig, Integer[][] ladderBlocksConfig){
        super(numOfBlocks);
        this.chuteBlocksConfig = chuteBlocksConfig;
        this.ladderBlocksConfig = ladderBlocksConfig;
    }

    @Override
    public CLBoardConfig create() {
        return new CLBoardConfig(numOfBlocks, chuteBlocksConfig, ladderBlocksConfig);
    }

}
