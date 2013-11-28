public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;

	public Card(Suit s, Rank r){
		suit = s;
		rank = r;
	}

	@Override
	public int compareTo(Card other) {
		if( rank.equals(other.rank) ) {
			return suit.compareTo(other.suit);
		}
		return rank.compareTo(other.rank);
	}

	public String toString(){
		return suit + " " + rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return  rank.equals(other.rank) &&
				suit.equals(other.suit);
	}

	@Override
	public int hashCode() {
		return 7 * rank.hashCode() + 19 * suit.hashCode();
	}
}
