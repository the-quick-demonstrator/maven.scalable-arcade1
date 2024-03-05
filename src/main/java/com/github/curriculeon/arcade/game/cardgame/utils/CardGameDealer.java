package com.github.curriculeon.arcade.game.cardgame.utils;

import com.github.curriculeon.arcade.game.cardgame.AbstractCardGamePlayer;
import com.github.curriculeon.arcade.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.profile.ProfileInterface;

/**
 * Created by leon on 6/27/2020.
 */
public class CardGameDealer extends AbstractCardGamePlayer {
    private Deck deck;

    public CardGameDealer(ProfileInterface profile, Deck deck) {
        super(profile);
        this.deck = deck;
    }

    public void shuffle() {
        deck.shuffle();
    }

    public CardInterface deal(CardGamePlayerInterface cardGamePlayer) {
        CardInterface card = deck.pop();
        cardGamePlayer.addCard(card);
        return card;
    }

    @Override
    public <ReturnType> ReturnType play() {
        return null;
    }
}
