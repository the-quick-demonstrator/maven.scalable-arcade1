package com.github.curriculeon.arcade.game.utils;

import com.github.curriculeon.arcade.utils.AbstractDecisionMenu;

/**
 * Created by leon on 2/25/18.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class GameSelectionMenu extends AbstractDecisionMenu<GameSelection> {
    public GameSelectionMenu() {
        super(GameSelection.values());
    }
}