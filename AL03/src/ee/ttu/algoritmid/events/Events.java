package ee.ttu.algoritmid.events;

import java.util.HashMap;
import java.util.List;


public class Events {
    HashMap <String, Integer> map = new HashMap<>();
    int maxParticipants = 0;
    int secondMaxParticipants = 0;
    int numberOfParticipant [];

    public Events(int maxParticipants) {

    }

    public void registerParticipant(String eventName, int eventLengthMinutes, boolean freeTickets) {
        String infoAboutEvent = eventName+"."+ eventLengthMinutes+"."+freeTickets;
        this.map.put(infoAboutEvent, map.getOrDefault(infoAboutEvent, 0)+1);
        if(map.get(infoAboutEvent) > maxParticipants)
        {
            maxParticipants= map.get(infoAboutEvent);
        }
        else if( map.get(infoAboutEvent) >=secondMaxParticipants && map.get(infoAboutEvent)<= maxParticipants)
        {
            secondMaxParticipants= map.get(infoAboutEvent);
        }

        }

    public int eventPopularity(String eventName, int eventLengthMinutes, boolean freeTickets) {
        String infoAboutEvent = eventName+"."+ eventLengthMinutes+"."+freeTickets;
        return map.getOrDefault(infoAboutEvent, 0);
    }
    public int getTop1Participants() {
        return maxParticipants;
    }
    public List<Integer> getTop2Participants() {

        if ( map.size()== 0){
            return List.of(0,0);
        }
        else if ( map.size()== 1){
            return List.of(1,0);
        }
        else {
            return List.of(maxParticipants, secondMaxParticipants);
        }
    }
}



