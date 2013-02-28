/*
* Account.java
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

/**
 *
 */

@XmlRootElement(name = "account")
public class Account {

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "billing_email")
    private String billingEmail;

    @XmlElement(name = "shopify_address")
    private String shopifyAddress;

    @XmlElement(name = "url")
    private String url;

    @XmlElement(name = "paypal_address")
    private String paypalAddress;

    @XmlElement(name = "order_expiration_in_hours")
    private int orderExpirationInHours;

    @XmlElement(name = "download_limit_per_item")
    private int downloadLimitPerItem;

    @XmlElement(name = "api_key")
    private String apiKey;

    @XmlElement(name = "api_token")
    private String apiToken;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public String getShopifyAddress() {
        return shopifyAddress;
    }

    public String getUrl() {
        return url;
    }

    public String getPaypalAddress() {
        return paypalAddress;
    }

    public int getOrderExpirationInHours() {
        return orderExpirationInHours;
    }

    public int getDownloadLimitPerItem() {
        return downloadLimitPerItem;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiToken() {
        return apiToken;
    }
}
