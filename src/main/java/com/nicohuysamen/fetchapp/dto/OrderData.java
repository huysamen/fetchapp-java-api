/*
* OrderData.java
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
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderData {

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

    @XmlElement(name = "currency")
    private String currency;

    @XmlElement(name = "custom_1")
    private String custom1;

    @XmlElement(name = "custom_2")
    private String custom2;

    @XmlElement(name = "custom_3")
    private String custom3;

    @XmlElement(name = "expiration_date")
    private Date expirationDate;

    @XmlElement(name = "download_limit")
    private int downloadLimit;

    @XmlElement(name = "send_email")
    private boolean sendEmail;

    @XmlElement(name = "order_items")
    private OrderItemsData orderItems;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(final String vendorId) {
        this.vendorId = vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(final Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(final int downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(final boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public OrderItemsData getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(final OrderItemsData orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItemData(final OrderItemData orderItemData) {
        if (this.orderItems == null) {
            this.orderItems = new OrderItemsData();
        }

        this.orderItems.addOrderItem(orderItemData);
    }
}
