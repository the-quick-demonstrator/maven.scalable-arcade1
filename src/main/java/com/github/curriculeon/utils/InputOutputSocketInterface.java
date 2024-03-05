package com.github.curriculeon.utils;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface InputOutputSocketInterface {
    default InputOutputConsoleInterface getConsole() {
        return new InputOutputConsole();
    }
}
