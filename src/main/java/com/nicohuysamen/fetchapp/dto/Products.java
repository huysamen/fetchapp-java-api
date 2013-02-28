package com.nicohuysamen.fetchapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */

@XmlRootElement(name = "products")
public class Products {

    @XmlElement(name = "product")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
