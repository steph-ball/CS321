/**
 * 
 * @author steph
 * @param <T>
 *
 */
public class HashTable<T> {
	
	HashObject[] hashArray;
	private int hashMode;
	private int storedCount;
	private int attempts;
	private int totalProbeCount;
	
	//Constructor
	
	/**
	 * 
	 */
	public HashTable(int m, int hashMode) {
		hashArray = new HashObject[m];
		this.hashMode = hashMode;
		storedCount = 0;
		for(int i = 0; i < m; i++) {   // setting array to null
			hashArray[i] = null;
		}
	}
	
	// Methods
	
	/**
	 * 
	 * @param object
	 */
	public void addObject(HashObject<T> hash) {
		attempts = 0;
		boolean stored = false;
		T key = hash.getKey();
		
		while(!stored) {
			int index = this.getIndex(key.hashCode(),attempts);
			if(hashArray[index] == null) {  //If null, array at this index is empty.
				hashArray[index] = hash;
				storedCount+=1;
				stored = true;
			}else if(!hashArray[index].equals(hash)) {
				attempts += 1;
				hash.incrementProbeCount();
			}else {
				hashArray[index].incrementDuplicateCount();
				stored = true;
			}
		}
	}
	
	/**
	 * 
	 */
	private int positiveMod(int dividend, int divisor) {
		int value = dividend % divisor;
		if(value < 0) {
			value += divisor;
		}
		return value;
	}
	
	/**
	 * 
	 * @param k
	 * @return
	 */
	private int h1(int k) {
		return positiveMod(k,hashArray.length);  // k = key.hashcode()
	}
	
	/**
	 * 
	 * @param k
	 * @return
	 */
	private int h2(int k) {
		return 1 + positiveMod(k,hashArray.length -2); // k = key.hashcode()
	}
	
	/**
	 * 
	 * @param k
	 * @param i
	 * @return
	 */
	private int getIndex(int k, int i) {
		int index = 0; 
		if(hashMode == 0) {
			index = (this.h1(k) + i) % hashArray.length;
		}else if(hashMode == 1) {
			index = (this.h1(k) + (i*this.h2(k))) % hashArray.length;	
			}
		return index;
	}
	
	public HashObject getElement(int index) {
		return  hashArray[index];
	}
	
	public int getStoredCount() {
		return storedCount;
	}
	
	public double getTotalNumProbes() {
		totalProbeCount = 0;
		for(int i = 0; i < hashArray.length; i++) {
			if(hashArray[i] != null) {
				totalProbeCount += hashArray[i].getProbeCount();
			}
		}
		return totalProbeCount;
	}
	
	public int getTotalDuplicates() {
		int totalDuplicateCount = 0;
		for (int i=0; i < hashArray.length; i++) {
			if(hashArray[i] != null) {
				totalDuplicateCount += hashArray[i].getDuplicateCount();
			}
		}
		return totalDuplicateCount; 
	}
}
