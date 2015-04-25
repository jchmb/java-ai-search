package nl.jchmb.ai.search;

import java.util.List;

import nl.jchmb.ai.search.evaluator.Evaluator;
import nl.jchmb.ai.search.expander.Expander;
import nl.jchmb.ai.search.strategy.Strategy;

/**
 * Base Searcher class.
 * 
 * Requires three fundamental components to solve search problems of any type:
 * 
 * 1. An implementation of the StateExpander interface. Given any state x,
 *    it must return all possible subsequent states: {y_1, ..., y_n}.
 * 2. An implementation of the StateEvaluator interface. Given any state x,
 *    the StateEvaluator can determine whether it is a goal state, or not.
 *    All well-defined search problems need to be able to determine whether
 *    a given state is a goal state.
 * 3. An implementation of the Strategy interface, that will return a 
 *    path from a given start state to a goal state.
 */
public class Searcher<T> {
	private Expander<T> expander;
	private Evaluator<T> evaluator;
	private Strategy<T> strategy;
	
	public Searcher(Expander<T> expander, Evaluator<T> evaluator, Strategy<T> strategy) {
		this.expander = expander;
		this.evaluator = evaluator;
		this.strategy = strategy;
	}
	
	public List<T> search(T startState) {
		return strategy.search(expander, evaluator, startState);
	}
}
