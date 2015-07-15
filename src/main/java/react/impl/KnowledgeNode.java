package react.impl;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeNode implements Node {

	private final Node node;

	protected KnowledgeNode(@NotNull Node node) {
		Objects.requireNonNull(node);

		this.node = node;
	}

	@Override
	public long getId() {
		return node.getId();
	}

	@Override
	public void delete() {
		node.delete();
		// MEMENTO remove from working memmory
	}

	@Override
	public Iterable<Relationship> getRelationships() {
		return node.getRelationships();
	}

	@Override
	public boolean hasRelationship() {
		return node.hasRelationship();
	}

	@Override
	public Iterable<Relationship> getRelationships(RelationshipType... types) {
		return node.getRelationships(types);
	}

	@Override
	public Iterable<Relationship> getRelationships(Direction direction, RelationshipType... types) {
		return node.getRelationships(direction, types);
	}

	@Override
	public boolean hasRelationship(RelationshipType... types) {
		return node.hasRelationship(types);
	}

	@Override
	public boolean hasRelationship(Direction direction, RelationshipType... types) {
		return node.hasRelationship(direction, types);
	}

	@Override
	public Iterable<Relationship> getRelationships(Direction dir) {
		return node.getRelationships(dir);
	}

	@Override
	public boolean hasRelationship(Direction dir) {
		return node.hasRelationship(dir);
	}

	@Override
	public Iterable<Relationship> getRelationships(RelationshipType type, Direction dir) {
		return node.getRelationships(type, dir);
	}

	@Override
	public boolean hasRelationship(RelationshipType type, Direction dir) {
		return node.hasRelationship(type, dir);
	}

	@Override
	public Relationship getSingleRelationship(RelationshipType type, Direction dir) {
		return node.getSingleRelationship(type, dir);
	}

	@Override
	public Relationship createRelationshipTo(Node otherNode, RelationshipType type) {
		// MEMENTO add to working memory
		return node.createRelationshipTo(otherNode, type);
	}

	@Override
	public Iterable<RelationshipType> getRelationshipTypes() {
		return node.getRelationshipTypes();
	}

	@Override
	public int getDegree() {
		return node.getDegree();
	}

	@Override
	public int getDegree(RelationshipType type) {
		return node.getDegree(type);
	}

	@Override
	public int getDegree(Direction direction) {
		return node.getDegree(direction);
	}

	@Override
	public int getDegree(RelationshipType type, Direction direction) {
		return node.getDegree(type, direction);
	}

	@Override
	@Deprecated
	public Traverser traverse(Traverser.Order traversalOrder, StopEvaluator stopEvaluator, ReturnableEvaluator
			returnableEvaluator, RelationshipType relationshipType, Direction direction) {
		return node.traverse(traversalOrder, stopEvaluator, returnableEvaluator, relationshipType, direction);
	}

	@Override
	@Deprecated
	public Traverser traverse(Traverser.Order traversalOrder, StopEvaluator stopEvaluator, ReturnableEvaluator
			returnableEvaluator, RelationshipType firstRelationshipType, Direction firstDirection, RelationshipType
									  secondRelationshipType, Direction secondDirection) {
		return node.traverse(traversalOrder,
							 stopEvaluator,
							 returnableEvaluator,
							 firstRelationshipType,
							 firstDirection,
							 secondRelationshipType,
							 secondDirection);
	}

	@Override
	@Deprecated
	public Traverser traverse(Traverser.Order traversalOrder, StopEvaluator stopEvaluator, ReturnableEvaluator
			returnableEvaluator, Object... relationshipTypesAndDirections) {
		return node.traverse(traversalOrder, stopEvaluator, returnableEvaluator, relationshipTypesAndDirections);
	}

	@Override
	public void addLabel(Label label) {
		node.addLabel(label);
	}

	@Override
	public void removeLabel(Label label) {
		node.removeLabel(label);
	}

	@Override
	public boolean hasLabel(Label label) {
		return node.hasLabel(label);
	}

	@Override
	public Iterable<Label> getLabels() {
		return node.getLabels();
	}

	@Override
	public GraphDatabaseService getGraphDatabase() {
		return node.getGraphDatabase();
	}

	@Override
	public boolean hasProperty(String key) {
		return node.hasProperty(key);
	}

	@Override
	public Object getProperty(String key) {
		return node.getProperty(key);
	}

	@Override
	public Object getProperty(String key, Object defaultValue) {
		return node.getProperty(key, defaultValue);
	}

	@Override
	public void setProperty(String key, Object value) {
		// MEMENTO update working memory?
		node.setProperty(key, value);
	}

	@Override
	public Object removeProperty(String key) {
		// MEMENTO update working memory?
		return node.removeProperty(key);
	}

	@Override
	public Iterable<String> getPropertyKeys() {
		return node.getPropertyKeys();
	}

}
