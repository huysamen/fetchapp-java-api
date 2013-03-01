/*
* OrderItemFile.java
*
* Copyright (c) 2013, Nicolaas Frederick Huysamen. All rights reserved.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301 USA
*/

package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemFile {

    @XmlElement(name = "filename")
    private String filename;

    @XmlElement(name = "guid")
    private String guid;

    @XmlElement(name = "download_count")
    private int downloadCount;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "downloads_remaining")
    private int downloadsRemaining;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "downloads")
    private Downloads downloads;

    public String getFilename() {
        return filename;
    }

    public String getGuid() {
        return guid;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public String getLink() {
        return link;
    }

    public int getDownloadsRemaining() {
        return downloadsRemaining;
    }

    public String getType() {
        return type;
    }

    public Downloads getDownloads() {
        return downloads;
    }

    @Override
    public String toString() {
        return "OrderItemFile{" +
                "filename='" + filename + '\'' +
                ", guid='" + guid + '\'' +
                ", downloadCount=" + downloadCount +
                ", link='" + link + '\'' +
                ", downloadsRemaining=" + downloadsRemaining +
                ", type='" + type + '\'' +
                ", downloads=" + downloads +
                '}';
    }
}
