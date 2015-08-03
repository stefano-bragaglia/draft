package core.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import api.Action;
import api.KnowledgeGraph;

/**
 * TODO Add some meaningful class description...
 */
public class ActionBlock implements Action, Iterable<Action> {

	private final List<Action> actions;

	public ActionBlock(List<Action> actions) {
		Objects.requireNonNull(actions);

		this.actions = new ArrayList<>(actions);
	}

	public ActionBlock() {
		this.actions = new ArrayList<>();
	}

	public void add(Action action) {
		Objects.requireNonNull(action);

		this.actions.add(action);
	}

	@Override
	public void execute(KnowledgeGraph graph) {
		Objects.requireNonNull(graph);

		for (Action action : actions) {
			action.execute(graph);
		}
	}

	@Override
	public Iterator<Action> iterator() {
		return actions.iterator();
	}

	public int size() {
		return actions.size();
	}
}
