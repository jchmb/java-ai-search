package nl.jchmb.ai.search.evaluator;

public interface Terminator<T> {
	/**
	 * Check whether the given generic state is in the goal state.
	 * 
	 * @param state
	 * @return
	 */
	public boolean terminates(T state);
}
