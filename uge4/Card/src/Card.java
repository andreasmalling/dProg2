public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;

	public Card(Suit s, Rank r){
		suit = s;
		rank = r;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card other) {
		if( getRank().equals(other.getRank()) ) {
			return getSuit().compareTo(other.getSuit());
		}
		return getRank().compareTo(other.getRank());
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
		return  getRank().equals(other.getRank()) &&
				getSuit().equals(other.getSuit());
	}

	@Override
	public int hashCode() {
		return getRank().hashCode() + 13 * getSuit().hashCode();
	}
}
