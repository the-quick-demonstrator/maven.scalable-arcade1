package com.github.curriculeon.arcade.game.cardgame.blackjack;

import com.github.curriculeon.arcade.game.utils.GameDecisionInterface;
import com.github.curriculeon.utils.InputOutputConsole;

import java.util.function.BiConsumer;

public enum BlackJackGameDecision implements GameDecisionInterface<BlackJackGame, BlackJackPlayer> {
    HIT(((blackJackGame, blackJackPlayer) -> {
        // TODO define logic
        final InputOutputConsole io = new InputOutputConsole();
        io.println("%s is attempting to hit", blackJackPlayer);
    })),
    STAY(((blackJackGame, blackJackPlayer) -> {
        // TODO define logic
        final InputOutputConsole io = new InputOutputConsole();
        io.println("%s is attempting to stay", blackJackPlayer);

    }));
    private BiConsumer<BlackJackGame, BlackJackPlayer> operation;

    BlackJackGameDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    @Override
    public BiConsumer<BlackJackGame, BlackJackPlayer> getProcedure() {
        return operation;
    }
}
