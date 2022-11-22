package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.itschool.entity.Customer;
import ro.itschool.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    List<CustomerOrder> findAllByColour(String colour);

    @Query("SELECT c FROM CustomerOrder c WHERE c.colour = ?1")
    List<CustomerOrder> getMeMyOrders(String colour);

    @Query(value = "SELECT * FROM CustomerOrder  WHERE colour = ?1", nativeQuery = true)
    List<CustomerOrder> getMeMyOrdersNative(String colour);

    @Query("SELECT c FROM CustomerOrder c WHERE c.colour = :colour")
    List<CustomerOrder> getMeMyOrdersNamedParameters(@Param("colour") String colour);

}
