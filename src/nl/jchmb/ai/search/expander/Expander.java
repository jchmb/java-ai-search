package nl.jchmb.ai.search.expander;

public interface Expander<T> {
	/**
	 * Expand a state and return its child states.
	 * 
	 * @param state
	 * @return
	 */
	public Iterable<T> expand(T state);
}
