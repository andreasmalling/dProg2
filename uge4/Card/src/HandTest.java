public class HandTest {
    public static void main(String[] args) {
        Card[] cards1 = {
            new Card(Suit.SPADE, Rank.SEVEN),
            new Card(Suit.HEART, Rank.SEVEN),
            new Card(Suit.DIAMOND, Rank.SEVEN),
            new Card(Suit.CLUB, Rank.JACK)
        };
        Card[] cards2 = {
            new Card(Suit.HEART, Rank.JACK),
            new Card(Suit.HEART, Rank.ACE),
            new Card(Suit.SPADE, Rank.TWO)
        };
        Hand d1 = new Hand();
        Hand d2 = new Hand();

        for (Card c : cards1) {
            assert d1.add(c);
        }

        for (Card c : cards2) {
            assert d1.add(c);
            assert d2.add(c);
        }

        assert !d1.equals(d2);

        for (Card c : cards2) {
            assert !d1.add(c);
        }

        for (Card c : cards1) {
            assert !d2.remove(c);
        }

        for (Card c : cards1) {
            if (Math.random() < .5) {
                assert d2.add(c);
            } else {
                assert d1.remove(c);
            }
        }

        System.out.println(d1);
        System.out.println(d2);
            
        assert d1.equals(d2);
        assert d1.hashCode() == d2.hashCode();

        try {
            assert false;
            System.out.println("Please enable assertions!");
        } catch (AssertionError e) {
            System.out.println("Success!");
        }
    }
}
