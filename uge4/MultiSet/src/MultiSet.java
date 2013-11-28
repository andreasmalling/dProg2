import java.util.*;

public class MultiSet<E> extends AbstractCollection<E> {
	private HashMap<E,Integer> hashMap = new HashMap<>();

	public MultiSet(){}
	public MultiSet(Collection<E> c) {
		addAll(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean add(Object o) {
		E currentKey = (E) o;
		for( E s : hashMap.keySet() ) {                // Checks for Key, if present increment count
			if(currentKey.equals(s)) {
				hashMap.put( currentKey,               // Get keys current count and increment it
						hashMap.get(currentKey) +1 );
				return true;
			}
		}
		hashMap.put(currentKey, 1);
		return true;                                    // If not present, make with count 1
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(Object o) {
		E currentKey = (E) o;
		for( E s : hashMap.keySet() ) {                // Checks if Key is present
			if(currentKey.equals(s)) {
				if( hashMap.get(currentKey) <= 1)      // If 1 instance, remove key and value
					hashMap.remove(currentKey);
				else
					hashMap.put( currentKey,           // If more then 1 instance, decrement it
						hashMap.get(currentKey) - 1 );
				return true;
			}
		}
		return false;                                    // If key not present, return false
	}

	@Override
	public String toString() {
		return hashMap.entrySet().toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)                                  // Check for comparing self
			return true;
		if (o == null || getClass() != o.getClass())    // Check for same class, and null
			return false;

		MultiSet other = (MultiSet) o;
		return hashMap.equals(other.hashMap);
	}

	@Override
	public int hashCode() {
		return hashMap.hashCode();
	}

	@Override
	public int size() {
		int totalSize = 0;
		for(int i : hashMap.values())
		    totalSize += i;
		return totalSize;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int count = 0;                                  // Keeps track of current key's number of instances
			private E currentKey = null;                            // Keeps track of current key
			private Iterator<E> keyIterator = hashMap.keySet().iterator();

			@Override
			public boolean hasNext() {
				if( count == 0 )                                  // If the count of currentKey is 0, check for next key
					return keyIterator.hasNext();
				return true;                                       // If count is larger than 0, there is another instance of currentKey
			}

			@Override
			public E next() {
				if( count == 0 ) {                                  // If the count of currentKey is 0, goto next key and read count
					currentKey = keyIterator.next();
					count = hashMap.get(currentKey);
				}
				count--;
				return currentKey;
			}

			@Override
			public void remove() {                                  // Operation not supported
				throw new UnsupportedOperationException();
			}
		};
	}
}