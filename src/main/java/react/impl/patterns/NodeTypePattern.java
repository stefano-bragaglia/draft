package react.impl.patterns;

import api.Entity;
import api.Node;
import react.base.Pattern;

import java.util.Objects;

/**
 * Created by stefano on 11/07/2015.
 */
public class NodeTypePattern implements Pattern {

    private final String type;

    public NodeTypePattern(String type) {
        Objects.requireNonNull(type);
        type = type.trim();
        if (type.isEmpty()) {
            throw new IllegalArgumentException("'type' is empty");
        }

        this.type = type;
    }


    @Override
    public boolean match(Entity entity) {
        Objects.requireNonNull(entity);

        return (entity instanceof Node) && ((Node) entity).hasType(type);
    }

}
