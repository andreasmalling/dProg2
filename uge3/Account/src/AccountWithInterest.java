public class AccountWithInterest extends AbstractAccount {
	
	@Override
	public boolean withdraw(int amount) throws IllegalArgumentException {
		if( getBalance() >= amount)
			return super.withdraw(amount);
		return false;
	}
	
	@Override
	public void yearEnd() {
		double interest =  getBalance() * 0.05;
		deposit( (int) interest );
	}
}
