package nl.jchmb.ai.game;

import nl.jchmb.ai.search.expander.Expander;

public interface Chooser<T> {
	public T choose(GameEvaluator<T> evaluator, Expander<T> expander, T state, int color);
}
