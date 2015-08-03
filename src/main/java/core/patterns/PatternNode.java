package core.patterns;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import api.Pattern;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;

/**
 * TODO Add some meaningful class description...
 */
public class PatternNode implements Pattern {

	// MEMENTO Alpha node: tutto già staticamente specificato
	// MEMENTO Beta node: alcune cose sono specificate da altri alpha nodes (dinamico)


	private final String variable;

	private PatternNode(Builder builder) {
		Objects.requireNonNull(builder);

		this.variable = builder.variable;
	}

	public boolean isAssignment() {
		return null != variable;
	}

	public String getVariable() {
		return variable;
	}

	@Override
	public boolean match(GraphDatabaseService graph, Map<String, Object> assignments) {
		Objects.requireNonNull(graph);
		Objects.requireNonNull(assignments);

		return false;
	}

	public static class Builder {

		private String variable = null;

		private Set<Label> labels = new HashSet<>();

		public Builder() {
		}

		public Builder addLabel(Label label) {
			Objects.requireNonNull(label);

			this.labels.add(label);
			return this;
		}

		public Builder addLabels(Label... labels) {
			Objects.requireNonNull(labels);

			for (Label label : labels) {
				this.labels.add(label);
			}
			return this;
		}

		public Builder setVariable(String variable) {
			if (null != variable) {
				variable = variable.trim();
			}
			if (variable.isEmpty()) {
				this.variable = null;
			} else {
				this.variable = variable;
			}
			return this;
		}

	}

}