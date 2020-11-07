import java.math.BigInteger;

/**
 * 
 * @author Stephanie
 *
 */
public class PrimeFinder {
	
	
	// Constructor 
	
	/**
	 * 
	 */
	public PrimeFinder() {
		
	}
	
	// Methods
	
	/**
	 * 
	 * @param a
	 * @param p
	 * @return
	 */
	public int myPrimeFun(int a, int p) {
		BigInteger biA = BigInteger.valueOf(a);
		BigInteger biB = BigInteger.valueOf(p);
		BigInteger biC = BigInteger.valueOf(p-1);
		BigInteger biD = biA.modPow(biC, biB);
		return biD.intValue();
	}
	
	/**
	 * 
	 * @param startPt
	 * @param endPt
	 * @return
	 */
	public int primeLocater(int startPt, int endPt ) {
		boolean found = false;
		int a1 = 2;
		int a2 = 5;
		int n = startPt -1;
		
		while(!found) {
			n += 1;
			int r1 = (int) this.myPrimeFun(a1,n);
			int r2 = (int) this.myPrimeFun(a2,n);
			
			int r3 = (int) this.myPrimeFun(a1, n-2);
			int r4 = (int) this.myPrimeFun(a2, n-2);
			
			if(n >= endPt) {
				found = true;
			}
			if (r1==1 && r2==1 && r3==1 && r4==1) {
				found = true;
			}
		}
		return n;
	}
}
