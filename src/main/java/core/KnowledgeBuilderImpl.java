package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;
import api.KnowledgeBuilder;
import api.KnowledgeGraph;
import api.Rule;
import api.ProductionMemory;

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
	private final ProductionMemory memory;

	/**
	 * Default constructor.
	 */
	protected KnowledgeBuilderImpl() {
		this.factory = new GraphDatabaseFactory();
		this.memory = new ProductionMemoryImpl();
	}

	@Override
	public void add(@NotNull Rule rule) {
		Objects.requireNonNull(rule);

		this.memory.add(rule);
	}

	@Override
	public void add(@NotNull ProductionMemory memory) {
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
	public void remove(@NotNull ProductionMemory memory) {
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
	public KnowledgeGraph newKnowledgeGraph(Path folder) {
		Objects.requireNonNull(folder);
		if (Files.exists(folder) && !Files.isDirectory(folder)) {
			throw new IllegalArgumentException("'folder' is not a directory: " + folder);
		}
		try {
			Files.createDirectories(folder);
		} catch (IOException ignored) {
			throw new IllegalArgumentException("'folder' is protected: " + folder);
		}

		GraphDatabaseService service = factory.newEmbeddedDatabase(folder.toString());
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try (Transaction tx = service.beginTx()) {
					Schema schema = service.schema();
					for (IndexDefinition definition : schema.getIndexes()) {
						definition.drop();
					}
					tx.success();
				}
				service.shutdown();
			}
		});
		return new KnowledgeGraphImpl(service, this.memory);
	}

}
