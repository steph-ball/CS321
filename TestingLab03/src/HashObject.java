/**
 * 
 * @author steph
 *
 * @param <T>
 */
public class HashObject <T>{
	
	private T object;
	private int duplicateCount;
	private int probeCount;
	
	// Constructor
	/**
	 * Takes in object and instantiates duplicate count
	 * and probe count.
	 * @param object
	 */
	public HashObject(T object) {
		this.object = object;
		this.duplicateCount = 0;
		this.probeCount = 1;
	}
	
	// Methods
	
	/**
	 * Increments the duplicate count
	 */
	public void incrementDuplicateCount() {
		this.duplicateCount ++;
	}
	
	/**
	 * Returns the current duplicate count
	 * @return
	 */
	public int getDuplicateCount() {
		return duplicateCount;
	}
	
	/**
	 * increments the probe count
	 */
	public void incrementProbeCount() {
		this.probeCount ++;
	}
	
	/**
	 * Returns the probe count
	 * @return
	 */
	public int getProbeCount() {
		return probeCount;
	}

	/**
	 * Returns the key 
	 * @return
	 */
	public T getKey() {
		T newO = object;
		return newO;
	}
	
	/**
	 * Overriding equals method because I want to compare the objects 
	 * in the hash, not the hash itself. 
	 * @param object
	 * @return
	 */
	public boolean equals(HashObject<T> object) {
		T key1 = object.getKey();   
		T key2 = this.getKey();
		boolean compare = false;
		if(key2.equals(key1)) {
			compare = true;
		}
		return compare;
	}
	
	public String toString() {
		String str = ""+ object + " " + this.getDuplicateCount() + " " + this.getProbeCount();
		return str;
	}
}
