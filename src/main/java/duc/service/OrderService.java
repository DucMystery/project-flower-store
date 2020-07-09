package duc.service;

import duc.model.carts.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Iterable<Order> findAll();
    Page<Order> findAll(Pageable pageable);
    Order findById(Long id);
    void save(Order order);
    void remove(Long id);
}
