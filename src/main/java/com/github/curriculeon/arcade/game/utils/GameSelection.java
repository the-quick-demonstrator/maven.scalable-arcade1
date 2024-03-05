package com.github.curriculeon.arcade.game.utils;


import com.github.curriculeon.arcade.game.cardgame.blackjack.BlackJackGameEngine;
import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowGameEngine;
import com.github.curriculeon.arcade.utils.DecisionInterface;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements DecisionInterface {
    HIGH_LOW(HighLowGameEngine::new),
    BLACKJACK(BlackJackGameEngine::new);

    private final Supplier<GameEngineInterface<?,?>> gameConstructor;

    GameSelection(Supplier<GameEngineInterface<?,?>> gameConstructor) {
        this.gameConstructor = gameConstructor;
    }

    public void perform() {
        GameEngineInterface<?, ?> gameEngine = create();
        gameEngine.setUp();
        gameEngine.run();
    }

    public GameEngineInterface<?,?> create() {
        return gameConstructor.get();
    }
}
