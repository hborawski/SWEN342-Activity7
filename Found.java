import java.util.ArrayList;
public class Found {
	private String filename;
	private ArrayList<String> lines;
	
	public Found(String filename, ArrayList<String> lines){
		this.filename = filename;
		this.lines = lines;	
	}
	
	public String getFilename(){
		return filename;
	}
	
	public ArrayList<String> getLines(){
		return lines;
	}
}
