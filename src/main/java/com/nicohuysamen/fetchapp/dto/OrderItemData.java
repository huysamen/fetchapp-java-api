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

/**
 *
 */
@XmlRootElement(name = "order_item")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemData {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "sku")
    private String sku;

    @XmlElement(name = "downloads_remaining")
    private int downloadsRemaining;

    @XmlElement(name = "price")
    private float price;

    public OrderItemData() {}

    public OrderItemData(final String sku, final int downloadsRemaining, final float price) {
        this.sku = sku;
        this.downloadsRemaining = downloadsRemaining;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public int getDownloadsRemaining() {
        return downloadsRemaining;
    }

    public void setDownloadsRemaining(final int downloadsRemaining) {
        this.downloadsRemaining = downloadsRemaining;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemData{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", downloadsRemaining=" + downloadsRemaining +
                ", price=" + price +
                '}';
    }
}
