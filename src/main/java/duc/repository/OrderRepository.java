package duc.repository;

import duc.model.carts.Cart;
import duc.model.carts.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {

    Order findOrderByAccount_Username(String username);
}
