package core;

import api.Entity;
import api.Graph;
import api.Node;
import react.base.Pattern;

import java.util.*;

/**
 * Created by stefano on 11/07/2015.
 */
public class GraphImpl implements Graph {

    protected final Map<Pattern, Set<Entity>> memories;
    private final Set<Node> nodes;
    private final Map<String, Set<Node>> types;

    public GraphImpl() {
        nodes = new HashSet<>();
        types = new HashMap<>();

        memories = new HashMap<>();
    }

    @Override
    public Node createNode(String... types) {
        Objects.requireNonNull(types);

        Node node = new NodeImpl(this, types);
        for (String type : types) {
            Set<Node> set = this.types.get(type);
            if (null == set) {
                set = new HashSet<>();
                this.types.put(type, set);
            }
            set.add(node);
        }
        nodes.add(node);
        insert(node);
        return node;
    }

    @Override
    public Collection<Node> getNodes(String... types) {
        Objects.requireNonNull(types);

        if (0 == types.length) {
            return nodes;
        }
        Set<Node> result = new HashSet<>();
        for (String type : types) {
            result.addAll(this.types.getOrDefault(type, Collections.emptySet()));
        }
        return nodes;
    }

    @Override
    public void delete(Node node) {
        Objects.requireNonNull(node);

        this.nodes.remove(node);
        for (Set<Node> nodes : types.values()) {
            nodes.remove(node);
        }
        remove(node);
    }

    @Override
    public void insert(Entity entity) {
        Objects.requireNonNull(entity);

        for (Pattern pattern : memories.keySet()) {
            if (pattern.match(entity)) {
                memories.get(pattern).add(entity);
            }
        }
    }

    @Override
    public void remove(Entity entity) {
        Objects.requireNonNull(entity);

        for (Pattern pattern : memories.keySet()) {
            if (pattern.match(entity)) {
                memories.get(pattern).remove(entity);
            }
        }
    }

    public Transaction openTransaction() {
        return new Transaction();
    }

}
