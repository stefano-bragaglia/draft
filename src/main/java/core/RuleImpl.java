package core;

import java.util.Objects;

import api.Pattern;
import api.Rule;

/**
 * Created by stefano on 11/07/2015.
 */
public class RuleImpl implements Rule {

	/**
	 *
	 */
	private final Pattern pattern;

	/**
	 * @param pattern
	 */
	protected RuleImpl(Pattern pattern) {
		Objects.requireNonNull(pattern);

		this.pattern = pattern;
	}

}
