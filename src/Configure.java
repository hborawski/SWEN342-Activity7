import java.util.regex.Pattern;

import akka.actor.ActorRef;


public class Configure {
	private String filename;
	private Pattern pattern;
	private ActorRef collect;
	
	public Configure(String filename, Pattern pattern, ActorRef c){
		this.filename = filename;
		this.pattern = pattern;
		this.collect = c;
	}
	
	public String getFilename(){
		return filename;
	}
	
	public Pattern getPattern(){
		return pattern;
	}
	
	public ActorRef getActorRef(){
		return collect;
	}
}
