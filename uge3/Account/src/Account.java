public interface Account {
    public void deposit(int amount);

    public boolean withdraw(int amount);

    public int getBalance();

    public void yearEnd();
}