public class Binomial2 {
	/**
	 * Brugen af 2 rekursive kald, gør metoden langsommere end den som kun benytter et enkelt
	 */

	public long binomial(long n, long k){
		if( n==k || k==0)
			return 1;
		else if( n>k && k>0 ) {
			return binomial(n-1,k) + binomial(n-1, k-1);
		}
		return -1;
	}
}