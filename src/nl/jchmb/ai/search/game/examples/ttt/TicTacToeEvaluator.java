package nl.jchmb.ai.search.game.examples.ttt;

import nl.jchmb.ai.search.game.Evaluation;
import nl.jchmb.ai.search.game.GameEvaluator;

public class TicTacToeEvaluator implements GameEvaluator<TicTacToe> {

	@Override
	public Evaluation evaluate(TicTacToe state) {
		int victor;
		boolean terminates;
		
		victor = getVictor(state);
		if (victor != 0 || state.countPlies() == 9) {
			terminates = true;
		} else {
			terminates = false;
		}
		
		return new Evaluation(terminates, (double) victor);
	}

	public int getVictor(TicTacToe state) {
		return state.getVictor();
	}
}
