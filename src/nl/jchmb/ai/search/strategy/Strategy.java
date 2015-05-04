package nl.jchmb.ai.search.strategy;

import java.util.List;

import nl.jchmb.ai.search.evaluator.Terminator;
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
			Terminator<T> evaluator,
			T startState
	);
}
