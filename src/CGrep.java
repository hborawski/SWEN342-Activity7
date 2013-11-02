import java.util.*;
import java.util.regex.Pattern;


/**
 * Driver class that contains the main method to run the
 * program.
 * Creates a CollectionActor, starts it and sends the FileCount message
 * to it.
 * Creates one ScanActor per file, starts it and then sends the 
 * appropriate Configure message to each actor.
 */
public class CGrep {

	private static ArrayList<String> filenames;
	private static ArrayList<String> files = new ArrayList<String>();
	
	
	/**
	 * Main method to run the program.
	 * @param args
	 */
	public static void main(String args[]){
		System.out.println("Enter something");
		if(args.length > 0){
			
			String pString = args[0];
			
			for(int i=1; i<args.length; i++){
				String fileName = args[i];
				files.add(fileName);
			}
						
	
			Pattern p = Pattern.compile(pString);
			FileCount fileCount = new FileCount(5, filenames, p);
			CollectionActor colActor = new CollectionActor(); //, fileCount);
		}
	}
}
