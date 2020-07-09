package duc.service;

import duc.model.carts.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartItemService {
    Page<CartItem> findAll(Pageable pageable);
    Iterable<CartItem> findAll();
    CartItem findById(Long id);
    void save(CartItem cartItem);
    void remove(Long id);
}
