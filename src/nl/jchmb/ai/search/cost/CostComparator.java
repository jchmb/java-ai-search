package nl.jchmb.ai.search.cost;

import java.util.Comparator;

import nl.jchmb.ai.search.node.Node;

/**
 * Comparator implementation that compares objects according to some 
 * CostFunction implementation. 
 */
public class CostComparator<T> implements Comparator<Node<T>> {
	private CostFunction<T> costFunction;
	
	public CostComparator(CostFunction<T> costFunction) {
		this.costFunction = costFunction;
	}

	@Override
	public int compare(Node<T> o1, Node<T> o2) {
		int diff = costFunction.getCost(o1) - costFunction.getCost(o2);
		
		return diff == 0 ? 0 : (diff > 0 ? 1 : -1);
	}
}
