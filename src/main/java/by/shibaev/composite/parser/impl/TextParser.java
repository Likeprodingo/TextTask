package by.shibaev.composite.parser.impl;

import by.shibaev.composite.component.Component;
import by.shibaev.composite.component.impl.ComponentType;
import by.shibaev.composite.component.impl.TextComposite;
import by.shibaev.composite.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements BaseParser {
    private static final String PARAGRAPH = "\\t[^\\t]+";


    @Override
    public Component parse(String text) {
        ParagraphParser paragraphParser = new ParagraphParser();
        List<Component> paragraphs = new ArrayList<>();
        Pattern pattern = Pattern.compile(PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String paragraph = matcher.group();
            Component component = paragraphParser.parse(paragraph.strip());
            paragraphs.add(component);
        }
        return new TextComposite(paragraphs, ComponentType.TEXT);
    }
}
