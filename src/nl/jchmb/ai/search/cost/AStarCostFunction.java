package nl.jchmb.ai.search.cost;

import nl.jchmb.ai.search.cost.heuristic.Heuristic;
import nl.jchmb.ai.search.node.Node;

public class AStarCostFunction<T> implements CostFunction<T> {
	private Heuristic<T> heuristic;
	private CostFunction<T> costFunction;
	
	public AStarCostFunction(Heuristic<T> heuristic, CostFunction<T> costFunction) {
		this.heuristic = heuristic;
		this.costFunction = costFunction;
	}
	
	@Override
	public int getCost(Node<T> object) {
		return heuristic.estimate(object.getState()) + costFunction.getCost(object);
	}

}
