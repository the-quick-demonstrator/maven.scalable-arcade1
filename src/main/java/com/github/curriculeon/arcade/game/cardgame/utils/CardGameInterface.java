package com.github.curriculeon.arcade.game.cardgame.utils;

import com.github.curriculeon.arcade.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.game.utils.GameInterface;

public interface CardGameInterface<
        CardGamePlayerType extends CardGamePlayerInterface>
        extends GameInterface<CardGamePlayerType> {
    DiscardPile getDiscardPile();

    Deck getDeck();
}
