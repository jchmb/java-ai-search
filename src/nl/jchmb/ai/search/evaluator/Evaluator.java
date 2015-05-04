package nl.jchmb.ai.search.evaluator;

public interface Evaluator<T> extends Terminator<T> {
	public double evaluate(T state);
}
