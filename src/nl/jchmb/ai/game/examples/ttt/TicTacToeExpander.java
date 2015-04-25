package nl.jchmb.ai.game.examples.ttt;

import java.util.ArrayList;
import java.util.Collection;

import nl.jchmb.ai.search.expander.Expander;

public class TicTacToeExpander implements Expander<TicTacToe> {
	@Override
	public Iterable<TicTacToe> expand(TicTacToe state) {
		int turn = state.getTurn();
		Collection<Integer> emptyCells = state.getEmptyCells();
		Collection<TicTacToe> states = new ArrayList<TicTacToe>();
		TicTacToe child;
		
		for (int i : emptyCells) {
			child = state.copy();
			child.set(i, turn);
			states.add(child);
		}
		
		return states;
	}
}
