import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;

public class MultiSet<E> extends AbstractCollection {
	private HashMap<E,Integer> multiSet = new HashMap<E,Integer>();

	@Override
	public boolean add(Object o) {
		// if(o instanceof E) {                         // Not possible for template-type ?
		E currentKey = (E) o;
		for( E s : multiSet.keySet() ) {                // Checks for Key, if present increment count
			if(currentKey.equals(s)) {
				multiSet.put( currentKey,               // Get keys current count and increment it
						multiSet.get(currentKey) +1 );
				return true;
			}
		}
		multiSet.put(currentKey, 1);
		return true;                                    // If not present, make with count 1
		// } return false;
	}

	@Override
	public int size() {
		return multiSet.keySet().size();
	}

	@Override
	public Iterator iterator() {
		return new Iterator<E>() {
			private int count = 0;                                  // Keeps track of current keys number of instances
			private E currentKey = null;                            // Keeps track of current key

			@Override
			public boolean hasNext() {
				if( count <= 0 )                                    // If the count of currentKey is 0, check for next key
					return multiSet.keySet().iterator().hasNext();
				else                                                // If count is larger than 0, there is another instance of currentKey
					return true;
			}

			@Override
			public E next() {
				if( count <= 0 ) {                                  // If the count of currentKey is 0, goto next key and read count
					currentKey = multiSet.keySet().iterator().next();
					count = multiSet.get(currentKey);
					return currentKey;
				} else {                                            // Decrements count and returns currentKey
					count--;
					return currentKey;
				}
			}

			@Override
			public void remove() {                                  // Operation not supported
				throw new UnsupportedOperationException();
			}
		};
	}
}