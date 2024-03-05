package com.github.curriculeon.utils;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class Pair<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;

    public Pair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }
}

