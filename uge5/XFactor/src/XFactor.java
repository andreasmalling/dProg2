public class XFactor {
	public int getXFactor(int x, int factor) {
		if( factor > 0 )
			return x * getXFactor( x, factor-1 );
		else
			return 1;
	}
}
