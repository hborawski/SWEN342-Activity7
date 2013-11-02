import java.util.ArrayList;

import akka.actor.ActorRef;
import akka.actor.Actors;
import akka.actor.UntypedActor;

public class CollectionActor extends UntypedActor {
		private ArrayList<ActorRef> actors;
		private int messages;
		private int count;
		
		public CollectionActor(){
			actors = new ArrayList<ActorRef>();
			messages = 0;
		}
        @Override
        public void onReceive(Object arg0) throws Exception {
                // TODO Auto-generated method stub
                if(arg0 instanceof FileCount){
                		FileCount fc = (FileCount)arg0;
                		count = fc.getCount();
                		
/*                        for(int i = 0; i < count; i++){
                        	ActorRef actor = akka.actor.Actors.actorOf(ScanActor.class);
                        	actors.add(actor);
                        	actors.get(i).tell(new Configure( fc.getFilenames().get(i), fc.getPattern(), (ActorRef)this));                       	
                        }
*/
                        
                }else if(arg0 instanceof Found){
                        //print found objects
                        Found found = (Found)arg0;
                        System.out.println(found.getFilename());
                        for(String s : found.getLines()){
                                System.out.println(s);
                        }
                        messages++;
                        if(messages == count){
                        	Actors.registry().shutdownAll();
                        }
                }
        }

}
