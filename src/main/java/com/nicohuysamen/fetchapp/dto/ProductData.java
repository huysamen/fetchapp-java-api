/*
* ProductData.java
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
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductData {

    @XmlElement(name = "sku")
    private String sku;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private float price;

    @XmlElementWrapper(name = "files")
    @XmlElement(name = "id")
    private List<String> files;

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(final List<String> files) {
        if (this.files == null) {
            this.files = new ArrayList<String>();
        }

        this.files.addAll(files);
    }

    public void addFile(final String file) {
        if (this.files == null) {
            this.files = new ArrayList<String>();
        }

        files.add(file);
    }
}
