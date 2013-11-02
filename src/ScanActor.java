import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

import akka.actor.UntypedActor;


public class ScanActor extends UntypedActor {
	private ArrayList<String> lines = new ArrayList<String>();
	private String filename;
	private Pattern pattern;
	@Override
	public void onReceive(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		if(arg0 instanceof Configure){
			Configure con = (Configure)arg0;
			this.pattern = con.getPattern();
			this.filename = con.getFilename();
		}
		
	}
	
	public void readFile(String filename){
		//read file and store lines in ArrayList
		FileReader fr;
		try{
			fr = new FileReader(new File(filename));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fr);
		
		// read lines and match to regex
	}
	
	public void sendMessage(){
		//construct and send found object to CollectionActor
		
	}

}
