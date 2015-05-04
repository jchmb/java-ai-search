package nl.jchmb.ai.search.game;

public class Evaluation {
	private boolean terminates;
	private double value;
	
	public Evaluation(boolean terminates, double value) {
		this.terminates = terminates;
		this.value = value;
	}
	
	public boolean terminates() {
		return terminates;
	}
	
	public double getValue() {
		return value;
	}
}
