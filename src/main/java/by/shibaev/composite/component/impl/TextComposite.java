package by.shibaev.composite.component.impl;

import by.shibaev.composite.component.Component;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TextComposite implements Component {
    private List<Component> components;
    private ComponentType componentType;

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
        components = new ArrayList<>();
    }

    public TextComposite(List<Component> components, ComponentType componentType) {
        this.components = components;
        this.componentType = componentType;
    }

    public List<Component> getComponents() {
        return Collections.unmodifiableList(components);
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public Component setComponentType(ComponentType componentType) {
        this.componentType = componentType;
        return this;
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return component.remove(component);
    }

    @Override
    public Optional<Component> getChild(int index) {
        Optional<Component> component = Optional.empty();
        if (index >= 0 && index < components.size()) {
            component = Optional.of(components.get(index));
        }
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (components != null ? !components.equals(that.components) : that.components != null) return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String delimiter = componentType == ComponentType.TEXT ? "\t" : " ";
        StringBuilder result = new StringBuilder("");
        if (componentType == ComponentType.WORD) {
            for (Component component : components) {
                result.append(component);
            }
        } else {
            for (Component component : components) {
                result.append(component).append(delimiter);
            }
        }
        return result.toString();
    }
}
