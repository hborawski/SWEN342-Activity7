import java.util.ArrayList;
import akka.actor.UntypedActor;

public class CollectionActor extends UntypedActor {
		private ArrayList<ActorRef> actors;
		private int messages;
		private int count;
		
		public CollectionActor(){
			actors = new ArrayList<ScanActor>();
			messages = 0;
		}
        @Override
        public void onReceive(Object arg0) throws Exception {
                // TODO Auto-generated method stub
                if(arg0 instanceof FileCount){
                		FileCount fc = (FileCount)arg0;
                		count = fc.getCount();
                        for(int i = 0; i < count; i++){
                        	ActorRef actor = new ScanActor();
                        	actors.add(actor);
                        	actors.get(i).tell(new Configure( fc.filenames.get(i), fc.pattern, this));                       	
                        }
                        
                }else if(arg0 instanceof Found){
                        //print found objects
                        Found found = (Found)arg0;
                        System.out.println(found.getFilename());
                        for(String s : found.getLines()){
                                System.out.println(s);
                        }
                        messages++;
                        if(messages == count){
                        	Actors.registry().shutdown();
                        }
                }
        }

}
