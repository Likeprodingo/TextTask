package by.shibaev.composite.component;

import by.shibaev.composite.component.impl.ComponentType;

import java.util.List;
import java.util.Optional;

public interface Component {
    boolean add(Component component);
    boolean remove(Component component);
    Optional<Component> getChild(int index);
    List<Component> getComponents();
    ComponentType getComponentType();
}
