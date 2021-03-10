package com.customer.rest.api.controller;

import com.customer.rest.api.controller.exception.ObjectNotFoundException;
import com.customer.rest.api.model.CustomerModel;
import com.customer.rest.api.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Api(value = "API Rest Customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @ApiOperation(value = "Retorna um Customer")
    @GetMapping(path = "/api/find/{id}")
    public ResponseEntity findCustomer( @PathVariable("id") BigInteger id){
        return ResponseEntity.ok().body(repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new ObjectNotFoundException("Customer não encontrado.")));
    }

    @ApiOperation(value = "Atualiza um Customer")
    @PutMapping(path = "/api/update/{id}")
    public ResponseEntity updateCustomer( @PathVariable("id") BigInteger id,@RequestBody CustomerModel customer){
        Optional<CustomerModel> updateCustomer = repository.findById(id);
        return ResponseEntity.ok().body(updateCustomer.map(u -> repository.save(new CustomerModel(u.getId(),customer.getEndereco(),customer.getCidade(),customer.getUf(),customer.getGenero(),customer.getNome(),customer.getSobrenome(),customer.getNumCpf(),customer.getDataNascimento())))
                .orElseThrow(() -> new ObjectNotFoundException("Erro ao gravar dados de pessoa.")));
    }

    @ApiOperation(value = "Deleta um Customer")
    @DeleteMapping(path = "/api/delete/{id}")
    public ResponseEntity deleteCustomer( @PathVariable("id") BigInteger id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Salva um novo Customer")
    @PostMapping(path = "/api/save")
    public ResponseEntity saveCustomer(@RequestBody CustomerModel customer){
        CustomerModel newCustomer = repository.save(customer);
        return  ResponseEntity.ok().body(newCustomer != null? newCustomer: new ObjectNotFoundException("Erro ao Salvar dados de pessoa."));
    }
}
