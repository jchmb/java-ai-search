package nl.jchmb.ai.search.strategy;

import java.util.List;

import nl.jchmb.ai.search.evaluator.Evaluator;
import nl.jchmb.ai.search.expander.Expander;

public interface Strategy<T> {
	/**
	 * @param expander
	 * @param evaluator
	 * @param startState
	 * @return
	 */
	public List<T> search(
			Expander<T> expander,
			Evaluator<T> evaluator,
			T startState
	);
}
