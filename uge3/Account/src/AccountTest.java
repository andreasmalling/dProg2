public class AccountTest {
    public static void main(String[] args) {
        Account mySavings = new AccountWithInterest();
        assert mySavings.getBalance() == 0;
        mySavings.deposit(1000);
        assert mySavings.getBalance() == 1000;
        mySavings.withdraw(1000);
        assert mySavings.getBalance() == 0;
        mySavings.deposit(1000);
        assert mySavings.withdraw(200);
        assert !mySavings.withdraw(900);
        mySavings.yearEnd();
        mySavings.deposit(100);
        mySavings.yearEnd();
        assert mySavings.getBalance()==987;
        Account myChecking = new FeeBasedAccount();
        myChecking.deposit(1000);
        assert myChecking.withdraw(200);
        assert myChecking.withdraw(900);
        myChecking.yearEnd();
        myChecking.deposit(100);
        myChecking.yearEnd();
        assert myChecking.getBalance()==-4;
        try {
            mySavings.deposit(-1);
            assert false;
        } catch (IllegalArgumentException e) {}
        try {
            myChecking.withdraw(-1);
            assert false;
        } catch (IllegalArgumentException e) {}
        try {
            assert false;
            System.out.println("Please enable assertions!");
        }
        catch(AssertionError e) {
            System.out.println("Success!");
        }
    }
}