package nl.jchmb.ai.search.strategy;

import java.util.List;

import nl.jchmb.ai.search.evaluator.Terminator;
import nl.jchmb.ai.search.expander.Expander;

public class IterativeDeepeningStrategy<T> implements Strategy<T> {
	@Override
	public List<T> search(Expander<T> expander,
			Terminator<T> evaluator, T startState) {
		int depthLimit = 0;
		List<T> path;
		
		do {
			depthLimit++;
			path = new DepthFirstStrategy<T>(depthLimit).search(expander, evaluator, startState);
		} while (path == null);
		
		return path;
	}

}
