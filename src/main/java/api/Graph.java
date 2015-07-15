package api;

import java.util.Collection;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Graph {

    Node createNode(String... types);

    Collection<Node> getNodes(String... types);

    void delete(Node node);

    void insert(Entity entity);

    void remove(Entity entity);

}
