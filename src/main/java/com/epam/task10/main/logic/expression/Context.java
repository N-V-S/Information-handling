package com.epam.task10.main.logic.expression;

import java.util.ArrayDeque;

/*private-package*/ class Context {

    private final ArrayDeque<Integer> values = new ArrayDeque<>();

    public Integer popValue() {
        return values.pop();
    }

    public void pushValue(Integer value) {
        values.push(value);
    }
}