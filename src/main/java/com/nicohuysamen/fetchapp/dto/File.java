package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */

@XmlRootElement(name = "file")
public class File {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "filename")
    private String filename;

    @XmlElement(name = "guid")
    private String guid;

    @XmlElement(name = "size_in_bytes")
    private int sizeInBytes;

    @XmlElement(name = "content_type")
    private String contentType;

    @XmlElement(name = "download_count")
    private int downloadCount;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "permalink")
    private String permalink;

    @XmlElement(name = "url", nillable = true)
    private String url;

    @XmlElement(name = "downloads_remaining")
    private int downloadsRemaining;

    @XmlElement(name = "downloads")
    private List<Download> downloads;

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getGuid() {
        return guid;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public String getContentType() {
        return contentType;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public String getLink() {
        return link;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getUrl() {
        return url;
    }

    public int getDownloadsRemaining() {
        return downloadsRemaining;
    }

    public List<Download> getDownloads() {
        return downloads;
    }

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", filename='" + filename + '\'' +
                ", guid='" + guid + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                ", contentType='" + contentType + '\'' +
                ", downloadCount=" + downloadCount +
                ", link='" + link + '\'' +
                ", permalink='" + permalink + '\'' +
                ", url='" + url + '\'' +
                ", downloadsRemaining=" + downloadsRemaining +
                ", downloads=" + downloads +
                '}';
    }
}
