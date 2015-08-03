package example;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;
import api.KnowledgeBuilder;
import api.KnowledgeGraph;
import core.KnowledgeFactory;
import core.KnowledgeNode;
import core.patterns.LabelPattern;

/**
 * Created by stefano on 11/07/2015.
 */
public class Application {

	private static Path db = Paths.get("./target/graph.db");

	private static Label label = DynamicLabel.label("label");

	public static void main(String[] args) {

//		db = db.toAbsolutePath();

		KnowledgeBuilder builder = KnowledgeFactory.newKnowledgeBuilder();

		builder.deleteKnowledgeGraph(db);

		builder.add(KnowledgeFactory.newRule(new LabelPattern(label)));

		KnowledgeGraph graph = builder.newKnowledgeGraph(db);

		KnowledgeNode node = null;
		try (Transaction tx = graph.beginTx()) {
			node = graph.createNode();
			node.setProperty("key", "value");
			tx.success(); // in theory add them to working memory only now
		}

		try (Transaction tx = graph.beginTx()) {
			node.delete();
			tx.success(); // in theory add them to working memory only now
		}

		System.out.println("Done.");
	}

}
