import java.util.ArrayList;

public class FileCount {
	private int count;
	private ArrayList<String> filenames;
	private String pattern;
	
	public FileCount(int count, ArrayList<String> filenames, String pattern){
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
}
