package nl.jchmb.ai.search.cost.heuristic;

public interface Heuristic<T> {
	public int estimate(T state);
}
