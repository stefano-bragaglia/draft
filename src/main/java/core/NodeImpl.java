package core;

import api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by stefano on 11/07/2015.
 */
public class NodeImpl extends AbstractEntity implements Node {

    private static final long serialVersionUID = 9216136280167971282L;
    private static long count = Long.MIN_VALUE;

    private final long id = count++;

    private final Set<Edge> ingoing;

    private final Set<Edge> outgoing;

    private final Set<String> types;

    private final Graph graph;

    public NodeImpl(Graph graph, String... types) {
        Objects.requireNonNull(graph);
        Objects.requireNonNull(types);
        for (int i = 0; i < types.length; i++) {
            if ((types[i] = types[i].trim()).isEmpty()) {
                throw new IllegalArgumentException("'types' has an empty element");
            }
        }

        this.graph = graph;
        this.ingoing = new HashSet<>();
        this.outgoing = new HashSet<>();
        this.types = new HashSet<>(Arrays.asList(types));
    }

    @Override
    public boolean hasType(String type) {
        Objects.requireNonNull(type);

        return types.contains(type);
    }

    @Override
    public Edge createEdge(Node node, String type) {
        Objects.requireNonNull(node);
        Objects.requireNonNull(type);
        if ((type = type.trim()).isEmpty()) {
            throw new IllegalArgumentException("'type' is empty");
        }

        Edge edge = new EdgeImpl(this, type, node);
        outgoing.add(edge);
        ((NodeImpl) node).ingoing.add(edge);
        graph.insert(edge);
        return edge;
    }

    @Override
    public void delete() {
        if (!outgoing.isEmpty() || !ingoing.isEmpty()) {
            throw new IllegalStateException("This node has relationship/s");
        }

        graph.delete(this);
    }

    @Override
    public void delete(Edge edge) {
        Objects.requireNonNull(edge);

        this.ingoing.remove(edge);
        this.outgoing.remove(edge);
        graph.remove(edge);
    }

    @Override
    public int getIngoingDegree() {
        return ingoing.size();
    }

    @Override
    public int getOutgoingDegree() {
        return outgoing.size();
    }

    @Override
    public int getDegree() {
        return ingoing.size() + outgoing.size();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", types=" + types +
                ", properties=" + properties +
                '}';
    }
}
