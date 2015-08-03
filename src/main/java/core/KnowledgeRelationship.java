package core;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeRelationship implements Relationship {

	private final Relationship relationship;

	protected KnowledgeRelationship(@NotNull Relationship relationship) {
		Objects.requireNonNull(relationship);

		this.relationship = relationship;
	}

	@Override
	public long getId() {
		return relationship.getId();
	}

	@Override
	public void delete() {
		// MEMENTO remove from working memory
		relationship.delete();
	}

	@Override
	public Node getStartNode() {
		return relationship.getStartNode();
	}

	@Override
	public Node getEndNode() {
		return relationship.getEndNode();
	}

	@Override
	public Node getOtherNode(Node node) {
		return relationship.getOtherNode(node);
	}

	@Override
	public Node[] getNodes() {
		return relationship.getNodes();
	}

	@Override
	public RelationshipType getType() {
		return relationship.getType();
	}

	@Override
	public boolean isType(RelationshipType type) {
		return relationship.isType(type);
	}

	@Override
	public GraphDatabaseService getGraphDatabase() {
		return relationship.getGraphDatabase();
	}

	@Override
	public boolean hasProperty(String key) {
		return relationship.hasProperty(key);
	}

	@Override
	public Object getProperty(String key) {
		return relationship.getProperty(key);
	}

	@Override
	public Object getProperty(String key, Object defaultValue) {
		return relationship.getProperty(key, defaultValue);
	}

	@Override
	public void setProperty(String key, Object value) {
		// MEMENTO update working memory?
		relationship.setProperty(key, value);
	}

	@Override
	public Object removeProperty(String key) {
		// MEMENTO update working memory?
		return relationship.removeProperty(key);
	}

	@Override
	public Iterable<String> getPropertyKeys() {
		return relationship.getPropertyKeys();
	}
}
