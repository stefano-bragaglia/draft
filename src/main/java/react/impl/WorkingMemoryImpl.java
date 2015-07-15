package react.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import react.base.Pattern;
import react.base.WorkingMemory;

/**
 * TODO Add some meaningful class description...
 */
public class WorkingMemoryImpl implements WorkingMemory {

	private final Map<Pattern, Set<Node>> nodes;

	private final Map<Pattern, Set<Relationship>> relationships;

	/**
	 * Default constructor.
	 */
	protected WorkingMemoryImpl() {
		this.nodes = new HashMap<>();
		this.relationships = new HashMap<>();
	}

	@Override
	public void insert(Node node) {
		Objects.requireNonNull(node);

		for (Pattern pattern : nodes.keySet()) {
			if (pattern.match(node)) {
				System.err.println("Node " + node + "added to " + pattern);
				nodes.get(pattern).add(node);
			}
		}
	}

	@Override
	public void retract(Node node) {
		Objects.requireNonNull(node);

		for (Pattern pattern : nodes.keySet()) {
			if (pattern.match(node)) {
				nodes.get(pattern).remove(node);
			}
		}
	}

}
