package core.actions;

import java.util.Map;
import java.util.Objects;

import api.Action;
import api.KnowledgeGraph;
import core.KnowledgeNode;
import org.neo4j.graphdb.Label;

/**
 * TODO Add some meaningful class description...
 */
public class ActionInsertNode implements Action {

	private Label[] labels;

	private Map<String, Object> properties;

	@Override
	public void execute(KnowledgeGraph graph) {
		Objects.requireNonNull(graph);

		KnowledgeNode node = graph.createNode(labels);
		for (String key : properties.keySet()) {
			node.setProperty(key, properties.get(key));
		}
	}
}
