package core;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import api.Pattern;
import api.KnowledgeBuilder;
import api.Rule;

/**
 * TODO Add some meaningful class description...
 */
public class KnowledgeFactory {

	/**
	 * @return
	 */
	public static KnowledgeBuilder newKnowledgeBuilder() {
		return new KnowledgeBuilderImpl();
	}

	/**
	 * @param pattern
	 * @return
	 */
	public static Rule newRule(@NotNull Pattern pattern) {
		Objects.requireNonNull(pattern);

		return new RuleImpl(pattern);
	}

}
