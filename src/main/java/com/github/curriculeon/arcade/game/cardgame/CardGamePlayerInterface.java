package com.github.curriculeon.arcade.game.cardgame;

import com.github.curriculeon.arcade.game.PlayerInterface;
import com.github.curriculeon.arcade.game.cardgame.utils.card.CardInterface;

import java.util.List;

/**
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface CardGamePlayerInterface extends PlayerInterface {
    List<CardInterface> getHand();

    void setHand(List<CardInterface> cardList);

    default void addCard(CardInterface card) {
        getHand().add(card);
    }

    default void removeCard(CardInterface card) {
        getHand().remove(card);
    }
}
