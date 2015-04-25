package nl.jchmb.ai.search.game;

public interface GameEvaluator<T> {
	public Evaluation evaluate(T state);
}
