public class CardTest {
    public static void main(String[] args) {
        assert Suit.DIAMOND.compareTo(Suit.CLUB) < 0;
        assert Suit.CLUB.compareTo(Suit.HEART) < 0;
        assert Suit.HEART.compareTo(Suit.SPADE) < 0;
        assert Rank.TWO.compareTo(Rank.THREE) < 0;
        assert Rank.THREE.compareTo(Rank.FOUR) < 0;
        assert Rank.FOUR.compareTo(Rank.FIVE) < 0;
        assert Rank.FIVE.compareTo(Rank.SIX) < 0;
        assert Rank.SIX.compareTo(Rank.SEVEN) < 0;
        assert Rank.SEVEN.compareTo(Rank.EIGHT) < 0;
        assert Rank.EIGHT.compareTo(Rank.NINE) < 0;
        assert Rank.NINE.compareTo(Rank.TEN) < 0;
        assert Rank.TEN.compareTo(Rank.JACK) < 0;
        assert Rank.JACK.compareTo(Rank.QUEEN) < 0;
        assert Rank.QUEEN.compareTo(Rank.KING) < 0;
        assert Rank.KING.compareTo(Rank.ACE) < 0;
        Card[] deck1 = new Card[52];
        Card[] deck2 = new Card[52];
        int k = 0;
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                deck1[k] = new Card(s,r);
                deck2[k] = new Card(s,r);
                k++;
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println(deck1[i]);
            for (int j = 0; j < i; j++) {
                assert !deck1[i].equals(deck1[j]);
                assert deck1[i].compareTo(deck1[j]) > 0;
                assert deck1[j].compareTo(deck1[i]) < 0;
            }
            assert deck1[i].equals(deck2[i]);
            assert deck1[i].compareTo(deck2[i]) == 0;
            assert deck1[i].hashCode() == deck2[i].hashCode();
        }
        try {
            assert false;
            System.out.println("Please enable assertions!");
        } catch (AssertionError e) {
            System.out.println("Success!");
        }
    }
}
