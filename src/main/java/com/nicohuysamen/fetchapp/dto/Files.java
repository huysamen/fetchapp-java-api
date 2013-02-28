package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */

@XmlRootElement(name = "files")
public class Files {

    @XmlElement(name = "file")
    private List<File> files;

    public List<File> getFiles() {
        return files;
    }
}
