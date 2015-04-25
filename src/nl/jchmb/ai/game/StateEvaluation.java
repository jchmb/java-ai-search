package nl.jchmb.ai.game;

import java.util.List;

import nl.jchmb.generic.tuple.Pair;

public class StateEvaluation<T> extends Pair<List<T>, Double> {
	public StateEvaluation(List<T> o1, Double o2) {
		super(o1, o2);
	}

	public List<T> getStates() {
		return getLeft();
	}
	
	public double getValue() {
		return getRight();
	}
	
	public StateEvaluation<T> negate() {
		return new StateEvaluation<T>(getLeft(), getRight() * -1);
	}
}
