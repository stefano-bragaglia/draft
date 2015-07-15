package react.impl;

import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.KernelEventHandler;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.graphdb.traversal.BidirectionalTraversalDescription;
import org.neo4j.graphdb.traversal.TraversalDescription;
import react.base.KnowledgeGraph;
import react.base.RuleMemory;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeGraphImpl implements KnowledgeGraph {

	/**
	 * The {@code RuleMemory} containing the rules of this {@code KnowledgeGraph}.
	 */
	private RuleMemory memory;

	/**
	 *
	 */
	private GraphDatabaseService database;

	/**
	 * Default constructor.
	 *
	 * @param database
	 * @param memory the {@code RuleMemory} containing the rules of this {@code KnowledgeGraph}
	 */
	protected KnowledgeGraphImpl(@NotNull GraphDatabaseService database, @NotNull RuleMemory memory) {
		Objects.requireNonNull(database);
		Objects.requireNonNull(memory);

		this.database = database;
		this.memory = new RuleMemoryImpl();
		this.memory.add(memory);
	}

	@Override
	public Node createNode() {
		return new KnowledgeNode(database.createNode());
	}

	@Override
	public Node createNode(Label... labels) {
		return new KnowledgeNode(database.createNode(labels));
	}

	@Override
	public Node getNodeById(long id) {
		return database.getNodeById(id);
	}

	@Override
	public Relationship getRelationshipById(long id) {
		return database.getRelationshipById(id);
	}

	@Override
	@Deprecated
	public Iterable<Node> getAllNodes() {
		return database.getAllNodes();
	}

	@Override
	public ResourceIterator<Node> findNodes(Label label, String key, Object value) {
		return database.findNodes(label, key, value);
	}

	@Override
	public Node findNode(Label label, String key, Object value) {
		return database.findNode(label, key, value);
	}

	@Override
	public ResourceIterator<Node> findNodes(Label label) {
		return findNodes(label);
	}

	@Override
	public ResourceIterable<Node> findNodesByLabelAndProperty(Label label, String key, Object value) {
		return findNodesByLabelAndProperty(label, key, value);
	}

	@Override
	public Iterable<RelationshipType> getRelationshipTypes() {
		return getRelationshipTypes();
	}

	@Override
	public boolean isAvailable(long timeout) {
		return database.isAvailable(timeout);
	}

	@Override
	public void shutdown() {
		database.shutdown();
	}

	@Override
	public Transaction beginTx() {
		return database.beginTx();
	}

	@Override
	public Result execute(String query) throws QueryExecutionException {
		return database.execute(query);
	}

	@Override
	public Result execute(String query, Map<String, Object> parameters) throws QueryExecutionException {
		return database.execute(query, parameters);
	}

	@Override
	public <T> TransactionEventHandler<T> registerTransactionEventHandler(TransactionEventHandler<T> handler) {
		return database.registerTransactionEventHandler(handler);
	}

	@Override
	public <T> TransactionEventHandler<T> unregisterTransactionEventHandler(TransactionEventHandler<T> handler) {
		return database.unregisterTransactionEventHandler(handler);
	}

	@Override
	public KernelEventHandler registerKernelEventHandler(KernelEventHandler handler) {
		return database.registerKernelEventHandler(handler);
	}

	@Override
	public KernelEventHandler unregisterKernelEventHandler(KernelEventHandler handler) {
		return database.unregisterKernelEventHandler(handler);
	}

	@Override
	public Schema schema() {
		return database.schema();
	}

	@Override
	public IndexManager index() {
		return database.index();
	}

	@Override
	public TraversalDescription traversalDescription() {
		return database.traversalDescription();
	}

	@Override
	public BidirectionalTraversalDescription bidirectionalTraversalDescription() {
		return database.bidirectionalTraversalDescription();
	}

}
