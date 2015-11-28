import definitions.kYouActivities;
import definitions.Moods;

import java.sql.Timestamp;

/**
 * Created by itaimendelsohn on 11/26/15.
 * represents the basic evetn for an activity ML class. shall be extended per activity type using inheritance (later..)
 */

public class MLEvent {
    // the ID of kYou user
    int personID;

    // event time stamp - only yy-mm-dd, hh-mm . seconds and below is not in use
    Timestamp timeStamp;

    // event type for kYou initiated events
    kYouActivities kYouActivityType = kYouActivities.NONE;

    // meta-data - for now an int, later will be extended
    int metaData;

    // states (might change per activity type) and are generated by query the raw (simEvent) data
    Moods moodState; // the avg mood of the elder in the last hour (?) TODO: define the way we calculate it
    boolean wasActiveState; // true if did any activity in the last hour(?)
    boolean ateState; //true if ate "lately" (last hour?)
    boolean spokeState; // true if spoke with someone in the last hour (?)
    // TODO add more states


    public MLEvent(int personID, Timestamp timeStamp, kYouActivities kYouActivityType, int metaData) {
        this.personID = personID;
        this.timeStamp = timeStamp;
        this.kYouActivityType = kYouActivityType;
        this.metaData = metaData;
    }

    public void setMoodState(Moods moodState) {
        this.moodState = moodState;
    }

    public void setWasActiveState(boolean wasActiveState) {
        this.wasActiveState = wasActiveState;
    }

    public void setAteState(boolean ateState) {
        this.ateState = ateState;
    }

    public void setSpokeState(boolean spokeState) {
        this.spokeState = spokeState;
    }

    @Override
    public String toString() {
        return "MLEvent{" +
                "personID=" + personID +
                ", timeStamp=" + timeStamp +
                ", kYouActivityType=" + kYouActivityType +
                ", metaData=" + metaData +
                ", moodState=" + moodState +
                ", wasActiveState=" + wasActiveState +
                ", ateState=" + ateState +
                ", spokeState=" + spokeState +
                '}';
    }
}
