package by.shibaev.composite.parser;

import by.shibaev.composite.component.Component;

public interface BaseParser {
    Component parse(String text);
}
