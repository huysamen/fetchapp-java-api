package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */

@XmlRootElement(name = "orders")
public class Orders {

    @XmlElement(name = "order")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }
}
