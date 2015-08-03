package api;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import core.KnowledgeNode;

/**
 * Created by stefano on 12/07/2015.
 */
public interface KnowledgeGraph extends GraphDatabaseService {

	/**
	 * @return
	 */
	KnowledgeNode createNode();

	/**
	 * @param labels
	 * @return
	 */
	KnowledgeNode createNode(Label... labels);

	/**
	 *
	 */
	void fire();

}
