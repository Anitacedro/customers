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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

    @Autowired
     MockMvc mockMvc;

    @Autowired
    private CustomerController controller;

    @MockBean
    CustomerRepository repository;


//    @Test
//    public void find() throws Exception {
//        CustomerModel customerEsperado = new CustomerModel(new BigInteger("1"),"qs07","Brasilia","DF","feminino","ana","guimaraes","01645846474",new Date());
//        CustomerModel customer = new CustomerModel("qs07","Brasilia","DF","feminino","ana","guimaraes","01645846474",new Date());
//        repository.save(customer);
//        Mockito.when(repository.findById(new BigInteger("1"))).thenReturn(Optional.of(customerEsperado));
//        this.mockMvc.perform(get("/customers"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("qs07")));
//    }
}
