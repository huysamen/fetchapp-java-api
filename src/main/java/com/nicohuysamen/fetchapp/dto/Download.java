/*
* Download.java
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 */

@XmlRootElement(name = "download")
public class Download {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "filename")
    private String filename;

    @XmlElement(name = "product_sku")
    private String productSku;

    @XmlElement(name = "order_id")
    private String orderId;

    @XmlElement(name = "order_item_id")
    private String orderItemId;

    @XmlElement(name = "ip_address")
    private String ipAddress;

    @XmlElement(name = "downloaded_at")
    private Date downloadedAt;

    @XmlElement(name = "size_bytes")
    private int sizeInBytes;

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getProductSku() {
        return productSku;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getDownloadedAt() {
        return downloadedAt;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public String toString() {
        return "Download{" +
                "id='" + id + '\'' +
                ", filename='" + filename + '\'' +
                ", productSku='" + productSku + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", downloadedAt=" + downloadedAt +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }
}
