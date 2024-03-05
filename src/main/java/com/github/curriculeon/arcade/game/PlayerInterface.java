package com.github.curriculeon.arcade.game;

import com.github.curriculeon.arcade.profile.ProfileInterface;

/**
 * Created by leon on 2/25/18.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface PlayerInterface {
    ProfileInterface getProfile();

    <ReturnType> ReturnType play();

    default String getName() {
        return getProfile().getName();
    }
}