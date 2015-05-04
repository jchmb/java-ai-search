package nl.jchmb.ai.search.game;

import java.util.ArrayList;
import java.util.List;

import nl.jchmb.ai.search.evaluator.Evaluator;
import nl.jchmb.ai.search.expander.Expander;

public class Minimax<T> implements Chooser<T> {
	private int depthLimit;
	
	public Minimax(int depthLimit) {
		this.depthLimit = depthLimit;
	}
	
	@Override
	public T choose(Evaluator<T> evaluator, Expander<T> expander, T state, int color) {
		StateEvaluation<T> bestEvaluation = calculate(evaluator, expander, state, new ArrayList<T>(), depthLimit, -99999.0d, 99999.0d, color);
		return bestEvaluation.getStates().get(1);
	}
	
	private StateEvaluation<T> calculate(Evaluator<T> evaluator, Expander<T> expander, T state, List<T> states, int depth, double alpha, double beta, int color) {
		states.add(state);
		StateEvaluation<T> bestEvaluation;
		StateEvaluation<T> currentEvaluation;
		
		if (depth == 0 || evaluator.terminates(state)) {
			return new StateEvaluation<T>(states, evaluator.evaluate(state));
		}
		if (color > 0) {
			bestEvaluation =  new StateEvaluation<T>(states, -99999.0d);
			for (T child : expander.expand(state)) {
				currentEvaluation = calculate(
						evaluator,
						expander,
						child,
						new ArrayList<T>(states),
						depth - 1,
						alpha,
						beta,
						-1
				);
				if (currentEvaluation.getValue() > bestEvaluation.getValue()) {
					bestEvaluation = currentEvaluation;
				}
				if (bestEvaluation.getValue() > alpha) {
					alpha = bestEvaluation.getValue();
				}
				if (beta <= alpha) {
					break;
				}
			}
		} else {
			bestEvaluation = new StateEvaluation<T>(states, 99999.0d);
			for (T child : expander.expand(state)) {
				currentEvaluation = calculate(
						evaluator,
						expander,
						child,
						new ArrayList<T>(states),
						depth - 1,
						alpha,
						beta,
						1
				);
				if (currentEvaluation.getValue() < bestEvaluation.getValue()) {
					bestEvaluation = currentEvaluation;
				}
				if (bestEvaluation.getValue() < beta) {
					beta = bestEvaluation.getValue();
				}
				if (beta <= alpha) {
					break;
				}
			}

		}
		
		return bestEvaluation;
	}
}