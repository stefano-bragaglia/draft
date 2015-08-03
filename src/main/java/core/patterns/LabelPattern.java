package core.patterns;

import java.util.Objects;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import api.Pattern;

/**
 * Created by stefano on 11/07/2015.
 */
public class LabelPattern implements Pattern {

	private final Label label;

	public LabelPattern(Label label) {
		Objects.requireNonNull(label);

		this.label = label;
	}

	@Override
	public boolean match(Node node) {
		Objects.requireNonNull(node);

		return node.hasLabel(label);
	}
}
