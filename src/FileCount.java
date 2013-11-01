import java.util.ArrayList;

public class FileCount {
	private int count;
	private ArrayList<String> filenames;
	
	public FileCount(int count, ArrayList<String> filenames){
		this.count = count;
		this.filenames = filenames;
	}
	
	public int getCount(){
		return count;
	}
	
	public ArrayList<String> getFilenames(){
		return filenames;
	}
}
