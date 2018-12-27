package com.pl.bg.clbg;

import com.pl.bg.BoardFactory;

public class CLBoardFactory extends BoardFactory<CLConfig, CLBlock, CLBoard> {

    public CLBoardFactory(CLConfig config) {
        super(config);
    }

    @Override
    public CLBoard build() {
        return new CLBoard(config);
    }

}
