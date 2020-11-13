package com.epam.task10.main.parser;

import com.epam.task10.main.model.Component;
import com.epam.task10.main.model.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    public Component parse(String text) {
        Pattern pattern = Pattern.compile(getPattern());
        Matcher matcher = pattern.matcher(text);

        List<Component> componentChildren = new ArrayList<>();
        while (matcher.find()) {
            String componentValue = matcher.group();
            process(componentChildren, componentValue);
        }
        return new Composite(componentChildren);
    }

    protected abstract String getPattern();

    protected void process(List<Component> children, String componentValue) {
        Component child = successor.parse(componentValue);
        children.add(child);
    }
}