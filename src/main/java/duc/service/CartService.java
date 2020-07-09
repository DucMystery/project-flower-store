package duc.service;

import duc.model.carts.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartService {
    Page<Cart> findAll(Pageable pageable);
    Iterable<Cart> findAll();
    Cart findById(Long id);
    void save(Cart cart);
    void remove(Long id);
}
