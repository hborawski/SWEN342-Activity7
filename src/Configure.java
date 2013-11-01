import java.util.regex.*;


public class Configure {
	private String filename;
	private Pattern pattern;
	
	public Configure(String filename, Pattern pattern){
		this.filename = filename;
		this.pattern = pattern;
	}
}
