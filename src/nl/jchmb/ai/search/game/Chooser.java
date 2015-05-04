package nl.jchmb.ai.search.game;

import nl.jchmb.ai.search.evaluator.Evaluator;
import nl.jchmb.ai.search.expander.Expander;

public interface Chooser<T> {
	public T choose(Evaluator<T> evaluator, Expander<T> expander, T state, int color);
}
