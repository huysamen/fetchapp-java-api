/*
* Order.java
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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "vendor_id")
    private String vendorId;

    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "last_name")
    private String lastName;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "total")
    private float total;

    @XmlElement(name = "currency")
    private String currency;

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "product_count")
    private int productCount;

    @XmlElement(name = "download_count")
    private int downloadCount;

    @XmlElement(name = "expiration_date")
    private Date expirationDate;

    @XmlElement(name = "download_limit")
    private int downloadLimit;

    @XmlElement(name = "custom_1", nillable = true)
    private String custom1;

    @XmlElement(name = "custom_2", nillable = true)
    private String custom2;

    @XmlElement(name = "custom_3", nillable = true)
    private String custom3;

    @XmlElement(name = "created_at")
    private Date createdAt;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "order_items_uri")
    private String orderItemsUri;

    @XmlElement(name = "downloads_uri")
    private String downloadsUri;

    public String getId() {
        return id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public float getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getDownloadLimit() {
        return downloadLimit;
    }

    public String getCustom1() {
        return custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getLink() {
        return link;
    }

    public String getOrderItemsUri() {
        return orderItemsUri;
    }

    public String getDownloadsUri() {
        return downloadsUri;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", total=" + total +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", productCount=" + productCount +
                ", downloadCount=" + downloadCount +
                ", expirationDate=" + expirationDate +
                ", downloadLimit=" + downloadLimit +
                ", custom1='" + custom1 + '\'' +
                ", custom2='" + custom2 + '\'' +
                ", custom3='" + custom3 + '\'' +
                ", createdAt=" + createdAt +
                ", link='" + link + '\'' +
                ", orderItemsUri='" + orderItemsUri + '\'' +
                ", downloadsUri='" + downloadsUri + '\'' +
                '}';
    }
}
