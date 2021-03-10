package com.customer.rest.api.controller;

import com.customer.rest.api.model.CustomerModel;
import com.customer.rest.api.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository repository;

//    @Test
//    public void find() throws Exception {
//        CustomerModel customer = new CustomerModel("qs07","Brasilia","DF","feminino","ana","guimaraes","01645846474",new Date());
//        Mockito.when(repository.findById(new BigInteger("1"))).thenReturn(Optional.of(customer));
//        this.mockMvc.perform(get("/customers"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("qs07")));
//    }
}
