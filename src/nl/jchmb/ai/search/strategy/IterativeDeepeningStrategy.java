package nl.jchmb.ai.search.strategy;

import java.util.List;

import nl.jchmb.ai.search.evaluator.StateEvaluator;
import nl.jchmb.ai.search.expander.StateExpander;

public class IterativeDeepeningStrategy<T> implements Strategy<T> {
	@Override
	public List<T> search(StateExpander<T> expander,
			StateEvaluator<T> evaluator, T startState) {
		int depthLimit = 0;
		List<T> path;
		
		do {
			depthLimit++;
			path = new DepthFirstStrategy<T>(depthLimit).search(expander, evaluator, startState);
		} while (path == null);
		
		return path;
	}

}
