package api;

/**
 * TODO Add some meaningful class description...
 */
public interface Action {

	void execute(KnowledgeGraph graph);

	// insert(new Pippo(1, "pluto", obj, $p);

	// insert(new Label(
	//   value: 1,
	//   name: "pluto",
	//   object: obj,
	//   param: $p);

	// (charlie:Person { name:'Charlie Sheen' })

	// ( $n : Label { value: 1, name: "pluto", object: obj, param: $p })

	// ( $n : Label { $v: value, name: "pluto", object: obj, param: $p })

	// Se è $param : label o prop significa assignment -- prop : $param significa passaggio


}
