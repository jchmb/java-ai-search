package nl.jchmb.ai.search.evaluator;

/**
 * Simple state evaluator that returns true whenever a given state
 * equals the predefined goal state. This may require overriding 
 * the Object.equals method for the state class.
 */
public class SimpleTerminator<T> implements Terminator<T> {
	private T goalState;
	
	public SimpleTerminator(T goalState) {
		this.goalState = goalState;
	}
	
	public boolean terminates(T state) {
		return state.equals(goalState);
	}
}
