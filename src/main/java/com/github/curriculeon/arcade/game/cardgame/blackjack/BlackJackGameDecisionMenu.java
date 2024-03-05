package com.github.curriculeon.arcade.game.cardgame.blackjack;

import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowGameDecision;
import com.github.curriculeon.arcade.utils.AbstractDecisionMenu;

public class BlackJackGameDecisionMenu extends AbstractDecisionMenu<BlackJackGameDecision> {
    public  BlackJackGameDecisionMenu() {
        super(BlackJackGameDecision.values());
    }
}
