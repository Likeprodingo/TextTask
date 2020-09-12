package by.shibaev.composite.component.impl;

import by.shibaev.composite.component.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AtomicComposite implements Component {

    private char component;
    private ComponentType componentType;

    public AtomicComposite(char component, ComponentType componentType) {
        this.component = component;
        this.componentType = componentType;
    }

    public char getComponent() {
        return component;
    }

    public void setComponent(char component) {
        this.component = component;
    }

    @Override
    public List<Component> getComponents() {
        return new ArrayList<>();
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }

    @Override
    public Optional<Component> getChild(int index) {
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtomicComposite that = (AtomicComposite) o;

        if (component != that.component) return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = component;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(component);
    }
}
