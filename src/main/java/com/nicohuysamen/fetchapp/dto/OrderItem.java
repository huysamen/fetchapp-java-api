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
public class OrderItem {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "sku")
    private String sku;

    @XmlElement(name = "downloads_remaining")
    private int downloadsRemaining;

    @XmlElement(name = "price")
    private float price;

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
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", downloadsRemaining=" + downloadsRemaining +
                ", price=" + price +
                '}';
    }
}
