import java.util.*;
import java.util.regex.Pattern;

import akka.actor.ActorRef;


/**
 * Driver class that contains the main method to run the
 * program.
 * Creates a CollectionActor, starts it and sends the FileCount message
 * to it.
 * Creates one ScanActor per file, starts it and then sends the 
 * appropriate Configure message to each actor.
 */
public class CGrep {

	private static ArrayList<String> files = new ArrayList<String>();
	private static ArrayList<ActorRef> actors = new ArrayList<ActorRef>();
	
	
	/**
	 * Main method to run the program.
	 * @param args
	 */
	public static void main(String args[]){
if(args.length > 0){
			
			String pString = args[0];
			for(int i=1; i<args.length; i++){
				String fileName = args[i];
				files.add(fileName);
			}
					
			Pattern p = Pattern.compile(pString);
			FileCount fileCount = new FileCount(files.size());
			ActorRef colActor = akka.actor.Actors.actorOf(CollectionActor.class);
			colActor.start();
			colActor.tell(fileCount);
			

    		
        	for(int i=0; i< files.size(); i++){
        		ActorRef actor = akka.actor.Actors.actorOf(ScanActor.class);
        		actor.start();
        		actor.tell(new Configure( files.get(i), p, colActor));                       	
        		actors.add(actor);
        	}
			
		}
	}
}
