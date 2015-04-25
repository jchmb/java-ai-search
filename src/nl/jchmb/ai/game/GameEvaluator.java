package nl.jchmb.ai.game;

public interface GameEvaluator<T> {
	public Evaluation evaluate(T state);
}
