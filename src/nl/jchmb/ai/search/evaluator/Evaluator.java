package nl.jchmb.ai.search.evaluator;

public interface Evaluator<T> {
	/**
	 * Check whether the given generic state is in the goal state.
	 * 
	 * @param state
	 * @return
	 */
	public boolean isGoalState(T state);
}
