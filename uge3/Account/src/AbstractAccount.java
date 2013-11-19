public abstract class AbstractAccount implements Account {
	private int balance = 0;
	
	@Override
	public void deposit(int amount) throws IllegalArgumentException {
		if( amount < 0 )
			throw new IllegalArgumentException();
		balance += amount;
	}

	@Override
	public boolean withdraw(int amount) throws IllegalArgumentException {
		if( amount < 0 )
			throw new IllegalArgumentException();
		balance -= amount;
		return true;	
	}

	@Override
	public int getBalance() {
		return balance;
	}
}
