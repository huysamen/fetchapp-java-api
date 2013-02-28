package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */

@XmlRootElement(name = "downloads")
public class Downloads {

    @XmlElement(name = "download", nillable = true)
    private List<Download> downloads;

    public List<Download> getDownloads() {
        return downloads;
    }
}
