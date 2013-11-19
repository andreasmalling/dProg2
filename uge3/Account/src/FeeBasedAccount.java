public class FeeBasedAccount extends AbstractAccount {
	private int fee = 0; 
	
	@Override
	public void deposit(int amount) throws IllegalArgumentException {
		fee++;
		super.deposit(amount);
	}
	
	@Override
	public boolean withdraw(int amount) throws IllegalArgumentException {
		fee++;
		return super.withdraw(amount);
	}
	
	@Override
	public void yearEnd() {
		super.withdraw(fee);
		fee = 0;
	}
}
