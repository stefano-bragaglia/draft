package react.impl;

import java.util.*;

import org.jetbrains.annotations.NotNull;
import react.base.Rule;
import react.base.RuleMemory;

/**
 * TODO Add some meaningful class description...
 */
public class RuleMemoryImpl implements RuleMemory {

	/**
	 * The memory containing the rules of this {@code RuleMemory}.
	 */
	private final Set<Rule> memory;

	/**
	 * Default constructor.
	 */
	protected RuleMemoryImpl() {
		this.memory = new HashSet<>();
	}

	@Override
	public void add(@NotNull Rule rule) {
		Objects.requireNonNull(rule);

		this.memory.add(rule);
	}

	@Override
	public void add(@NotNull RuleMemory memory) {
		Objects.requireNonNull(memory);

		for (Rule rule : memory) {
			this.memory.add(rule);
		}
	}

	@Override
	public void addAll(@NotNull Collection<Rule> rules) {
		Objects.requireNonNull(rules);

		this.memory.addAll(rules);
	}

	@Override
	public void clear() {
		this.memory.clear();
	}

	@Override
	public boolean contains(@NotNull Rule rule) {
		Objects.requireNonNull(rule);

		return this.memory.contains(rule);
	}

	@Override
	public boolean isEmpty() {
		return this.memory.isEmpty();
	}

	@Override
	public Iterator<Rule> iterator() {
		return this.memory.iterator();
	}

	@Override
	public void remove(@NotNull Rule rule) {
		Objects.requireNonNull(rule);

		this.memory.remove(rule);
	}

	@Override
	public void remove(@NotNull RuleMemory memory) {
		Objects.requireNonNull(memory);

		for (Rule rule : memory) {
			this.memory.remove(rule);
		}
	}

	@Override
	public void removeAll(@NotNull Collection<Rule> rules) {
		Objects.requireNonNull(rules);

		this.memory.removeAll(rules);
	}

	@Override
	public int size() {
		return this.memory.size();
	}

}
