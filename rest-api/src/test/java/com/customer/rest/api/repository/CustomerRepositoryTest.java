package com.customer.rest.api.repository;

import com.customer.rest.api.model.CustomerModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.util.Date;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
     private CustomerRepository repositoryCustomer;

    @Test
    public void saveTest(){
        CustomerModel customer = new CustomerModel("qs07","Brasilia","DF","feminino","ana","guimaraes","01645846474",new Date());
        repositoryCustomer.save(customer);
        //Assert.assertNotNull(customerNew);
        Integer count = repositoryCustomer.findAll().size();
        Assert.assertEquals(1,count.intValue());
    }

    @Test
    public void findTest(){
        CustomerModel customer = new CustomerModel("qs07","Brasilia","DF","feminino","ana","guimaraes","01645846474",new Date());
        repositoryCustomer.save(customer);
        Assert.assertNotNull(repositoryCustomer.findById(new BigInteger("1")));
    }
}
