import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * ScanActor is a class that reads a file and finds lines matching a pattern
 * @author Harris Borawski
 */
public class ScanActor extends UntypedActor {
	private ArrayList<String> lines = new ArrayList<String>();
	private ActorRef collect;
	
	/**
	 * onReceive method controls what happens when this actor gets a message
	 * @param message the message that was given to the actor
	 */
	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof Configure){
			Configure con = (Configure)message;
			readFile(con.getFilename(), con.getPattern());
			collect = con.getActorRef();
		}
		
	}
	
	/**
	 * Reads the lines of a file and matches them to the pattern 
	 * @param filename the file to read
	 * @param p the pattern to match with
	 * @throws IOException error needed to disappear
	 */
	public void readFile(String filename, Pattern p) throws IOException{
		//read file and store matching lines in ArrayList
		FileReader fr = null;
		BufferedReader reader = null;
		try{
			fr = new FileReader(new File(filename));
			reader = new BufferedReader(fr);
			String s;
			int lineNumber=0;
			while((s = reader.readLine()) != null){
				//Match line to pattern
				Matcher m = p.matcher(s);
				if(m.matches()){ // Check if it actually matches
					lines.add(lineNumber+" "+s);
				}
				lineNumber++;
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();			
		}finally{
			fr.close();
			reader.close();
			sendMessage(new Found(filename, lines));
		}
	}
	
	/**
	 * Sends a message to the collection actor
	 * @param f the Found object to send
	 */
	public void sendMessage(Found f){
		collect.tell(f);
	}

}
