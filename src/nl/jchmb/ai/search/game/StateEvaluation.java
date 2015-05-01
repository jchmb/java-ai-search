package nl.jchmb.ai.search.game;

import java.util.List;

import nl.jchmb.generic.tuple.Pair;

public class StateEvaluation<T> {
	private List<T> o1;
	private double o2;
	
	public StateEvaluation(List<T> o1, double o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public List<T> getStates() {
		return o1;
	}
	
	public double getValue() {
		return o2;
	}
	
	public StateEvaluation<T> negate() {
		return new StateEvaluation<T>(o1, -getValue());
	}
}
