package com.customer.rest.api.controller;

import com.customer.rest.api.controller.exception.ObjectNotFoundException;
import com.customer.rest.api.model.CustomerModel;
import com.customer.rest.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping(path = "/api/list/{id}")
    public ResponseEntity listCustomer( @PathVariable("id") BigInteger id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/api/update/{id}")
    public ResponseEntity updateCustomer( @PathVariable("id") BigInteger id){
        Optional<CustomerModel> updateCustomer = repository.findById(id);
        return ResponseEntity.ok().body(updateCustomer.map(u -> repository.save(new CustomerModel(u.getId(),u.getEndereco(),u.getCidade(),u.getUf(),u.getGenero(),u.getNome(),u.getSobrenome(),u.getNumCpf(),u.getDataNascimento())))
                .orElseThrow(() -> new ObjectNotFoundException("Customer não encontrado.")));
    }

    @DeleteMapping(path = "/api/delete/{id}")
    public ResponseEntity deleteCustomer( @PathVariable("id") BigInteger id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/api/save")
    public ResponseEntity saveCustomer(@RequestBody CustomerModel customer){
        CustomerModel newCustomer = repository.save(customer);
        return  ResponseEntity.ok().body(newCustomer != null? newCustomer: new ObjectNotFoundException("Erro ao Salvar dados de pessoa."));
    }
}
