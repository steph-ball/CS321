import java.io.FileNotFoundException;

public class HashTest {
	public static void main(String[]args) throws Exception {
		int debugLevel = 0;
		int inputType = Integer.parseInt(args[0]);
		double loadFactor = Double.parseDouble(args[1]);
		if(args.length > 2) {
			 debugLevel = Integer.parseInt(args[2]);
		}
		
	 
		PrimeFinder finder = new PrimeFinder();
		RandomHashObjectGen gen = new RandomHashObjectGen();
		//int m = 7;
		int m = finder.primeLocater(95500, 96000);
		int indicator = 0;
		int n = (int) Math.round(m*loadFactor);
		HashTable linearHashTable = new HashTable(m, 0);
		HashTable doubleHashTable = new HashTable(m,1);
		int storedCount = linearHashTable.getStoredCount();
		int totalInput = 0; 
		HashObject linearHash = null, doubleHash = null;
		String dataSource = null;
		
		if(inputType > 3) {
			throw new Exception("Input cannot be greater than 3. Please re-enter");
		}
		
		if(inputType == 3) {
			gen.openFile();
			//openfile
		}
		while(storedCount < n) {
			if(inputType == 1) {
				Integer genHash = gen.nextInteger();
				linearHash = new HashObject(genHash);
				doubleHash = new HashObject(genHash);
				dataSource = "java.util.Random";
			}else if(inputType == 2) {
				Long genHash = gen.nextCurrentTime(); 
				linearHash = new HashObject(genHash);
				doubleHash = new HashObject(genHash);
				dataSource = "System.currentTimeMillis()";
			}else {
				String genHash = gen.nextString();
				linearHash = new HashObject(genHash);
				doubleHash = new HashObject(genHash);
				dataSource = "word-list";
			} 
			totalInput++;
			linearHashTable.addObject(linearHash);
			doubleHashTable.addObject(doubleHash);
			storedCount = linearHashTable.getStoredCount();
		}
		if(inputType == 3) {
			gen.closeFile();
		}
	
			double avgLinearProbes = (linearHashTable.getTotalNumProbes() / n);
			double avgDoubleProbes = (doubleHashTable.getTotalNumProbes() / n);
			System.out.println("A good table size is found: " + m);
			System.out.println("Data source type: " + dataSource);
			System.out.println();
			System.out.println();
			System.out.println("Using Linear Hashing...");
			System.out.println("Input " + totalInput + " elements, of which " + linearHashTable.getTotalDuplicates() + " duplicates");
			System.out.println("load factor = " + loadFactor + ", AVg. no. of probes " + avgLinearProbes);
			System.out.println();
			System.out.println();
			System.out.println("Using Double Hashing...");
			System.out.println("load factor = " + loadFactor + ", AVg. no. of probes " + avgDoubleProbes);                
			
			if(debugLevel == 1) {
				for(int i = 0; i < m; i++) {
					if(doubleHashTable.getElement(i) != null) {
					System.out.println(doubleHashTable.getElement(i));
					}
				}
			}
	}
}
