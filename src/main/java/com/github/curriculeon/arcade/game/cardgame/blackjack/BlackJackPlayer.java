package com.github.curriculeon.arcade.game.cardgame.blackjack;

import com.github.curriculeon.arcade.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.profile.ProfileInterface;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements CardGamePlayerInterface {
    private List<CardInterface> hand;
    private ProfileInterface profile;

    public BlackJackPlayer(ProfileInterface profile) {
        this(new ArrayList<>(), profile);
    }

    public BlackJackPlayer(List<CardInterface> hand, ProfileInterface profile) {
        this.hand = hand;
        this.profile = profile;
    }

    @Override
    public ProfileInterface getProfile() {
        return profile;
    }

    @Override
    public BlackJackGameDecision play() {
        return null; // TODO
    }

    @Override
    public List<CardInterface> getHand() {
        return hand;
    }

    @Override
    public void setHand(List<CardInterface> cardList) {
        this.hand = cardList;
    }
}
