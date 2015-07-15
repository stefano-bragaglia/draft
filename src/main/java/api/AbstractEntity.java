package api;


import java.io.Serializable;
import java.util.*;

/**
 * TODO Add some meaningful class description...
 */
public abstract class AbstractEntity implements Entity {

    private static long count = Long.MIN_VALUE;

    protected final Map<String, Serializable> properties;

    private final long id = count++;

    public AbstractEntity() {
        this.properties = new HashMap<>();
    }

    @Override
    public void setProperty(String name, Serializable value) {
        Objects.requireNonNull(name);
        if ((name = name.trim()).isEmpty()) {
            throw new IllegalArgumentException("'name' is empty");
        }
        Objects.requireNonNull(value);

        properties.put(name, value);
    }

    @Override
    public Optional<Serializable> getProperty(String name) {
        Objects.requireNonNull(name);
        if ((name = name.trim()).isEmpty()) {
            throw new IllegalArgumentException("'name' is empty");
        }

        return properties.containsKey(name) ? Optional.of(properties.get(name)) : Optional.empty();
    }

    @Override
    public Collection<String> getProperties() {
        return properties.keySet();
    }

    @Override
    public boolean hasProperty(String name) {
        Objects.requireNonNull(name);
        if ((name = name.trim()).isEmpty()) {
            throw new IllegalArgumentException("'name' is empty");
        }

        return properties.containsKey(name);
    }

    @Override
    public void removeProperty(String name) {
        Objects.requireNonNull(name);
        if ((name = name.trim()).isEmpty()) {
            throw new IllegalArgumentException("'name' is empty");
        }

        properties.remove(name);
    }

    @Override
    public long getId() {
        return id;
    }

}
