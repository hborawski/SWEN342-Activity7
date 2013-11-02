import java.util.regex.Pattern;

import akka.actor.ActorRef;

/**
 * Message for the ScanActor to receive data
 * @author Harris
 */
public class Configure {
	private String filename;
	private Pattern pattern;
	private ActorRef collect;
	
	/**
	 * Constructor
	 * @param filename the file to read
	 * @param pattern the pattern to look for
	 * @param c a reference to the collection actor
	 */
	public Configure(String filename, Pattern pattern, ActorRef c){
		this.filename = filename;
		this.pattern = pattern;
		this.collect = c;
	}
	
	/**
	 * Getter for the filename
	 * @return the filename
	 */
	public String getFilename(){
		return filename;
	}
	
	/**
	 * Getter for the pattern
	 * @return the pattern
	 */
	public Pattern getPattern(){
		return pattern;
	}
	
	/**
	 * Getter for the ActorRef
	 * @return the ActorRef
	 */
	public ActorRef getActorRef(){
		return collect;
	}
}
