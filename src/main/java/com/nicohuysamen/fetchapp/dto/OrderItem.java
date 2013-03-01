/*
* OrderItem.java
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
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "order_item")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "sku")
    private String sku;

    @XmlElement(name = "order_id")
    private String orderId;

    @XmlElement(name = "product_name")
    private String productName;

    @XmlElement(name = "price")
    private float price;

    @XmlElement(name = "download_count")
    private int downloadCount;

    @XmlElement(name = "custom_1", nillable = true)
    private String custom1;

    @XmlElement(name = "custom_2", nillable = true)
    private String custom2;

    @XmlElement(name = "custom_3", nillable = true)
    private String custom3;

    @XmlElement(name = "created_at")
    private Date createdAt;

    @XmlElement(name = "files_uri")
    private String filesUri;

    @XmlElement(name = "downloads_uri")
    private String downloadsUri;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(final int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(final String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(final String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(final String custom3) {
        this.custom3 = custom3;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFilesUri() {
        return filesUri;
    }

    public void setFilesUri(final String filesUri) {
        this.filesUri = filesUri;
    }

    public String getDownloadsUri() {
        return downloadsUri;
    }

    public void setDownloadsUri(final String downloadsUri) {
        this.downloadsUri = downloadsUri;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", downloadCount=" + downloadCount +
                ", custom1='" + custom1 + '\'' +
                ", custom2='" + custom2 + '\'' +
                ", custom3='" + custom3 + '\'' +
                ", createdAt=" + createdAt +
                ", filesUri='" + filesUri + '\'' +
                ", downloadsUri='" + downloadsUri + '\'' +
                '}';
    }
}
