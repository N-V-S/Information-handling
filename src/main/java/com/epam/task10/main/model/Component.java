package com.epam.task10.main.model;

import java.util.List;

public interface Component {
    List<Component> getChildren();
}