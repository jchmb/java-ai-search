package nl.jchmb.ai.search.node;

import java.util.Comparator;

public class NodeComparator<T> implements Comparator<Node<T>> {
	private Comparator<T> comparator;
	
	public NodeComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public int compare(Node<T> o1, Node<T> o2) {
		return comparator.compare(o1.getState(), o2.getState());
	}
}
