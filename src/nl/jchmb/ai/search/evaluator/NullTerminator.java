package nl.jchmb.ai.search.evaluator;

public class NullTerminator<T> implements Terminator<T> {
	public boolean terminates(T state) {
		return false;
	}
}
