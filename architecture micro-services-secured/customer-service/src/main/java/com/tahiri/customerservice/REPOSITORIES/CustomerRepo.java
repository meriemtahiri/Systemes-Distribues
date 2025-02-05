package com.tahiri.customerservice.REPOSITORIES;

import com.tahiri.customerservice.ENTITIES.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @RestResource(path = "/byName")
    List<Customer> findByNameStartsWith(@Param("name") String name);
}
