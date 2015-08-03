package core.patterns;

import java.util.*;

/**
 * TODO Add some meaningful class description...
 */
public class AssignmentTable implements Cloneable, Iterable<String> {

	private final Map<String, Value> table;

	public AssignmentTable() {
		this.table = new HashMap<>();
	}

	private AssignmentTable(AssignmentTable other) {
		Objects.requireNonNull(other);

		this.table = new HashMap<>(other.table);
	}

	@Override
	public AssignmentTable clone() {
		return new AssignmentTable(this);
	}

	public boolean contains(String variable) {
		Objects.requireNonNull(variable);
		variable = variable.trim();
		if (variable.isEmpty()) {
			throw new IllegalArgumentException("'variable' is empty");
		}

		return table.containsKey(variable);
	}

	public Optional<Value> get(String variable) {
		Objects.requireNonNull(variable);
		variable = variable.trim();
		if (variable.isEmpty()) {
			throw new IllegalArgumentException("'variable' is empty");
		}

		return table.containsKey(variable) ? Optional.of(table.get(variable)) : Optional.<Value>empty();
	}

	public Collection<String> getVariables() {
		return table.keySet();
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	@Override
	public Iterator<String> iterator() {
		return table.keySet().iterator();
	}

	public void put(String variable, Value value) {
		Objects.requireNonNull(variable);
		if (table.containsKey(variable)) {
			throw new IllegalArgumentException("'variable' already assigned: " + variable);
		}
		Objects.requireNonNull(value);

		table.put(variable, value);
	}

	public int size() {
		return table.size();
	}

}
