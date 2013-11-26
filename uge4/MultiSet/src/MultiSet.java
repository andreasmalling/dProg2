import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;

public class MultiSet<E> extends AbstractCollection {
	private HashMap<E,Integer> multiSet = new HashMap<E,Integer>();

	@Override
	public boolean add(Object o) {
		if(o instanceof String) {
			E currentKey = (E) o;
			for( E s : multiSet.keySet() ) {
				if(currentKey.equals(s)) {
					multiSet.put( currentKey,
							multiSet.get(currentKey)+1 );
					return true;
				}
			}
			multiSet.put(currentKey, 1);
			return true;
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		return new Iterator<E>() {
			private int count = 0;
			private E currentKey;

			@Override
			public boolean hasNext() {
				if( count == 0 )
					return multiSet.keySet().iterator().hasNext();
				else
					return true;
			}

			@Override
			public E next() {
				if( count == 0 ) {
					currentKey = multiSet.keySet().iterator().next();
					count = multiSet.get(currentKey);
					return currentKey;
				} else {
					count--;
					return currentKey;
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return multiSet.keySet().size();
	}
}
