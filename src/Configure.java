import java.util.regex.*;


public class Configure {
	private String filename;
	private Pattern pattern;
	
	public Configure(String filename, Pattern pattern){
		this.filename = filename;
		this.pattern = pattern;
	}
	
	public String getFilename(){
		return filename;
	}
	
	public Pattern getPattern(){
		return pattern;
	}
}
