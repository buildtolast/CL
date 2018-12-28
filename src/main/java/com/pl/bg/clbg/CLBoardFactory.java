package com.pl.bg.clbg;

import com.pl.bg.BoardFactory;

public class CLBoardFactory extends BoardFactory<CLBoardConfig, CLBlock, CLBoard> {

    public CLBoardFactory(CLBoardConfig config) {
        super(config);
    }

    @Override
    public CLBoard build() {
        return new CLBoard(config);
    }

}
