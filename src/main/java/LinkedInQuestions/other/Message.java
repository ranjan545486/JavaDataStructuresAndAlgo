package LinkedInQuestions.other;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Message {

    private  String eventId;
    private  String eventType;
    private String eventDateTime;
    private String eventVersion;
    private  String payload;

    public Message() {
        eventId = null;
        eventType = null;
        eventDateTime = null;
        eventVersion = null;
        payload = null;
    }

    public Message(String eventId, String eventType, String eventDateTime, String eventVersion, String payload) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventDateTime = eventDateTime;
        this.eventVersion = eventVersion;
        this.payload = payload;
    }

    public String getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
