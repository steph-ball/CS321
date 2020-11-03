/**
 * 
 * @author steph
 * @param <T>
 *
 */
public class HashTable<T> {
	
	HashObject[] hashArray;
	private int indicator;
	private int storedCount;
	private int attempts;
	
	//Constructor
	
	/**
	 * 
	 */
	public HashTable(int m, int indicator) {
		hashArray = new HashObject[m];
		this.indicator = indicator;
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
			}else if(hashArray[index].equals(hash)) {
				hash.incrementDuplicateCount();
				stored = true;
			}
		}
		
	}
	
	/**
	 * 
	 */
	public int positiveMod(int dividend, int divisor) {
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
	public int h1(int k) {
		return positiveMod(k,hashArray.length);  // k = key.hashcode()
	}
	
	/**
	 * 
	 * @param k
	 * @return
	 */
	public int h2(int k) {
		return 1 + positiveMod(k,hashArray.length -2); // k = key.hashcode()
	}
	
	/**
	 * 
	 * @param k
	 * @param i
	 * @return
	 */
	public int getIndex(int k, int i) {
		int index = 0; 
		if(indicator == 0) {
			index = this.h1(k) + i;
			if(index >= hashArray.length) {
				index = index - hashArray.length;
			}
		}else if(indicator == 1) {
			index = this.h1(k) + (i*this.h2(k));
			if(index >= hashArray.length) {
				index = index - hashArray.length;
				System.out.println("index is here: " + index); // THIS IS FOR DEBUG ERASE WHEN DONE!!!!
			}
			
		}
		
		return index;
	}
}
