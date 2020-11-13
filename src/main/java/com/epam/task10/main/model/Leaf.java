package com.epam.task10.main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Leaf implements Component {

    private final LeafType type;
    private final String value;

    private Leaf(LeafType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Leaf word(String value) {
        return new Leaf(LeafType.WORD, value);
    }

    public static Leaf expression(String value) {
        return new Leaf(LeafType.EXPRESSION, value);
    }

    public String getValue() {
        return value;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<Component>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return type == leaf.type &&
                Objects.equals(value, leaf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}