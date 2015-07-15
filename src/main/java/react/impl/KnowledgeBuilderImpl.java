package react.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import react.base.KnowledgeBuilder;
import react.base.KnowledgeGraph;
import react.base.Rule;
import react.base.RuleMemory;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeBuilderImpl implements KnowledgeBuilder {

	/**
	 *
	 */
	private final GraphDatabaseFactory factory;

	/**
	 * The {@code RuleMemory} containing the rules of this {@code KnowledgeBuilder}.
	 */
	private final RuleMemory memory;

	/**
	 * Default constructor.
	 */
	protected KnowledgeBuilderImpl() {
		this.factory = new GraphDatabaseFactory();
		this.memory = new RuleMemoryImpl();
	}

	@Override
	public void add(@NotNull Rule rule) {
		Objects.requireNonNull(rule);

		this.memory.add(rule);
	}

	@Override
	public void add(@NotNull RuleMemory memory) {
		Objects.requireNonNull(memory);

		this.memory.add(memory);
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

		this.remove(memory);
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

	@Override
	public KnowledgeGraph newKnowledgeGraph(String path) {
		Objects.requireNonNull(path);
		path = path.trim();
		if (path.isEmpty()) {
			throw new IllegalArgumentException("'path' is empty");
		}

		return new KnowledgeGraphImpl(factory.newEmbeddedDatabase(path), this.memory);
	}

}
