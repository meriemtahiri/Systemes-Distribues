package com.tahiri.inventoryservice.ENTITIES;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class, name = "fullProduct")
public interface ProductProjection {

    public Long getId();

    public String getName();

    public Integer getQuantityStock();

    public Double getPrice();

}
