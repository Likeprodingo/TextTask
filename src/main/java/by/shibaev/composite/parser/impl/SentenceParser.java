package by.shibaev.composite.parser.impl;

import by.shibaev.composite.component.Component;
import by.shibaev.composite.component.impl.ComponentType;
import by.shibaev.composite.component.impl.TextComposite;
import by.shibaev.composite.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements BaseParser {
    private static final String WORD = "\\s*\\S+\\s*";
    @Override
    public Component parse(String text) {
        WordParser parser = new WordParser();
        List<Component> words = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            Component component = parser.parse(word.strip());
            words.add(component);
        }
        return new TextComposite(words, ComponentType.SENTENCE);
    }
}
