package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by rishabhkhanna on 03/09/16.
 */
public class Event {

    String eid;
    String eventName;
    String teacherId;
    String date;
    String description;
    String count;

    public String getDescription() {
        return description;
    }

    String topic;

    public Event() {
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCount() {

        return count;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Event(String eventName, String teacherId, String date, String description, String topic , String eid) {
        this.eid = eid;

        this.eventName = eventName;
        this.teacherId = teacherId;
        this.date = date;
        this.description = description;
        this.topic = topic;
        this.count = "0";

    }

    public Event(String count,String date, String description ,String eid, String eventName, String teacherId, String topic) {
        this.eid = eid;
        this.eventName = eventName;
        this.teacherId = teacherId;
        this.date = date;
        this.description = description;
        this.count = count;
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
