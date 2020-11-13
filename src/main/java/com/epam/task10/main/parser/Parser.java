package com.epam.task10.main.parser;

import com.epam.task10.main.model.Component;

public interface Parser {
    Component parse(String text);
}