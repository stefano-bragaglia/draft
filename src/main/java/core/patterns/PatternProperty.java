package core.patterns;

import java.util.Objects;

import org.neo4j.graphdb.PropertyContainer;

/**
 * TODO Add some meaningful class description...
 */
public class PatternProperty {

	private final String variable;

	private final String key;

	private final Function function;

	private final Value value;

	private PatternProperty(Builder builder) {
		Objects.requireNonNull(builder);

		this.variable = builder.variable;
		this.key = builder.key;
		this.function = builder.function;
		this.value = builder.value;
	}

	public boolean hasAssignment() {
		return (null != variable);
	}

	public String getVariable() {
		return variable;
	}

	public String getKey() {
		return key;
	}

	public Function getFunction() {
		return function;
	}

	public Value getValue() {
		return value;
	}


	// MEMENTO equals, not equals, more than, less than, more than or equals to, less than or equals to
	// MEMENTO is empty, is not empty, contains, not contains,
	// MEMENTO ??? contains, starts with, ends with (also not && ignore case
	public boolean match(PropertyContainer element, AssignmentTable assignments) {
		Objects.requireNonNull(element);
		Objects.requireNonNull(assignments);

		if (!element.hasProperty(key)) {
			return false;
		}
		Object property = element.getProperty(key);
		boolean result = function.eval(value, property);
		if (result && null != variable) {
			assignments.put(variable, value);
		}
		return result;
	}

	public static class Builder {

		private String variable = null;

		private String key;

		private Function function;

		private Value value;

		public Builder(String key, Function function, Object value) {
			Objects.requireNonNull(key);
			key = key.trim();
			if (key.isEmpty()) {
				throw new IllegalArgumentException("'key' is empty");
			}
			Objects.requireNonNull(function);

			this.variable = null;
			this.key = key;
			this.function = function;
			this.value = new Value(value);
		}

		public Builder setKey(String key) {
			Objects.requireNonNull(key);
			key = key.trim();
			if (key.isEmpty()) {
				throw new IllegalArgumentException("'key' is empty");
			}

			this.key = key;
			return this;
		}

		public Builder setFunction(Function function) {
			Objects.requireNonNull(function);

			this.function = function;
			return this;
		}

		public Builder setVariable(String variable) {
			if (null != variable) {
				variable = variable.trim();
			}
			if (null == variable || variable.isEmpty()) {
				this.variable = variable;
			}
			return this;
		}

		public Builder setValue(Value value) {
			this.value = new Value(value);
			return this;
		}

	}

}
