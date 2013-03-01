/*
* ProductStats.java
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
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductStats {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "sku")
    private String sku;

    @XmlElement(name = "price")
    private float price;

    @XmlElement(name = "currency")
    private String currency;

    @XmlElement(name = "order_count")
    private int orderCount;

    @XmlElement(name = "download_count")
    private int downloadCount;

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "ProductStats{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", orderCount=" + orderCount +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
