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
