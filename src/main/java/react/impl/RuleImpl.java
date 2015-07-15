package react.impl;

import java.util.Objects;

import react.base.Pattern;
import react.base.Rule;

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
