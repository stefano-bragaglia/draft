package example;

import react.base.KnowledgeBuilder;
import react.base.KnowledgeGraph;
import react.impl.KnowledgeFactory;
import react.impl.patterns.NodeTypePattern;

/**
 * Created by stefano on 11/07/2015.
 */
public class Application {

	public static void main(String[] args) {

		KnowledgeBuilder builder = KnowledgeFactory.newKnowledgeBuilder();
		builder.add(KnowledgeFactory.newRule(new NodeTypePattern("type")));
		KnowledgeGraph graph = builder.newKnowledgeGraph("./target/graph.db");

		System.out.println("Done.");
	}

}
