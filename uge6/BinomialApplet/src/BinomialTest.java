public class BinomialTest {
    public static void main(String[] args) {
        Binomial1 implementation1 = new Binomial1();
        assert implementation1.binomial(0,0) == 1;
        assert implementation1.binomial(21,0) == 1;
        assert implementation1.binomial(60,60) == 1;
        assert implementation1.binomial(60,59) == 60;
        assert implementation1.binomial(30,15) == 155117520;
        Binomial2 implementation2 = new Binomial2();
        assert implementation2.binomial(0,0) == 1;
        assert implementation2.binomial(21,0) == 1;
        assert implementation2.binomial(60,60) == 1;
        assert implementation2.binomial(60,59) == 60;
        assert implementation2.binomial(30,15) == 155117520;

        try {
            assert false;
            System.out.println("Please enable assertions!");
        } catch (AssertionError e) {
            System.out.println("Success!");
        }
    }
}

