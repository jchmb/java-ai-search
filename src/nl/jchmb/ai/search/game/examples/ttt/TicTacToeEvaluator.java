package nl.jchmb.ai.search.game.examples.ttt;

import nl.jchmb.ai.search.evaluator.Evaluator;

public class TicTacToeEvaluator implements Evaluator<TicTacToe> {

	@Override
	public double evaluate(TicTacToe state) {
		return terminates(state) ? ((double) state.getVictor()) : 0.0d;
	}
	
	public boolean terminates(TicTacToe state) {
		return state.getVictor() != 0 || state.countPlies() == 9;
	}
}
