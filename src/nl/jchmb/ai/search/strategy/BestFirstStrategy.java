package nl.jchmb.ai.search.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import nl.jchmb.ai.search.evaluator.StateEvaluator;
import nl.jchmb.ai.search.expander.StateExpander;
import nl.jchmb.ai.search.node.Node;
import nl.jchmb.ai.search.node.NodeComparator;

public class BestFirstStrategy<T> implements Strategy<T> {
	private Comparator<T> comparator;
	
	public BestFirstStrategy(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public List<T> search(StateExpander<T> expander,
			StateEvaluator<T> evaluator, T startState) {
		Node<T> currentNode;
		T currentState;
		PriorityQueue<Node<T>> queue = new PriorityQueue<Node<T>>(5000, new NodeComparator<T>(comparator));
		
		queue.offer(new Node<T>(startState, new ArrayList<T>()));
		while (!queue.isEmpty()) {
			currentNode = queue.poll();
			currentState = currentNode.getState();
			
			if (evaluator.isGoalState(currentState)) {
				return currentNode.getPath();
			}
			
			for (T nextState : expander.expand(currentState)) {
				queue.offer(new Node<T>(nextState, currentNode.getPath()));
			}
		}
		
		return null;
	}
}
