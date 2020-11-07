import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomHashObjectGen<T> {
	
	Random rand = new Random();
	Scanner scan;
	
	public RandomHashObjectGen() throws FileNotFoundException {
		
	}
	
	public Integer nextInteger() {
		Integer result = rand.nextInt();
		return result;
	}
	
	public Long nextCurrentTime() {
		Long result = System.currentTimeMillis();
		return result;
	}
	
	public String nextString() throws FileNotFoundException {
		
		String result = null;
		if(scan.hasNext()) {
			result = scan.nextLine();
		}
		return result;
	}
	
	public void openFile() throws FileNotFoundException {
		scan = new Scanner(new File("C:\\Users\\steph\\git\\CS321\\TestingLab03\\src\\dummyFile")); // DON'T FORGET TO CHANGE THIS!!!!
	}
	
	public void closeFile() {
		scan.close();
	}
}
