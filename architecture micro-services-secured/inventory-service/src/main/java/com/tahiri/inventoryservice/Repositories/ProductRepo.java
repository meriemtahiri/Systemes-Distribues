package com.tahiri.inventoryservice.Repositories;

import com.tahiri.inventoryservice.ENTITIES.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product, Long> {
    @RestResource(path = "/byName")
    List<Product> findByNameStartsWith(@Param("name") String name);
}
