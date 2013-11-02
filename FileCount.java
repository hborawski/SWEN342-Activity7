import java.util.regex.Pattern;
import java.util.ArrayList;

public class FileCount {
	private int count;
	private ArrayList<String> filenames;
	private Pattern pattern;
	
	public FileCount(int count){
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}

}
