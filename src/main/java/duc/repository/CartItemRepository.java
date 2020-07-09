package duc.repository;

import duc.model.carts.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends PagingAndSortingRepository<CartItem,Long> {
}
