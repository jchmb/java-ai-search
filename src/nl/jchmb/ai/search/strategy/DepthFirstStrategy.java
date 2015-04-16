package nl.jchmb.ai.search.strategy;

import java.util.ArrayList;
import java.util.List;

import nl.jchmb.ai.search.evaluator.StateEvaluator;
import nl.jchmb.ai.search.expander.StateExpander;

public class DepthFirstStrategy<T> implements Strategy<T> {
	private int depthLimit;
	
	public DepthFirstStrategy(int depthLimit) {
		this.depthLimit = depthLimit;
	}
	
	public DepthFirstStrategy() {
		this(0);
	}
	
	@Override
	public List<T> search(StateExpander<T> expander,
			StateEvaluator<T> evaluator, T startState) {
		return search(expander, evaluator, startState, new ArrayList<T>());
	}
	
	private List<T> search(StateExpander<T> expander,
			StateEvaluator<T> evaluator, T state, List<T> currentPath) {
		List<T> path;
		
		currentPath.add(state);
		if (evaluator.isGoalState(state)) {
			return currentPath;
		}
		
		if (depthLimit > 0 && currentPath.size() >= depthLimit) {
			return null;
		}
		
		for (T newState : expander.expand(state)) {
			path = search(expander, evaluator, newState, new ArrayList<T>(currentPath));
			if (path != null) {
				return path;
			}
		}
		return null;
	}
}
