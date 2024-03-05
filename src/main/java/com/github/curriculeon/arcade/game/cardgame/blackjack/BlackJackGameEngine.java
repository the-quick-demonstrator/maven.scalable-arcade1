package com.github.curriculeon.arcade.game.cardgame.blackjack;

import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowGameDecision;
import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowGameDecisionMenu;
import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowPlayer;
import com.github.curriculeon.arcade.game.utils.AbstractGameEngine;
import com.github.curriculeon.utils.InputOutputSocketInterface;

public class BlackJackGameEngine extends AbstractGameEngine<BlackJackPlayer, BlackJackGame> implements InputOutputSocketInterface {
    public BlackJackGameEngine(BlackJackGame game) {
        super(game);
    }

    public BlackJackGameEngine() {
        super(new BlackJackGame());
    }

    @Override
    public void evaluateTurn(BlackJackPlayer blackJackPlayer) {
        BlackJackGameDecisionMenu highLowGameDecision = new BlackJackGameDecisionMenu();
        boolean playerTurnIsOver;
        do {
            BlackJackGameDecision decision = highLowGameDecision.getInput();
            decision.perform(getGame(), blackJackPlayer);
            getGame().run();

            playerTurnIsOver = true;
        } while (!playerTurnIsOver);
    }
}
