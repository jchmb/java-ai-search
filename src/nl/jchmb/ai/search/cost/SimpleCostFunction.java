package nl.jchmb.ai.search.cost;

import nl.jchmb.ai.search.node.Node;

public class SimpleCostFunction<T> implements CostFunction<T> {
	@Override
	public float getCost(Node<T> object) {
		return object.getPath().size();
	}
}
