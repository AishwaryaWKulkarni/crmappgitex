package com.csi.repository;

import com.csi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByCustEmailIdAndCustPassword(String custEmailId, String custPassword);

    List<Customer> findByCustName(String custName);
}
