public class Binomial1 implements Binomial{
	public long binomial(long n, long k){
		if( n==k || k==0)
			return 1;
		else if( n>k && k>0 ) {
			return ( binomial(n,k-1) * (n-k+1) )/k;
		}
		return -1;
	}
}