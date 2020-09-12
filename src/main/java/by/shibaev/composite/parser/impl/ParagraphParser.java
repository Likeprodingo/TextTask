package by.shibaev.composite.parser.impl;

import by.shibaev.composite.component.Component;
import by.shibaev.composite.component.impl.ComponentType;
import by.shibaev.composite.component.impl.TextComposite;
import by.shibaev.composite.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements BaseParser {
    private static final String SENTENCE = "(\\p{Alpha}*[',\\-\\(\\)\\*\\/\\+]*\\p{Digit}*\\s*)+[" +
            ".\\u2026?!]{1}";

    @Override
    public Component parse(String text) {
        SentenceParser parser = new SentenceParser();
        List<Component> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            Component component = parser.parse(sentence.strip());
            sentences.add(component);
        }
        return new TextComposite(sentences, ComponentType.PARAGRAPH);
    }
}
