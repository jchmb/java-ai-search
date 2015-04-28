package nl.jchmb.ai.search.game.examples.ttt;

import java.util.ArrayList;
import java.util.Collection;

import nl.jchmb.ai.search.game.Chooser;
import nl.jchmb.ai.search.game.Negamax;

public class TicTacToe {
	private int[] board;
	
	public TicTacToe() {
		board = new int[9];
		for (int i = 0; i < 9; i++) {
			board[i] = 0;
		}
	}
	
	public TicTacToe(int[] board) {
		this();
		for (int i = 0; i < 9; i++) {
			this.board[i] = board[i];
		}
	}
	
	public TicTacToe copy() {
		return new TicTacToe(board);
	}
	
	public int countPlies() {
		int count = 0;
		
		for (int ply : board) {
			if (ply != 0) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getTurn() {
		return ((countPlies() % 2) == 0) ? 1 : -1;
	}
	
	private int get(int x, int y) {
		return board[y * 3 + x];
	}
	
	public void set(int i, int player) {
		board[i] = player;
	}
	
	public Collection<Integer> getEmptyCells() {
		Collection<Integer> cells = new ArrayList<Integer>();
		
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				cells.add(i);
			}
		}
		
		return cells;
	}
	
	public int getVictor() {
		int[] players = new int[]{1, -1};
				
		for (int player : players) {
			if (
					(get(0, 0) == player && get(1, 0) == player && get(2, 0) == player) ||
					(get(0, 1) == player && get(1, 1) == player && get(2, 1) == player) ||
					(get(0, 2) == player && get(1, 2) == player && get(2, 2) == player) ||
					
					(get(0, 0) == player && get(0, 1) == player && get(0, 2) == player) ||
					(get(1, 0) == player && get(1, 1) == player && get(1, 2) == player) ||
					(get(2, 0) == player && get(2, 1) == player && get(2, 2) == player) ||
					
					(get(0, 0) == player && get(1, 1) == player && get(2, 2) == player) ||
					(get(0, 2) == player && get(1, 1) == player && get(2, 0) == player)
					
			) {
				return player;
			}
		}
		
		return 0;
	}
	
	public String toString() {
		String s = "";
		
		for (int i = 0; i < board.length; i++) {
			if (i > 0 && i % 3 == 0) {
				s += "\n";
			}
			if (i % 3 > 0) {
				s += "\t";
			}
			s += board[i];
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		Chooser<TicTacToe> chooser = new Negamax<TicTacToe>(10);
		for (int i = 0; i < 9; i++) {
			t = chooser.choose(new TicTacToeEvaluator(), new TicTacToeExpander(), t, t.getTurn());
			System.out.println(t + "\n");
		}
	}
}
