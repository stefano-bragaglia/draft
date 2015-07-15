package react.base;

import java.util.Collection;
import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

/**
 * A {@code RuleMemory} represents a group of objects, known as its rules (see {@see Rule}).
 */
public interface RuleMemory extends Iterable<Rule> {

	/**
	 * Adds the specified rule to this {@code RuleMemory} if it is not already present.
	 *
	 * @param rule the rule to be added to this {@code RuleMemory}
	 */
	void add(@NotNull Rule rule);

	/**
	 * Adds all of the rules in the specified {@code RuleMemory} to this {@code RuleMemory}.
	 *
	 * @param memory the {@code RuleMemory} containing the rules to be added to this {@code RuleMemory}
	 */
	void add(@NotNull RuleMemory memory);

	/**
	 * Adds all of the rules in the specified collection to this {@code RuleMemory}.
	 *
	 * @param rules the collection containing the rules to be added to this {@code RuleMemory}
	 */
	void addAll(@NotNull Collection<Rule> rules);

	/**
	 * Removes all of the rules from this {@code RuleMemory}.
	 */
	void clear();

	/**
	 * Returns {@code true} if this {@code RuleMemory} contains the specified rule.
	 *
	 * @param rule the rule whose presence in this {@code RuleMemory} is to be tested
	 * @return {@code true} if this collection contains the specified element
	 */
	boolean contains(@NotNull Rule rule);

	/**
	 * Returns {@code true} if this {@code RuleMemory} contains no rules.
	 *
	 * @return {@code true} if this {@code RuleMemory} contains no rules
	 */
	boolean isEmpty();

	/**
	 * Returns an iterator over the rules of this {@code RuleMemory}.
	 *
	 * @return an iterator over the rules of this {@code RuleMemory}
	 */
	Iterator<Rule> iterator();

	/**
	 * Removes the specified rule from this {@code RuleMemory}, if it is present.
	 *
	 * @param rule the rule to be removed from this {@code RuleMemory}, if present
	 */
	void remove(@NotNull Rule rule);

	/**
	 * Removes all of this {@code RuleMemory}'s rules that are also contained in the specified {@code RuleMemory}.
	 *
	 * @param memory the {@code RuleMemory} containing the rules to be removed from this {@code RuleMemory}
	 */
	void remove(@NotNull RuleMemory memory);

	/**
	 * Removes all of this {@code RuleMemory}'s rules that are also contained in the specified collection.
	 *
	 * @param rules the collection containing the rules to be removed from this {@code RuleMemory}
	 */
	void removeAll(@NotNull Collection<Rule> rules);

	/**
	 * Returns the number of rules in this {@code RuleMemory}.
	 *
	 * @return the number of rules in this {@code RuleMemory}
	 */
	int size();

}
