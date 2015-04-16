package nl.jchmb.ai.search.strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nl.jchmb.ai.search.evaluator.StateEvaluator;
import nl.jchmb.ai.search.expander.StateExpander;
import nl.jchmb.ai.search.node.Node;

public class BreadthFirstStrategy<T> implements Strategy<T> {
	@Override
	public List<T> search(StateExpander<T> expander,
			StateEvaluator<T> evaluator, T startState) {
		Node<T> currentNode;
		T currentState;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		
		queue.offer(new Node<T>(startState, new ArrayList<T>()));
		while (!queue.isEmpty()) {
			currentNode = queue.poll();
			currentState = currentNode.getState();
			
			if (evaluator.isGoalState(currentState)) {
				return currentNode.getPath();
			}
			
			for (T newState : expander.expand(currentState)) {
				queue.add(new Node<T>(newState, currentNode.getPath()));
			}
		}
		
		return null;
	}
}
