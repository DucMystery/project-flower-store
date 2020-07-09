package duc.service.Impl;

import duc.model.carts.Order;
import duc.repository.OrderRepository;
import duc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void remove(Long id) {

    }
}
