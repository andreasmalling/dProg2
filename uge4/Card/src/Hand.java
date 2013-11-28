import java.util.TreeSet;

public class Hand {
	private TreeSet<Card> cards = new TreeSet<Card>();

	public boolean add(Card c){
		return cards.add(c);
	}

	public boolean remove(Card c){
		return cards.remove(c);
	}

	@Override
	public String toString(){
		return cards.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Hand other = (Hand) o;
		return cards.equals(other.cards);
	}

	@Override
	public int hashCode(){
		int totalHash = 0;
		for(Card c : cards)
			totalHash += c.hashCode();
		return totalHash;
	}
}
