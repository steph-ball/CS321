/**
 * 
 * @author steph
 * @param <T>
 *
 */
public class HashTable<T> {
	
	HashObject[] hashArray;
	private int indicator;
	
	//Constructor
	
	/**
	 * 
	 */
	public HashTable(int m, int indicator) {
		hashArray = new HashObject[m];
		this.indicator = indicator;
	}
	
	// Methods
	
	/**
	 * 
	 * @param object
	 */
	public void addObject(T object) {
		HashObject<T> hash = new HashObject(object);
		T key = hash.getKey();
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
		return positiveMod(k,hashArray.length);
	}
	
	/**
	 * 
	 * @param k
	 * @return
	 */
	public int h2(int k) {
		return 1 + positiveMod(k,hashArray.length -2);
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
