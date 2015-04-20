package nl.jchmb.ai.search.cost.heuristic;

public interface Heuristic<T> {
	public float estimate(T state);
}
