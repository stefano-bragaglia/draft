package react.base;

import org.neo4j.graphdb.Node;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Pattern {

    /**
     * @param node
     * @return
     */
    boolean match(Node node);

}
