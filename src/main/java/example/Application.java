package example;

import java.nio.file.Path;
import java.nio.file.Paths;

import react.base.KnowledgeBuilder;
import react.base.KnowledgeGraph;
import react.impl.KnowledgeFactory;
import react.impl.patterns.NodeTypePattern;

/**
 * Created by stefano on 11/07/2015.
 */
public class Application {

	private static Path db = Paths.get("./target/graph.db");

	public static void main(String[] args) {

//		db = db.toAbsolutePath();

		KnowledgeBuilder builder = KnowledgeFactory.newKnowledgeBuilder();

		builder.deleteKnowledgeGraph(db);

		builder.add(KnowledgeFactory.newRule(new NodeTypePattern("type")));

		KnowledgeGraph graph = builder.newKnowledgeGraph(db);

		System.out.println("Done.");
	}

}
