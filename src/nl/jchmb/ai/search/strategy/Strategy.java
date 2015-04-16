package nl.jchmb.ai.search.strategy;

import java.util.List;

import nl.jchmb.ai.search.evaluator.StateEvaluator;
import nl.jchmb.ai.search.expander.StateExpander;

public interface Strategy<T> {
	/**
	 * @param expander
	 * @param evaluator
	 * @param startState
	 * @return
	 */
	public List<T> search(
			StateExpander<T> expander,
			StateEvaluator<T> evaluator,
			T startState
	);
}
