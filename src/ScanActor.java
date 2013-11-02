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
import akka.actor.*;

public class ScanActor extends UntypedActor {
	private ArrayList<String> lines = new ArrayList<String>();
	private ActorRef collect;
	public ScanActor(final ActorRef ref){
		collect = ref;
	}
	@Override
	public void onReceive(Object arg0) throws Exception {
		if(arg0 instanceof Configure){
			Configure con = (Configure)arg0;
			readFile(con.getFilename(), con.getPattern());
		}
		
	}
	
	public void readFile(String filename, Pattern p) throws IOException{
		//read file and store lines in ArrayList
		FileReader fr = null;
		BufferedReader reader = null;
		try{
			fr = new FileReader(new File(filename));
			reader = new BufferedReader(fr);
			String s;
			while((s = reader.readLine()) != null){
				Matcher m = p.matcher(s);
				if(m.matches()){
					lines.add(s);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();			
		}finally{
			fr.close();
			reader.close();
			sendMessage(new Found(filename, lines));
		}
		
		// read lines and match to regex
	}
	
	public void sendMessage(Found f){
		//construct and send found object to CollectionActor
		collect.tell(f);
	}

}
