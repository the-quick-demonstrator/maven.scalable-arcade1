package com.github.curriculeon.arcade.game.utils;


import com.github.curriculeon.arcade.game.PlayerInterface;
import com.github.curriculeon.arcade.utils.DecisionInterface;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 * this class is used in conjunction with Enums to ensure Game has finite interactions with player
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface GameDecisionInterface<
        GameType extends GameInterface,
        PlayerType extends PlayerInterface> extends DecisionInterface {

    BiConsumer<GameType, PlayerType> getProcedure();

    default void perform(GameType game, PlayerType player) {
        getProcedure().accept(game, player);
    }
}
