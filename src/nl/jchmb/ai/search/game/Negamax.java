package nl.jchmb.ai.search.game;

import java.util.ArrayList;
import java.util.List;

import nl.jchmb.ai.search.expander.Expander;

public class Negamax<T> implements Chooser<T> {
	private int depthLimit;
	
	public Negamax(int depthLimit) {
		this.depthLimit = depthLimit;
	}
	
	@Override
	public T choose(GameEvaluator<T> evaluator, Expander<T> expander, T state, int color) {
		return calculate(evaluator, expander, state, new ArrayList<T>(), depthLimit, color).getStates().get(1);
	}
	
	private StateEvaluation<T> calculate(GameEvaluator<T> evaluator, Expander<T> expander, T state, List<T> states, int depth, int color) {
		Evaluation evaluation;
		states.add(state);
		StateEvaluation<T> bestEvaluation = new StateEvaluation<T>(states, -99999.0d);
		StateEvaluation<T> currentEvaluation;
		
		evaluation = evaluator.evaluate(state);
		if (depth == 0 || evaluation.terminates()) {
			return new StateEvaluation<T>(states, ((double) color) * evaluation.getValue());
		}
		for (T child : expander.expand(state)) {
			currentEvaluation = calculate(
					evaluator,
					expander,
					child,
					new ArrayList<T>(states),
					depth - 1,
					-color
			).negate();
			if (currentEvaluation.getValue() > bestEvaluation.getValue()) {
				bestEvaluation = currentEvaluation;
			}
		}
		return bestEvaluation;
	}
}