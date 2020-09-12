package by.shibaev.composite.parser.impl;

import by.shibaev.composite.component.Component;
import by.shibaev.composite.component.impl.AtomicComposite;
import by.shibaev.composite.component.impl.ComponentType;
import by.shibaev.composite.component.impl.TextComposite;
import by.shibaev.composite.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements BaseParser {

    @Override
    public Component parse(String text) {
        List<Component> atoms = new ArrayList<>();
        char[] chars = text.toCharArray();
        for (char element : chars) {
            ComponentType type = (Character.isLetterOrDigit(element))
                    ? ComponentType.LETTER : ComponentType.PUNCTUATION_MARK;
            AtomicComposite symbol = new AtomicComposite(element, type);
            atoms.add(symbol);
        }
        Component word = new TextComposite(atoms, ComponentType.WORD);
        return word;
    }
}
