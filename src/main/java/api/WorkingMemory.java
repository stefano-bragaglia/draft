package api;

import org.neo4j.graphdb.Node;

/**
 * TODO Add some meaningful class description...
 */
public interface WorkingMemory {

	void insert(Node node);

	void retract(Node node);

}
