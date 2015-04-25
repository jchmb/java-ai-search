package nl.jchmb.ai.search.expander;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Decorator implementation of StateExpander.
 * Uses an underlying StateExpander's iterator and skips states
 * that have already been visited before.
 */
public class ArchivedExpander<T> implements Expander<T> {
	private Expander<T> expander;
	private Set<T> archive;
	
	public ArchivedExpander(Expander<T> expander) {
		this.expander = expander;
		archive = new HashSet<T>();
	}
	
	public void reset() {
		archive.clear();
	}
	
	@Override
	public Iterable<T> expand(T state) {
		Iterator<T> iterator = expander.expand(state).iterator();
		return new InternalIterable(iterator);
	}
	
	private class InternalIterable implements Iterable<T> {
		private Iterator<T> iterator;
		
		private InternalIterable(Iterator<T> iterator) {
			this.iterator = iterator;
		}
		
		@Override
		public Iterator<T> iterator() {
			return new InternalIterator();
		}
		
		private class InternalIterator implements Iterator<T> {
			private T buffer = null;
			
			public InternalIterator() {
				loadBuffer();
			}
			
			private void loadBuffer() {
				T current;
				
				if (buffer == null) {
					while (iterator.hasNext()) {
						current = iterator.next();
						if (!archive.contains(current)) {
							buffer = current;
							archive.add(current);
							break;
						}
					}
				}
			}
			
			@Override
			public boolean hasNext() {
				return buffer != null;
			}

			@Override
			public T next() {
				T nextState = buffer;
				buffer = null;
				loadBuffer();
				return nextState;
			}

			@Override
			public void remove() {
				
			}
		}
	}
}
