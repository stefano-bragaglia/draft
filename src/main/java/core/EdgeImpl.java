package core;

import api.AbstractEntity;
import api.Edge;
import api.Node;

import java.util.Objects;

/**
 * Created by stefano on 11/07/2015.
 */
public class EdgeImpl extends AbstractEntity implements Edge {

    private static final long serialVersionUID = 3755422491291390939L;

    private final Node tail;

    private final Node head;

    private final String type;

    public EdgeImpl(Node tail, String type, Node head) {
        Objects.requireNonNull(tail);
        Objects.requireNonNull(type);
        if ((type = type.trim()).isEmpty()) {
            throw new IllegalArgumentException("'type' is empty");
        }
        Objects.requireNonNull(head);

        this.head = head;
        this.tail = tail;
        this.type = type;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public Node getOther(Node node) {
        Objects.requireNonNull(node);
        if (!node.equals(tail) && !node.equals(head)) {
            throw new IllegalStateException("'node' is not used by this edge");
        }

        return node.equals(tail) ? head : tail;
    }

    @Override
    public void delete() {
        tail.delete(this);
        head.delete(this);
    }

}
