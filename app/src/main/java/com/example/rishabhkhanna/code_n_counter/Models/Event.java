package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by rishabhkhanna on 03/09/16.
 */
public class Event {

    String eventName;
    String teacherId;
    String date;
    String description;

    public String getDescription() {
        return description;
    }

    String topic;

    public Event() {
    }

    public Event(String eventName, String teacherId, String date, String description, String topic) {
        this.eventName = eventName;
        this.teacherId = teacherId;
        this.date = date;
        this.description = description;
        this.topic = topic;

    }


    public String getEventName() {
        return eventName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
