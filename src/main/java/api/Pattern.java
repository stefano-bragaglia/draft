package api;

import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Pattern {

    /**
     * @param graph
     * @return
     */
    boolean match(GraphDatabaseService graph, Map<String, Object> assignments);

}
