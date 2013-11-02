import java.util.regex.Pattern;
import java.util.ArrayList;

public class FileCount {
	private int count;
	private ArrayList<String> filenames;
	private Pattern pattern;
	
	public FileCount(int count, ArrayList<String> filenames, Pattern pattern){
		this.count = count;
		this.filenames = filenames;
		this.pattern = pattern;
	}
	
	public int getCount(){
		return count;
	}
	
	public ArrayList<String> getFilenames(){
		return filenames;
	}
	
	public Pattern getPattern(){
		return pattern;
	}
}
