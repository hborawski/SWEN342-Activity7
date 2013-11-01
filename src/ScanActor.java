import java.util.ArrayList;

import akka.actor.UntypedActor;


public class ScanActor extends UntypedActor {
	private ArrayList<String> lines;
	@Override
	public void onReceive(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void readFile(String fileName){
		//read file and store lines in ArrayList
	}
	
	public void sendMessage(){
		//construct and send found object to CollectionActor
	}

}
