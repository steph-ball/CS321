
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
		this.probeCount = 0;
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

	public T getKey() {
		return object;
	}
}
