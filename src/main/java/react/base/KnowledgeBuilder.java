package react.base;

import org.jetbrains.annotations.NotNull;

/**
 * Created by stefano on 12/07/2015.
 */
public interface KnowledgeBuilder extends RuleMemory {

	/**
	 * @return
	 */
	public KnowledgeGraph newKnowledgeGraph(@NotNull String path);

}
