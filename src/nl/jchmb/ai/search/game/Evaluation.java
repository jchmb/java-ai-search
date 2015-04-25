package nl.jchmb.ai.search.game;

import nl.jchmb.generic.tuple.Pair;

public class Evaluation extends Pair<Boolean, Double> {
	public Evaluation(Boolean o1, Double o2) {
		super(o1, o2);
	}
	
	public boolean terminates() {
		return getLeft().booleanValue();
	}
	
	public double getValue() {
		return getRight().doubleValue();
	}
}
