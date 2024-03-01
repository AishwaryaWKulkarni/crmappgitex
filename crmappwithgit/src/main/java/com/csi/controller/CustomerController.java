package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);

    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Customer>> saveAll(@Valid @RequestBody List<Customer> customerList) {
        return new ResponseEntity<>(customerServiceImpl.saveAll(customerList), HttpStatus.CREATED);
    }


    @GetMapping("/signin/{email}/{pwd}")
    public ResponseEntity<Boolean> signIn(@PathVariable String email, @PathVariable String pwd) {
        return ResponseEntity.ok(customerServiceImpl.signIn(email, pwd));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findbyname/{custName}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String custName) {
        return ResponseEntity.ok(customerServiceImpl.findCustName(custName));
    }

    @PutMapping("/update/{custId}/{customer}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @Valid @RequestBody Customer customer) {
        Customer customer1 = customerServiceImpl.findById(custId).orElseThrow(() -> new RecordNotFoundException("Customer Id does not exist"));

        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustContactNo(customer.getCustContactNo());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustName(customer.getCustName());
        customer1.setCustUID(customer.getCustUID());
        customer1.setCustAccBalance(customer.getCustAccBalance());
        customer1.setCustPanCard(customer.getCustPanCard());


        return new ResponseEntity<>(customerServiceImpl.update(customer1), HttpStatus.CREATED);
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> say() {

        return ResponseEntity.ok("Welocome to GitHub");

    }


    //by gunjali
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Customer>> sortById() {
        return ResponseEntity.ok(customerServiceImpl.findAll().stream().sorted(Comparator.comparingInt(Customer::getCustId)).toList());
    }


    @DeleteMapping("/deleteById/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data Deleted SuccessFully");
    }


}
