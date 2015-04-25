package nl.jchmb.ai.search.evaluator;

/**
 * Simple state evaluator that returns true whenever a given state
 * equals the predefined goal state. This may require overriding 
 * the Object.equals method for the state class.
 */
public class SimpleEvaluator<T> implements Evaluator<T> {
	private T goalState;
	
	public SimpleEvaluator(T goalState) {
		this.goalState = goalState;
	}
	
	public boolean isGoalState(T state) {
		return state.equals(goalState);
	}
}
