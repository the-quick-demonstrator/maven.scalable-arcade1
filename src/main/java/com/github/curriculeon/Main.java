package com.github.curriculeon;

import com.github.curriculeon.arcade.Arcade;
import com.github.curriculeon.arcade.ArcadeInterface;

/**
 * Created by leon on 1/29/2017.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class Main {
    public static void main(String[] args) {
        ArcadeInterface arcade = new Arcade();
        arcade.run();
    }
}
