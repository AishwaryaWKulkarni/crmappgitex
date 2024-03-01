package com.csi.service;

import com.csi.model.Customer;
import com.csi.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepo customerRepoImpl;

    public Customer signUp(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public List<Customer> saveAll(List<Customer> customerList) {
        return customerRepoImpl.saveAll(customerList);
    }

    public boolean signIn(String custEmailId, String custPassword) {

        boolean flag = false;

        Customer customer = customerRepoImpl.findByCustEmailIdAndCustPassword(custEmailId, custPassword);

        if (customer != null && customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {

            flag = true;
        }
        return flag;
    }

    public List<Customer> findAll() {
        return customerRepoImpl.findAll();
    }

    public Optional<Customer> findById(int custId) {
        return customerRepoImpl.findById(custId);
    }

    public List<Customer> findCustName(String custName) {
        return customerRepoImpl.findByCustName(custName);
    }

    public Customer update(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public void deleteById(int custId) {
        customerRepoImpl.deleteById(custId);
    }


}
