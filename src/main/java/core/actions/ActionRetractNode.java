package core.actions;

import java.util.Objects;

import api.Action;
import api.KnowledgeGraph;
import org.neo4j.graphdb.Node;

/**
 * TODO Add some meaningful class description...
 */
public class ActionRetractNode implements Action {

	private Node node;

	@Override
	public void execute(KnowledgeGraph graph) {
		Objects.requireNonNull(graph);

		node.delete();
	}

}
