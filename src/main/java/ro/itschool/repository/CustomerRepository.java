package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);



}
