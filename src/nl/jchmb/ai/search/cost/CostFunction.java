package nl.jchmb.ai.search.cost;

import nl.jchmb.ai.search.node.Node;

/**
 * Calculates the cost of a given state.
 */
public interface CostFunction<T> {
	public float getCost(Node<T> object);
}
