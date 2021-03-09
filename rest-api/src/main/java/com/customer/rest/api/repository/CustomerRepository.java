package com.customer.rest.api.repository;


import com.customer.rest.api.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, BigInteger> {
}
