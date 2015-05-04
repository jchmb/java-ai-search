package nl.jchmb.ai.search.game;

import java.util.ArrayList;
import java.util.List;

import nl.jchmb.ai.search.evaluator.Evaluator;
import nl.jchmb.ai.search.expander.Expander;

public class Negamax<T> implements Chooser<T> {
	private int depthLimit;
	
	public Negamax(int depthLimit) {
		this.depthLimit = depthLimit;
	}
	
	@Override
	public T choose(Evaluator<T> evaluator, Expander<T> expander, T state, int color) {
		return calculate(evaluator, expander, state, new ArrayList<T>(), depthLimit, color).getStates().get(1);
	}
	
	private StateEvaluation<T> calculate(Evaluator<T> evaluator, Expander<T> expander, T state, List<T> states, int depth, int color) {
		states.add(state);
		StateEvaluation<T> bestEvaluation = new StateEvaluation<T>(states, -99999.0d);
		StateEvaluation<T> currentEvaluation;
		
		if (depth == 0 || evaluator.terminates(state)) {
			return new StateEvaluation<T>(states, ((double) color) * evaluator.evaluate(state));
		}
		for (T child : expander.expand(state)) {
			currentEvaluation = calculate(
					evaluator,
					expander,
					child,
					new ArrayList<T>(states),
					depth - 1,
					-color
			);
			if (currentEvaluation.getValue() > bestEvaluation.getValue()) {
				bestEvaluation = currentEvaluation;
			}
		}
		return bestEvaluation;
	}
}