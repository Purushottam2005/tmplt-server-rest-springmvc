package com.sdicons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// A model class that can be rendered to JSON and XML.

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.NONE)
public class Message {

    @XmlElement(name = "content")
    private String content;

    public Message() {
    }

    public Message(String message) {
        this.content = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
