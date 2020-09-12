package by.shibaev.composite.service;

import by.shibaev.composite.component.Component;
import by.shibaev.composite.component.impl.AtomicComposite;
import by.shibaev.composite.component.impl.ComponentType;
import by.shibaev.composite.component.impl.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextService {

    public List<Component> sortParagraphs(Component component) {
        List<Component> result = new ArrayList<>();
        if (component.getComponentType() == ComponentType.TEXT) {
            result = component.getComponents()
                    .stream()
                    .sorted(Comparator.comparingInt(c -> c.getComponents().size()))
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<Component> sortSentences(Component component) {
        List<Component> result = new ArrayList<>();
        if (component.getComponentType() == ComponentType.PARAGRAPH) {
            result = component.getComponents()
                    .stream()
                    .sorted(Comparator.comparingInt(c -> {
                        int sum = 0;
                        for (Component comp : c.getComponents()) {
                            sum += comp.getComponents().size();
                        }
                        return sum;
                    }))
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<Component> sortWords(Component component, String symbol) {
        List<Component> result = new ArrayList<>();
        if (component.getComponentType() == ComponentType.SENTENCE) {
            result = new ArrayList<>(component.getComponents());
            result.sort((b1, b2) -> {
                long c1 = b1.getComponents().stream().filter(ch -> ch.toString().equals(symbol)).count();
                long c2 = b2.getComponents().stream().filter(ch -> ch.toString().equals(symbol)).count();
                int res = (int) (c1 - c2);
                if (res == 0) {
                    res = b1.toString().compareToIgnoreCase(b2.toString());
                }
                return res;
            });
        }
        return result;
    }
}
