package ro.itschool;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.itschool.entity.Customer;
import ro.itschool.entity.CustomerOrder;
import ro.itschool.repository.CustomerOrderRepository;
import ro.itschool.repository.CustomerRepository;

import java.time.LocalDateTime;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public void run(String... args) {

        Faker faker = new Faker();

        for (int i = 0; i < 20; i++) {

            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.setDate(LocalDateTime.now());
            customerOrder.setColour(faker.color().name());

            CustomerOrder customerOrder2 = new CustomerOrder();
            customerOrder2.setDate(LocalDateTime.now());
            customerOrder2.setColour(faker.color().name());

            CustomerOrder customerOrder3 = new CustomerOrder();
            customerOrder3.setDate(LocalDateTime.now());
            customerOrder3.setColour(faker.color().name());


            Customer customer = new Customer();
            customer.setName(faker.funnyName().name());
            customer.addOrderToCustomer(customerOrder);
            customer.addOrderToCustomer(customerOrder2);
            customer.addOrderToCustomer(customerOrder3);

            customerRepository.save(customer);
        }

        System.out.println(customerOrderRepository.findAllByColour("green"));
        System.out.println(customerOrderRepository.getMeMyOrders("red"));
        System.out.println(customerOrderRepository.getMeMyOrdersNative("plum"));
        System.out.println(customerOrderRepository.getMeMyOrdersNamedParameters("grey"));


    }


}
