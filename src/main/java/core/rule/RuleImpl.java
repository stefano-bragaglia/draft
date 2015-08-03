package core.rule;

import java.util.Objects;

import api.Action;
import api.Pattern;
import api.Rule;

/**
 * TODO Add some meaningful class description...
 */
public class RuleImpl implements Rule {

	private Pattern pattern;

	private Action action;

	public RuleImpl(Pattern pattern, Action action) {
		Objects.requireNonNull(pattern);
		Objects.requireNonNull(action);

		this.pattern = pattern;
		this.action = action;
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public Action getAction() {
		return action;
	}
}
