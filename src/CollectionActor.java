import akka.actor.UntypedActor;


public class CollectionActor extends UntypedActor {

	@Override
	public void onReceive(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		if(arg0 instanceof FileCount){
			//start scan actors
		}else if(arg0 instanceof Found){
			//print found objects
			Found found = (Found)arg0;
			System.out.println(found.getFilename());
			for(String s : found.getLines()){
				System.out.println(s);
			}
		}
	}

}
