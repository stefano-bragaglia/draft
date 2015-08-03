package core;

import java.util.Map;
import java.util.Objects;

import api.KnowledgeGraph;
import api.ProductionMemory;
import api.WorkingMemory;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.KernelEventHandler;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.graphdb.traversal.BidirectionalTraversalDescription;
import org.neo4j.graphdb.traversal.TraversalDescription;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeGraphImpl implements KnowledgeGraph {

	/**
	 * The {@code RuleMemory} containing the rules of this {@code KnowledgeGraph}.
	 */
	private final ProductionMemory ruleMemory;

	/**
	 * The {@code WorkingMemory} containing the graph entities by matched patterns of this {@code KnowledgeGraph}.
	 */
	private final WorkingMemory workingMemory;

	/**
	 *
	 */
	private final GraphDatabaseService database;

	/**
	 * Default constructor.
	 *
	 * @param database
	 * @param ruleMemory the {@code RuleMemory} containing the rules of this {@code KnowledgeGraph}
	 */
	protected KnowledgeGraphImpl(@NotNull GraphDatabaseService database, @NotNull ProductionMemory ruleMemory) {
		Objects.requireNonNull(database);
		Objects.requireNonNull(ruleMemory);

		this.database = database;
		this.ruleMemory = new ProductionMemoryImpl();
		this.ruleMemory.add(ruleMemory);
		this.workingMemory = new WorkingMemoryImpl();
	}

	@Override
	public KnowledgeNode createNode() {
		Node node = database.createNode();
		workingMemory.insert(node);
		return new KnowledgeNode(workingMemory, node);
	}

	@Override
	public KnowledgeNode createNode(Label... labels) {
		Node node = database.createNode(labels);
		workingMemory.insert(node);
		return new KnowledgeNode(workingMemory, node);
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

	@Override
	public void fire() {
		throw new UnsupportedOperationException("Will trigger the firing of all the rules");
	}
}
