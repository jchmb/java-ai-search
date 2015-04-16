package nl.jchmb.ai.search.node;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private T state;
	private List<T> path;
	
	public Node(T state, List<T> path) {
		this.state = state;
		this.path = path;
	}
	
	public T getState() {
		return state;
	}
	
	public List<T> getPath() {
		List<T> path = new ArrayList<T>(this.path);
		path.add(state);
		return path;
	}
}
