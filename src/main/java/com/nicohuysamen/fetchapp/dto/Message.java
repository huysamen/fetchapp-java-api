package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 */

@XmlRootElement(name = "message")
public class Message {

    @XmlValue
    private String message;

    public String getMessage() {
        return message;
    }
}
